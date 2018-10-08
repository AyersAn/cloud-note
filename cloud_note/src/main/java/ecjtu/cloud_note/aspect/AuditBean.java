package ecjtu.cloud_note.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
/**
 * 测试service层的性能
 * @author x1c
 *
 */
@Component
@Aspect
public class AuditBean {
	@Around("within(ecjtu.cloud_note.service..*)")
	public Object audit(ProceedingJoinPoint point) {
		
		Object obj = null;
		try {
			long timeStart = System.currentTimeMillis();
			//代表执行的每个service
			obj = point.proceed();
			long timeEnd = System.currentTimeMillis();
			//调用的service的名称
			String str = point.getSignature().toString();
			System.out.println(str+",耗时:"+(timeEnd-timeStart));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return obj;
	}
}









