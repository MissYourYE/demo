package com.dubm.handler;

import com.dubm.handler.iface.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowUserHandler implements HttpRequestHandler {
    @Override
    public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        resp.setContentType("text/plain;charset=utf8");
        resp.getWriter().write("id:" + id + ",name:" + name);
    }
}
