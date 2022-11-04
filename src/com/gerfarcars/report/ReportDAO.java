
package com.gerfarcars.report;

import java.util.List;

/**
 *
 * @author KA VI YA
 */
public interface ReportDAO {
    public void Add(Report report);
    public List<Report> ReportList();
    public List<Report> InvoiceList(String CID);
    public List<Report> AdminReportList();
    public List<Report> AdminCarAvailability();
    public double get_Precentage();
}
