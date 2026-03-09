package com.example.reports;

/**
 * Viewer now uses the Report interface (via Proxy).
 */
public class ReportViewer {

    public void open(Report report, User user) {
        report.display(user);
    }
}
