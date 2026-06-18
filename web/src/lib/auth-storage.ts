const tokenKey = "dear-style.access-token";
export const authChangedEventName = "dear-style.auth-changed";

export function getAccessToken() {
  if (typeof window === "undefined") {
    return null;
  }

  return window.localStorage.getItem(tokenKey);
}

export function setAccessToken(token: string) {
  window.localStorage.setItem(tokenKey, token);
  window.dispatchEvent(new Event(authChangedEventName));
}

export function clearAccessToken() {
  window.localStorage.removeItem(tokenKey);
  window.dispatchEvent(new Event(authChangedEventName));
}
