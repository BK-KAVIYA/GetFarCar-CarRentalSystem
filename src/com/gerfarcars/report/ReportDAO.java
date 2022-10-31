
package com.gerfarcars.report;

import com.getfarcar.common.User;
import java.util.List;

/**
 *
 * @author KA VI YA
 */
public interface ReportDAO {
    public List<Report> ReportList();
    public List<Report> AdminReportList();
    public List<Report> AdminCarAvailability();
}
