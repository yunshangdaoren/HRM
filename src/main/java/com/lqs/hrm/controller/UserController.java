package com.lqs.hrm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.lqs.hrm.entity.Department;
import com.lqs.hrm.entity.Employee;
import com.lqs.hrm.entity.EmployeePosition;
import com.lqs.hrm.entity.Position;
import com.lqs.hrm.entity.Status;
import com.lqs.hrm.entity.User;
import com.lqs.hrm.entity.UserRole;
import com.lqs.hrm.json.JsonCommonResult;
import com.lqs.hrm.service.impl.StatusServiceImpl;
import com.lqs.hrm.service.impl.UserServiceImpl;
import com.lqs.hrm.util.PageRequest;
import com.lqs.hrm.util.PageResult;
import com.lqs.hrm.util.PageResultUtil;
import com.lqs.hrm.util.entity.UserInfoUtil;

/**
 * 用户信息Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private UserInfoUtil userInfoUtil;
	@Autowired
	private StatusServiceImpl statusService;
	
	/**
	 * 跳转至所有系统用户列表页面
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 */
	@RequestMapping("toUserList.do")
	public String toUserList(HttpServletRequest request, PageRequest pageRequest, ModelMap map){
		//查询条件信息
		//用户账户
		String userAccountStr = request.getParameter("userAccount");
		//账户状态
		String statusIdStr = request.getParameter("statusId");
		//分页
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
		List<User> userList = new ArrayList<>();
		//查询条件判断
		if (StringUtil.isEmpty(userAccountStr) && StringUtil.isEmpty(statusIdStr)) {
			//如果查询的条件全部为空，则查询出所有账户信息
			userList = userService.listByNoExceptSuperManager();
		}else if(StringUtil.isEmpty(statusIdStr)) {
			//则根据账户查询
			userList.add(userService.get(userAccountStr));
		}else if(StringUtil.isEmpty(userAccountStr)){
			//则根据账户状态询
			userList = userService.listByStatusId(Integer.valueOf(statusIdStr));
		}else {
			//根据账户，账户状态查询
			userList = userService.listByUserAccountStatusId(userAccountStr, Integer.valueOf(statusIdStr));
		}
		userInfoUtil.setUserInfo(userList);
		//设置分页查询结果
		PageResult pageResult = PageResultUtil.getPageResult(new PageInfo<>(userList));
		//返回查询的部门信息
		map.put("pageResult", pageResult);
		//回显查询条件
		map.put("userAccountStr", userAccountStr);
		map.put("statusIdStr", statusIdStr);
		
		//系统账户状态信息:类型为1
		List<Status> statusList = statusService.list(1);
		//返回查询的系统账户状态信息
		map.put("statusList", statusList);
		return "system/userList";
	}
	

	/**
	 * 并跳转至个人账户信息页面
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 */
	@RequestMapping("toMyUserInfo.do")
	public String toMyUserInfo(HttpServletRequest request, PageRequest pageRequest, ModelMap map){
		//获取当前登录系统人工号
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("session_loginUser");
		User user = userService.get(currentUser.getUserAccount());
		userInfoUtil.setUserInfo(user);
		//返回查询的系统账户信息
		map.put("user", user);
		//系统账户状态信息:类型为1
		List<Status> statusList = statusService.list(1);
		//返回查询的系统账户状态信息
		map.put("statusList", statusList);
		return "system/myUserInfo";
	}
	
	/**
	 * 跳转至修改账户信息页面
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 */
	@RequestMapping("toUpdateUserInfo.do")
	public String toUpdateUserInfo(HttpServletRequest request, PageRequest pageRequest, ModelMap map){
		//用户账户
		String userAccountStr = request.getParameter("userAccount");
		User user = userService.get(userAccountStr);
		userInfoUtil.setUserInfo(user);
		//返回查询的系统账户信息
		map.put("user", user);
		//系统账户状态信息:类型为1
		List<Status> statusList = statusService.list(1);
		//返回查询的系统账户状态信息
		map.put("statusList", statusList);
		return "system/updateUserInfo";
	}
	
	/**
	 * 修改密码
	 * @param u
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("changeUserPwd.do")
	public String changeUserPwd(String currentUserPwd, String newUserPwd, HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> resultMap = new HashMap<>();
		//获取当前登录用户的密码
		HttpSession session = request.getSession();
		User sessionLoginUser = (User) session.getAttribute("session_loginUser");
		String userPwd = sessionLoginUser.getUserPwd();
		
		//判断密码跟输入的当前密码是否一致
		if(!userPwd.equals(currentUserPwd)) {
			//不一致则返回报错
			resultMap.put("statusCode", 0);
			resultMap.put("message", "当前密码错误!");
			return JSON.toJSONString(resultMap);
		}
		//密码一致，则修改密码
		//更新Session里面的用户密码信息
		sessionLoginUser.setUserPwd(newUserPwd);
		int statusCode = userService.update(sessionLoginUser.getUserAccount(), newUserPwd);
		if(statusCode == 1) {
			resultMap.put("statusCode", statusCode);
			resultMap.put("message", "修改成功！");
		}else {
			resultMap.put("statusCode", 0);
			resultMap.put("message", "修改失败！");
		}
		return JSON.toJSONString(resultMap);
	}
	
	@RequestMapping("get")
	@ResponseBody
	public User get(String userAccount) {
		return userService.get(userAccount);
	}
	
	/**
	 * 修改账户信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("update.do")
	@ResponseBody
	public JsonCommonResult<Object> update(HttpServletRequest request) {
		//获取账户
		String userAccountStr = request.getParameter("userAccount");
		//获取密码信息
		String userPwdStr = request.getParameter("userPwd");
		//获取用户名称
		String userNameStr = request.getParameter("userName");
		//获取安全邮箱
		String securityMailStr = request.getParameter("securityMail");
		//获取账户状态
		String statusIdStr = request.getParameter("statusId");
		
		User user = userService.get(userAccountStr);
		if (user != null) {
			//重新设置密码信息
			user.setUserPwd(userPwdStr);
			//重新设置用户名称
			user.setUserName(userNameStr);
			//重新设置安全邮箱
			user.setSecurityMail(securityMailStr);
			//重新设置账户状态
			user.setStatusId(Integer.valueOf(statusIdStr));
			
			//获取当前登录系统人工号
			HttpSession session = request.getSession();
			User currentUser = (User) session.getAttribute("session_loginUser");
			if (currentUser == null) {
				return new JsonCommonResult<Object>("100", null, "请先登录！");
			}
			//设置最后一次操作人工号
			user.setOperatorEmpjobid(currentUser.getUserAccount());
			int result = userService.update(user);
			if (result == 0) {
				return new JsonCommonResult<Object>("100", null, "修改失败！");
			}
			return new JsonCommonResult<>("200", null, "修改成功");
		}
		return new JsonCommonResult<Object>("100", null, "最终修改失败！");
	}
	
	
	
}
