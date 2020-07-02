package com.example.bigdata.controller;

import com.example.bigdata.dao.MengNiuUser;
import com.example.bigdata.dao.User;
import com.example.bigdata.service.ExportReportServcie;
import com.example.bigdata.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;
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
    public String exportUserReport() {
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
        exportReportServcie.exportReport(users);
        System.out.println("========END EXPORT==========");
        System.out.println("导出耗时：" + (System.currentTimeMillis() - startExport));
        return "导出成功";
    }
    @GetMapping("/user/insert")
    public String insertMengNiuUsers() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 5, 2);

        for (int i = 17716; i <= 30000; i++) {
            MengNiuUser user = new MengNiuUser();
            user.setType(i % 3 == 0 ? "C" : "B");
            user.setName("用户" + i);
            user.setUid(String.valueOf(i));
            user.setPhone("18628067510");
            user.setRole(i % 5 == 0 ? "消费者" : "导购");
            user.setSign_in_count(i);
            user.setDraw_count(i);
            user.setWin_count(i);
            user.setPlay_game_count(i);
            user.setUpload_receipt_count(i);
            user.setJd_exchange_count(i);
            user.setB_register_count(i);
            user.setPoint(i);
            user.setStatistics_date(i % 3 == 0 ? new Date() : calendar.getTime());
            userService.insertMengNiuUser(user);
        }

        return "插入成功";
    }
}
