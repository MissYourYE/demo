package com.dubm.adapter;

import com.dubm.adapter.iface.HandlerAdapter;
import com.dubm.handler.iface.SimpleControllerHandler;
import com.dubm.model.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SimplerControllerHandlerAdapter implements HandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return handler instanceof SimpleControllerHandler;
    }

    @Override
    public ModelAndView handlerRequest(Object handler, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ((SimpleControllerHandler)handler).handleRequest(req,resp);
        return null;
    }
}
