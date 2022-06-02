package com.digiwin.demo.assess.config;

import com.digiwin.app.dao.DWServiceResultBuilder;
import com.digiwin.app.service.DWServiceResult;
import com.digiwin.demo.assess.exception.BusinessException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobeExceptionHandler {

    public GlobeExceptionHandler() {
    }

    @ExceptionHandler({BusinessException.class})
    public DWServiceResult handleBusinessExceptionHandler(BusinessException businessException) {
        return DWServiceResultBuilder.build(false, businessException.getMessage(), (Object)null);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public DWServiceResult MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        String message = (String)e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        return DWServiceResultBuilder.build(false, message, null);
    }

    @ExceptionHandler({BindException.class})
    public DWServiceResult BindExceptionHandler(BindException e) {
        String message = (String)e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        return DWServiceResultBuilder.build(false, message, null);
    }
}
