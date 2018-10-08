package ecjtu.cloud_note.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ecjtu.cloud_note.entity.User;
import ecjtu.cloud_note.service.UserService;
import ecjtu.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/user")
public class UserLoginController {
	@Resource
	private UserService userService;
	
	
	@RequestMapping("/login.do")
	@ResponseBody
	public NoteResult<User> userLoginController(String name,String password,String code) {
		
		//System.out.println(name+","+password);
		NoteResult<User> result = userService.checkLogin(name, password,code);
		//System.out.println(code);
		
		//System.out.println(result);
		return result;
	}
	
	
	
}










