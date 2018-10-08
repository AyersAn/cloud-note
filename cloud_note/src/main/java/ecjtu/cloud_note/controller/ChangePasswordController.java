package ecjtu.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ecjtu.cloud_note.entity.User;
import ecjtu.cloud_note.service.UserService;
import ecjtu.cloud_note.util.NoteResult;

@RequestMapping("/change")
@Controller
public class ChangePasswordController {
	
	@Resource
	private UserService userService;
	@RequestMapping("/password.do")
	@ResponseBody
	public NoteResult<User> execute(String userId,String lastPassword,String newPassword){
		NoteResult<User> result = userService.changePassword(userId,lastPassword,newPassword);
		
		return result;
	}
}







