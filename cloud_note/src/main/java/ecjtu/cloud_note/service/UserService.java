package ecjtu.cloud_note.service;

import ecjtu.cloud_note.entity.User;
import ecjtu.cloud_note.util.NoteResult;

public interface UserService {
	
	public NoteResult<User> checkLogin(String name,String password,String code);
	public NoteResult<Object> addUser(String name,String nick,String password);
	//修改密码
	public NoteResult<User> changePassword(String userId,String lastPassword,String newPassword);
}










