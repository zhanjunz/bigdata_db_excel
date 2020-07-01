package com.example.bigdata.service;

import com.example.bigdata.dao.User;
import com.example.bigdata.utils.ExcelUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author zhanjun
 * date 2020-07-01
 */
@Service
public class ExportReportServcieImp implements ExportReportServcie {
    @Override
    public void exportReport(HttpServletResponse response, List<Map> users) {

        String[] usertableHeadValue = new String[]{"ID", "姓名", "邮箱", "手机号", "性别", "密码", "年龄", "创建时间", "修改时间"};

        String[] userTableKey = new String[]{"id", "name", "email", "phone", "gender", "password", "age", "create_time", "update_time"};
        try {
            long lc = System.currentTimeMillis();

            // 大数据量导出
            ExcelUtil.exportBigDataExcel(response, userTableKey, usertableHeadValue, users, "导出角色", "xlsx", "C:/excel/");
            long l2 = System.currentTimeMillis();

            System.out.println("导出数据时需要多少时间：" + (l2 - lc));
            // .导出1107258条数据。07版excel导出数据时需要时间：30539ms
        } catch (Exception e) {
            System.err.println("导出数据时出错{}" + e.toString());
        }
    }
}
