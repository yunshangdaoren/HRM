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
	
	/**默认是fixedDelay 上一次执行完毕时间后执行下一轮*/
    @Scheduled(cron = "0 27 23 * * ?")
    public void run() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"-------------------------");
    }
}
