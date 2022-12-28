package com.sm.graduation;

import com.sm.graduation.admin.dao.AdminInfoMapper;
import com.sm.graduation.admin.pojo.AdminInfo;
import com.sm.graduation.health.pojo.HealthRecords;
import com.sm.graduation.health.service.HealthRecordsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class GraduationApplicationTests {

    @Autowired
    HealthRecordsService healthRecordsService;

    @Test
    void contextLoads() {
        final List<HealthRecords> healthRecords = healthRecordsService.listAll(null);
        System.out.println(healthRecords);
    }
}
