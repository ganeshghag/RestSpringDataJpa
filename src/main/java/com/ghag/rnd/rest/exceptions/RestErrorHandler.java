package com.ghag.rnd.rest.exceptions;

import java.util.List;
import java.util.Locale;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@ControllerAdvice
public class RestErrorHandler {
 
    private MessageSource messageSource;
 
    @Autowired
    public RestErrorHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
 
    //@ExceptionHandler(MethodArgumentNotValidException.class)
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationErrorDTO processValidationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
 
        return processFieldErrors(fieldErrors);
    }
 
    private ValidationErrorDTO processFieldErrors(List<FieldError> fieldErrors) {
        ValidationErrorDTO dto = new ValidationErrorDTO();
 
        for (FieldError fieldError: fieldErrors) {
            dto.addFieldError(fieldError.getField(), "Validation error in field - "+fieldError.getField());
        }
 
        return dto;
    }
    
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ValidationErrorDTO processAllExceptions(Throwable ex) {
    	ex.printStackTrace();
    	ValidationErrorDTO dto = new ValidationErrorDTO();
    	dto.addFieldError(ex.toString(), ex.getMessage());
    	
    	//extra level info
    	Throwable det = ex.getCause();
    	if(det != null)
    		dto.addFieldError(det.toString(), det.getMessage());
    	
    	//extra level info
    	det = det.getCause();
    	if(det != null)
    		dto.addFieldError(det.toString(), det.getMessage());
    	
    	return dto;
    }

    
 
    /*
     * not yet used
     */
    
    @Deprecated
    private String resolveLocalizedErrorMessage(FieldError fieldError) {
        Locale currentLocale =  LocaleContextHolder.getLocale();
        String localizedErrorMessage = messageSource.getMessage(fieldError, currentLocale);
 
        //If the message was not found, return the most accurate field error code instead.
        //You can remove this check if you prefer to get the default error message.
        if (localizedErrorMessage.equals(fieldError.getDefaultMessage())) {
            String[] fieldErrorCodes = fieldError.getCodes();
            localizedErrorMessage = fieldErrorCodes[0];
        }
 
        return localizedErrorMessage;
    }
}
