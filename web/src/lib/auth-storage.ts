const tokenKey = "dear-style.access-token";

export function getAccessToken() {
  if (typeof window === "undefined") {
    return null;
  }

  return window.localStorage.getItem(tokenKey);
}

export function setAccessToken(token: string) {
  window.localStorage.setItem(tokenKey, token);
}

export function clearAccessToken() {
  window.localStorage.removeItem(tokenKey);
}
