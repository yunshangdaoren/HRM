package com.lqs.hrm.scheduling;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 职工入职数量统计定时任务
 * 每天凌晨00:00:00自动生成当天的职工入职数量统计记录
 * @author luckyliuqs
 *
 */
@Component
@EnableScheduling
public class EmployeeEntryCount {
	
    @Scheduled(cron = "0 27 23 * * ?")
    public void run() throws InterruptedException {
       //定时完成任务代码
    }
}
