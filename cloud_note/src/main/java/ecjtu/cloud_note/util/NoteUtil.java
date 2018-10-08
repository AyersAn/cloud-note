package ecjtu.cloud_note.util;

import java.security.MessageDigest;
import java.util.UUID;

import org.apache.tomcat.util.codec.binary.Base64;


public class NoteUtil {
	/*
	 * 利用UUID算法生成主键
	 */
	public static String createId() {
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		//去掉生成的主键中的 -
		return id.replace("-", "");
	}
	
	//MD5 加密算法，给密码加密
	public static String md5(String src) {
		try {
			//创建具有指定算法名称的信息摘要
			MessageDigest md = MessageDigest.getInstance("MD5");
			//使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
			byte[] output = md.digest(src.getBytes());
			//Base64处理，将得到的字节数组变成字符串返回
			String ret = Base64.encodeBase64String(output);
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			//throw new NoteException("密码加密失败",e);
		}
		
		return null;
		
	}
	public static void main(String[] args) {
		System.out.println(createId());
		System.out.println(md5("123456"));
	}
}










