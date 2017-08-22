package spittr.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppWideExceptionHandler  extends Throwable{

	@ExceptionHandler(DuplicateSpittleException.class)
	public String duplicateSpittleHandler() {
		return "error/duplicate";
	}
	
}
