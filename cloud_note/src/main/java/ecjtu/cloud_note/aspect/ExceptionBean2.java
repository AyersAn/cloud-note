package ecjtu.cloud_note.aspect;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//加入spring
@Component
@Aspect   //切面
public class ExceptionBean2 {
	
	@AfterThrowing(throwing="e",pointcut="within(ecjtu.cloud_note..*)")
	public void execute(Exception e) {
		try {
			FileWriter fw = new FileWriter("e:\\cloud_note_exception.log",true);
			PrintWriter pw = new PrintWriter(fw);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String time = sdf.format(date);
			pw.println("*********************");
			pw.println("*异常时间:"+time);
			pw.println("*异常类型:"+e);
			pw.println("*******异常详情********");
			e.printStackTrace(pw);
			pw.close();
			fw.close();
		} catch (IOException e1) {
			System.out.println("异常记录失败");
		}
		
	}
}








