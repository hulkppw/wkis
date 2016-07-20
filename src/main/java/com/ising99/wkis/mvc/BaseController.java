package com.ising99.wkis.mvc;

import com.ising99.wkis.common.ErrorCode;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jerry on 2014/11/3.
 */
public class BaseController {
    private static final Logger logger = Logger.getLogger(BaseController.class);
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @ExceptionHandler
    public String exception(HttpServletResponse response, Exception e) {
        logger.error(e.toString(), e);
        response.addHeader("Content-Type", "text/plain;charset=UTF-8");
        responseErrorCode(ErrorCode.SERVER_ERROR);
        response.setStatus(500);
        try {
            this.response.getWriter().print("500");
        } catch (IOException ex) {
            logger.error(ex);
        }
        return null;
    }

    /**
     * 输出错误码
     *
     * @param code
     */
    protected void responseErrorCode(int code) {
        this.response.setHeader("code", String.valueOf(code));
        try {
            this.response.getWriter().print(code);
        } catch (IOException e) {
            logger.error(e);
        }
    }
}
