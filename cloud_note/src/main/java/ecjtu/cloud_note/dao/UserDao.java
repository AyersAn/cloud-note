package ecjtu.cloud_note.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import ecjtu.cloud_note.entity.User;
@Repository("userDao")
public interface UserDao {
	//登录方法
	public User findByName(String name);
	//注册方法
	public void save(User user);
	public String findByUserId(String userId);
	//修改密码
	public void updatePassword(User user);
}









