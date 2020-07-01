package com.example.bigdata.service;


import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author zhanjun
 * date 2020-07-01
 */
public interface ExportReportServcie {

    public void exportReport(HttpServletResponse response, List<Map>  users);
}
