package swan.spring.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Aspect
@Order(1)
public class ProfilingAdvice {
	@Pointcut("execution(public * swan.spring.board.service..*(..))")
	public void profileTarget() {
		
	}
	@Around("profileTarget()")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		String method = joinPoint.getSignature().getName();
		System.out.println(method + " 시작");
		long start = System.currentTimeMillis();
		try {
			Object result = joinPoint.proceed();
			return result;
		} finally {
			long finish = System.currentTimeMillis();
			System.out.println(method + " 종료");
			System.out.println(method + " 실행 시간 : " + (finish-start) + "ms");
		}
	}
}
