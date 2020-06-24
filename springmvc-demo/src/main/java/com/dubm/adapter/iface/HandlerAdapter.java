package com.dubm.adapter.iface;

import com.dubm.model.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理器适配器接口
 */
public interface HandlerAdapter {
    boolean supports(Object handler);

    ModelAndView handlerRequest(Object handler, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
