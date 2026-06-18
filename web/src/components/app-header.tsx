"use client";

import Link from "next/link";
import { useRouter } from "next/navigation";
import { useCallback, useEffect, useState } from "react";

import { getMe, type User } from "@/lib/api";
import { authChangedEventName, clearAccessToken, getAccessToken } from "@/lib/auth-storage";

export function AppHeader() {
  const router = useRouter();
  const [user, setUser] = useState<User | null>(null);
  const [isCheckingAuth, setIsCheckingAuth] = useState(true);

  const refreshUser = useCallback(async () => {
    const token = getAccessToken();
    if (!token) {
      setUser(null);
      setIsCheckingAuth(false);
      return;
    }

    setIsCheckingAuth(true);
    try {
      setUser(await getMe());
    } catch {
      clearAccessToken();
      setUser(null);
    } finally {
      setIsCheckingAuth(false);
    }
  }, []);

  useEffect(() => {
    refreshUser();

    function handleStorage(event: StorageEvent) {
      if (event.key === "dear-style.access-token") {
        refreshUser();
      }
    }

    window.addEventListener(authChangedEventName, refreshUser);
    window.addEventListener("storage", handleStorage);
    window.addEventListener("focus", refreshUser);

    return () => {
      window.removeEventListener(authChangedEventName, refreshUser);
      window.removeEventListener("storage", handleStorage);
      window.removeEventListener("focus", refreshUser);
    };
  }, [refreshUser]);

  function handleLogout() {
    clearAccessToken();
    setUser(null);
    router.push("/");
  }

  return (
    <header className="topbar">
      <Link className="brand" href="/">
        <strong>Dear Style</strong>
        <span>Dear Daughter Beauty</span>
      </Link>
      <nav className="nav-actions" aria-label="Primary">
        {user ? (
          <>
            <Link className="profile-chip" href="/upload" title={user.email}>
              <span>{initialForUser(user)}</span>
              <strong>{user.display_name || user.email}</strong>
            </Link>
            <Link className="button button-primary" href="/upload">
              Test
            </Link>
            <button className="button button-ghost" onClick={handleLogout} type="button">
              Log out
            </button>
          </>
        ) : (
          <>
            <Link className="button button-ghost" href="/login">
              {isCheckingAuth ? "Checking..." : "Log in"}
            </Link>
            <Link className="button button-secondary" href="/signup">
              Sign up
            </Link>
          </>
        )}
      </nav>
    </header>
  );
}

function initialForUser(user: User) {
  const source = user.display_name || user.email;
  return source.trim().charAt(0).toUpperCase() || "D";
}
