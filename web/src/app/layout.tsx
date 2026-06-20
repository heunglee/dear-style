import type { Metadata } from "next";
import type { ReactNode } from "react";

import { AppHeader } from "@/components/app-header";
import { QueryProvider } from "@/components/query-provider";
import "./globals.css";

export const metadata: Metadata = {
  title: "Dear Style",
  description: "AI makeup coaching from Dear Daughter Beauty"
};

export default function RootLayout({
  children
}: Readonly<{
  children: ReactNode;
}>) {
  return (
    <html lang="en">
      <body>
        <QueryProvider>
          <div className="app-shell">
            <div className="page">
              <AppHeader />
              {children}
            </div>
          </div>
        </QueryProvider>
      </body>
    </html>
  );
}
