package ecjtu.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ecjtu.cloud_note.service.UserService;
import ecjtu.cloud_note.util.NoteResult;
import sun.reflect.misc.ReflectUtil;
@Controller
@RequestMapping("/user")
public class UserRegistController {
	@Resource
	private UserService userService;
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult<Object> userRegistController(String name,String nick,String password){
		
		NoteResult<Object> result = userService.addUser(name, nick, password);
		
		return result;
	}
}







