package com.leonovich.itcrowd.web.controller;

import com.leonovich.itcrowd.web.exception.WebException;
import com.leonovich.itcrowd.web.exception.WebExceptionCode;
import org.apache.log4j.Logger;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * This is controller advice. It is processing exception.
 * Created by alexanderleonovich on 16.08.15.
 */
@ControllerAdvice
public class ExceptionController {
    private static Logger logger = Logger.getLogger(ExceptionController.class);

    /**
     * This method processing WebException and
     * return "error" page and error message.
     * @param ex Get WebException.
     * @return ModelAndView - "error" page and error message.
     */
    @ExceptionHandler(WebException.class)
    public ModelAndView customException(WebException ex) {
        ModelAndView model = new ModelAndView("error", "errMsg", ex.getMessage());
        logger.info(ex.getMessage());
        return model;
    }

    /**
     * This method work when incoming Not Supported Exception in Http Request.
     * Example: 405 error.
     * @return ModelAndView - "error" page and error message
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ModelAndView statusCustomException() {
        ModelAndView model = new ModelAndView("error", "errMsg", WebExceptionCode.NC_WEB_007.toString());
        logger.info(WebExceptionCode.NC_WEB_007.toString());
        return model;
    }
}
