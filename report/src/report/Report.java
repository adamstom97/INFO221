/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import dao.DaoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * A class for generating reports based on the shop's orders, or a specific 
 * order if the orderID is provided.
 * 
 * @author adath325
 * @version 4.0
 */
public class Report {
    String sql = "SELECT * FROM order_receipt";
    
    public Report(String orderID) {
        sql = "SELECT * FROM order_receipt WHERE orderID=" + orderID;
    }
    
    public void createReport() {
        try (Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost:9097/project;IFEXISTS=TRUE", "sa", "");
                PreparedStatement stmt = con.prepareStatement(sql);) {
            ResultSet rs = stmt.executeQuery();
            try {
            JasperPrint report = JasperFillManager.fillReport("h:/INFO221/reports/receipt.jasper",
                            new HashMap<String, Object>(), new JRResultSetDataSource(rs));
            JasperViewer.viewReport(report);
            JasperExportManager.exportReportToPdfFile(report, "h:/INFO221/reports/receipt.pdf");
            } catch (JRException ex) {
                throw new DaoException(ex.getMessage(), ex);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage(), ex);
        }
    }

}
