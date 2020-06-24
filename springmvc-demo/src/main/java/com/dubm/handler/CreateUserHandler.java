package com.dubm.handler;

import com.dubm.handler.iface.SimpleControllerHandler;
import com.dubm.model.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateUserHandler implements SimpleControllerHandler {
    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=utf8");
        resp.getWriter().write("用户创建成功");
        return null;
    }
}
