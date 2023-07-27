package in.ashokit.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {
	
	//this method is responsible to handle UserDefinedException
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleUserException(UserNotFoundException e){
		String exMsg = e.getMessage();
		
		//To set the error data,User defined class
		ErrorInfo info =new ErrorInfo();
		info.setCode("SBIEX0001");
		info.setMsg(exMsg);
		info.setWhen(LocalDateTime.now());
		
		return new ResponseEntity<>(info,HttpStatus.BAD_REQUEST);
	}

	
	//This method will be called by Dispatcher Servlet,when the exception will occur
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorInfo> handleException(Exception e){
		String exMsg = e.getMessage();
		
		ErrorInfo info =new ErrorInfo();
		info.setCode("SBIEX0003");
		info.setMsg(exMsg);
		info.setWhen(LocalDateTime.now());
		
		return new ResponseEntity<>(info,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	
}
