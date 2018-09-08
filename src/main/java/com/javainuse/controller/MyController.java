package com.javainuse.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



import com.javainuse.model.User;
import com.javainuse.service.EmployeeService;



@Controller
public class MyController {
	@Autowired
	private EmployeeService empService; 

	
	

	@RequestMapping("/")
	public String welcome() {
		System.out.println("welcome to project");
		return "hello";
	}

	@RequestMapping(value = "/insertUser", method = RequestMethod.GET)
	public ModelAndView insertUser() {

		return new ModelAndView("user", "user", new User());
	}

	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	public String insertUser1(@ModelAttribute("user") User user) {
		 
		

		empService.insertUser(user);

		return "hello";
	}

	
	@RequestMapping(value = "/insertObject", method = RequestMethod.GET)
	public ModelAndView insertObject() {

		return new ModelAndView("object", "object", new User());
	}

	@RequestMapping(value = "/insertObject", method = RequestMethod.POST)
	public String insertObject1(@ModelAttribute("object") User user) {
		

		empService.insertObject(user);

		return "hello";
	}

	
	@RequestMapping(value = "insertPermissionForUsers", method = RequestMethod.GET)
	public ModelAndView getObjects() {
		
		List<User> list = empService.getAllUsers();
		List<User> list1 = empService.getAllObjects();
		ModelAndView model = new ModelAndView("insertDataForUserPermission");
		System.out.println();
		model.addObject("user", list);
		model.addObject("user1", list1);
		return model;
	}

	@RequestMapping(value = "insertPermissionForUsers", method = RequestMethod.POST)
	public String insertPermission(@RequestParam("user") String username, @RequestParam("object") String[] objectname,
			@RequestParam("permission") String[] permission) {
		
		

		empService.insertPermission(username, objectname, permission);

		return "hello";
	}
	@RequestMapping(value = "insertPermissionForGroup", method = RequestMethod.GET)
	public ModelAndView get() {
		
		List<User> list = empService.getAllGroup();
		System.out.println(list);
		List<User> list1 = empService.getAllObjects();
		ModelAndView model = new ModelAndView("insertGroupPermission");
		
		model.addObject("group", list);
		model.addObject("user1", list1);
		return model;
	}

	@RequestMapping(value = "insertPermissionForGroup", method = RequestMethod.POST)
	public String insertPermission1(@RequestParam("user") String groupname, @RequestParam("object") String[] objectname,
			@RequestParam("permission") String[] permission) {
		System.out.println(groupname);
		

		empService.insertPermission1(groupname, objectname, permission);

		return "hello";
	}
	
	@RequestMapping(value = "groupUser", method = RequestMethod.GET)
	public ModelAndView getPermission1() {
		
		
			
			List<User> list = empService.getAllUsers();
			ModelAndView model = new ModelAndView("createPermission");
			
			model.addObject("user", list);
			return model;
			}
	@RequestMapping(value = "groupUser", method = RequestMethod.POST)
	public String getPermission1(@RequestParam("user") String username,@RequestParam("groupname") String groupname) {
		

		empService.groupUsertabel(username,groupname);

		return "hello";
	}
	@RequestMapping(value = "getPermission", method = RequestMethod.GET)
	public ModelAndView getPermission() {
		
		List<User> list = empService.getAllUsers();
		List<User> list1 = empService.getAllObjects();
		ModelAndView model = new ModelAndView("Getpermission");
		System.out.println();
		model.addObject("user", list);
		model.addObject("user1", list1);
		return model;
	}
	@RequestMapping(value = "getPermission", method = RequestMethod.POST)
	public ModelAndView getPermission(@RequestParam("user") String userName,@RequestParam("object") String objectName) {
		
		
		String permission=empService.userObject(userName,objectName);
		System.out.println(permission);
		ModelAndView model = new ModelAndView("permission123");
		 model.addObject("hello",permission);
		 model.addObject("object",objectName);
		

		return model;
}
	@RequestMapping(value = "adminObject", method = RequestMethod.POST)
	public String  getPermission21(@RequestParam("data") String data,@RequestParam("objectname") String objectName) {
		

		System.out.println(data+""+ objectName);
		empService.userObject1(data,objectName);
		empService.userObject2(objectName);
		ModelAndView model = new ModelAndView("");
		
		
		

		return "hello";
}
	@RequestMapping(value = "writeObject", method = RequestMethod.POST)
	public String getPermission22(@RequestParam("data") String data,@RequestParam("objectname") String objectName) {
		

		System.out.println(data+""+ objectName);
		empService.userObject1(data,objectName);
		
		
		
		
		

		return "hello";
	}
	
}
	