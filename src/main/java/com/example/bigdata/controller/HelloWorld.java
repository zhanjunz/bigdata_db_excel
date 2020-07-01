package com.example.bigdata.controller;

import com.example.bigdata.dao.User;
import com.example.bigdata.entity.UserDO;
import com.example.bigdata.mapper.UserMapper;
import com.example.bigdata.service.ExportReportServcie;
import com.example.bigdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author zhanjun
 * date 2020-06-30
 */
@RestController
@RequestMapping("/db")
public class HelloWorld {

    @Autowired
    private UserService userService;

    @Autowired
    private ExportReportServcie exportReportServcie;

    @GetMapping("/user")
    public User selectUserByName(String name) {
        long oldtime = System.currentTimeMillis();
        Map<String, User> map = userService.selectUserByName(name);
        long newTime = System.currentTimeMillis();
        System.out.println(newTime - oldtime);
        return map.get(name);

    }

    @GetMapping("/user/all")
    public int selectAllUsers() {
        long oldtime = System.currentTimeMillis();
        List<Map> users = userService.selectAllUsers();
        long newTime = System.currentTimeMillis();
        System.out.println(newTime - oldtime);
        return users.size();
    }

    @GetMapping("/user/report")
    public String exportUserReport(HttpServletResponse response) {
        System.out.println("========START QUERY==========");

        long oldtime = System.currentTimeMillis();
        List<Map> users = userService.selectAllUsers();
        long newTime = System.currentTimeMillis();
        System.out.println("========END QUERY==========");
        System.out.println("查询耗时：" + (newTime - oldtime));

        if (users == null || users.isEmpty()) {
            return "没有数据";
        }

        System.out.println("========START EXPORT==========");
        long startExport = System.currentTimeMillis();
        exportReportServcie.exportReport(response, users);
        System.out.println("========END EXPORT==========");
        System.out.println("导出耗时：" + (System.currentTimeMillis() - startExport));
        return "导出成功";
    }
}
