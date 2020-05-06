package com.lqs.hrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lqs.hrm.entity.PositionLevel;
import com.lqs.hrm.json.JsonCommonResult;
import com.lqs.hrm.service.impl.PositionLevelServiceImpl;

@Controller
@RequestMapping("positionLevel")
public class PositionLevelController {
	@Autowired
	private PositionLevelServiceImpl positionLevelService;
	
	
	@RequestMapping("list.do")
	@ResponseBody
	public JsonCommonResult<List<PositionLevel>> list(){
		System.out.println("===================进入到获取职位级别Controller");
		List<PositionLevel> positionLevelList = positionLevelService.list();
		if (positionLevelList.size() ==0 || positionLevelList == null) {
			return new JsonCommonResult<List<PositionLevel>>("100", null, "没有查询到数据！");
		}
		return new JsonCommonResult<List<PositionLevel>>("200", positionLevelList, "请求成功！");
	}
	
	
	
}
