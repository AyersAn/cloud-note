package ecjtu.cloud_note.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ecjtu.cloud_note.util.ImageUtil;

/**
 * 点击验证码,更换验证码
 * @author x1c
 *
 */
@Controller
public class LoadCodeController {
	@RequestMapping("/createImg.do")
	public void createCode(HttpServletRequest req,HttpServletResponse resp) {
		//接收验证码和图片
		Object[] objs = ImageUtil.createImage();
		//获取session
		HttpSession session = req.getSession();
		//将验证码存入session
		session.setAttribute("code", objs[0]);
		//将图片传给浏览器,声明类型
		resp.setContentType("image/png");
		//获取输出流,该流由服务器自动创建
		//所输出的目标就是当前访问的服务器
		try {
			OutputStream os = resp.getOutputStream();
			BufferedImage image = (BufferedImage) objs[1];
			ImageIO.write(image, "png", os);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}










