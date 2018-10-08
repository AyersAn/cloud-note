package ecjtu.cloud_note.service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpCookie;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ecjtu.cloud_note.dao.UserDao;
import ecjtu.cloud_note.entity.User;
import ecjtu.cloud_note.util.ImageUtil;
import ecjtu.cloud_note.util.NoteResult;
import ecjtu.cloud_note.util.NoteUtil;
import sun.launcher.resources.launcher;

@Service("userService") //扫描的spring容器
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	//获取session
	@Autowired(required=false)
	private HttpServletRequest request;
	//@Autowired
	//public HttpServletResponse response;
	public NoteResult<User> checkLogin(String name, String password,String code){
		
		//接收结果数据
		NoteResult<User> result = new NoteResult<User>();
		HttpSession session = request.getSession();
		String imgCode = (String) session.getAttribute("code");
		//System.out.println("imgCode:"+imgCode);
		//System.out.println("code:"+code);
		if (code != "") {
			if(!code.equals(imgCode)) {
				result.setStatus(3);
				result.setMsg("验证码错误");
				return result;
			}
		}
		//按参数name查询数据库
		User user = userDao.findByName(name);
		//将用户名的值存到session中
		//HttpSession session = request.getSession();
		//session.setAttribute("user", user);

		//用户名检查
		if(user == null) {
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}
		//检查密码
		String md5Password = NoteUtil.md5(password);
		System.out.println(md5Password);
		if (!user.getCn_user_password().equals(md5Password)) {
			result.setStatus(2);
			result.setMsg("密码不对");
			return result;
		} 
		//正确
		
		result.setStatus(0);
		result.setMsg("登录成功");
		result.setData(user);
		return result;
	}


	
	public NoteResult<Object> addUser(String name,String nick,String password) {
		//用来接受数据结果
		NoteResult<Object> result = new NoteResult<Object>();
		//用户检查
		User hasUser = userDao.findByName(name);
		//检查用户
		if (hasUser != null) {
			result.setStatus(1);
			result.setMsg("用户名已存在");
			return result;
		}
		//System.out.println(user);
		//添加用户
		User user = new User();
		//创建用户id，设置用户id
		String creatId = NoteUtil.createId();
		//System.out.println(creatId);
		user.setCn_user_id(creatId);
		//设置用户名
		user.setCn_user_name(name);
		//设置用户密码，加密密码
		String md5Password = NoteUtil.md5(password);
		user.setCn_user_password(md5Password);
		//用户昵称
		user.setCn_user_nick(nick);
		//添加用户
		userDao.save(user);
		result.setStatus(0);
		result.setMsg("用户注册成功");
		//result.setData(user);
		return result;
		
	}

	public NoteResult<User> changePassword(String userId,String lastPassword,String newPassword) {
		NoteResult<User> result = new NoteResult<User>();
		//检查原密码是否正确
		String password = userDao.findByUserId(userId);
		//System.out.println(password);
		String lastPassword2 = NoteUtil.md5(lastPassword);
		//System.out.println(lastPassword2);
		if (!password.equals(lastPassword2)) {
			result.setStatus(1);
			result.setMsg("原密码错误");
			return result;
		}
		//密码修改
		User user = new User();
		user.setCn_user_id(userId);
		String password2 = NoteUtil.md5(newPassword);
		user.setCn_user_password(password2);
		userDao.updatePassword(user);
		//返回结果
		result.setStatus(0);
		result.setMsg("密码修改成功");
		//result.setData(user);
		return result;
	
	}

}








