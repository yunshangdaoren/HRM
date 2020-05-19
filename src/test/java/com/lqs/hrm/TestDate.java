package com.lqs.hrm;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TestDate {
	public static void main(String[] args) throws ParseException {
		 Long time = System.currentTimeMillis(); // 当前时间的时间戳
		 long zero = time / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();// 今天零点零分零秒的毫秒数
		 long twelve = zero + 24 * 60 * 60 * 1000 - 1;// 今天23点59分59秒的毫秒数
		// System.out.println("今天零点零分零秒:" + new Timestamp(zero));// 今天零点零分零秒
		 //System.out.println("今天23点59分59秒:" + new Timestamp(twelve));// 今天23点59分59秒
		// System.out.println("======================================");
		 
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date = new Date();
		 SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		 //00:00:00
		 Date zeroDate = format.parse(format2.format(date)+" 00:00:00");
		 //23:59:59
		 Date twelveStrDate = format.parse(format2.format(date)+" 23:57:59");
		 
		 
		 String idCard = "500235199609138011";
		 System.out.println(idCard.substring(6, 10)+"-"+idCard.substring(10, 12)+"-"+idCard.substring(12, 14));
		 System.out.println("========");
		 String dateStr = "2020-05-20";
		 int num = 0;
		 if (num < 10) {
			
		}
		System.out.println(dateStr.substring(0,4) + dateStr.substring(5, 7)+ dateStr.substring(8, 10) + String.valueOf(0+1));
		 
	}
}
