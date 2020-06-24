package com.dubm.adapter;

import com.dubm.adapter.iface.HandlerAdapter;
import com.dubm.handler.iface.HttpRequestHandler;
import com.dubm.model.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpRequestHandlerAdapter implements HandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return handler instanceof HttpRequestHandler;
    }

    @Override
    public ModelAndView handlerRequest(Object handler, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ((HttpRequestHandler)handler).handleRequest(req,resp);
        return null;
    }
}
