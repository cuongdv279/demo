package com.projecttlc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by CHIP_IT_DVC on 23/03/2016.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

//    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(HttpServletRequest request, Exception ex){
//        logger.info("SQLException Occured:: URL="+request.getRequestURL());
        return "client/error404";
    }

    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured")
    @ExceptionHandler(IOException.class)
    public void handleIOException(){
//        logger.error("IOException handler executed");
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request, Exception e) {
        ModelAndView mav = new ModelAndView("client/exception");
        mav.addObject("name", e.getClass().getSimpleName().getClass());
        return mav;
    }

}