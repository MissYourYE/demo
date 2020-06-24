package com.dubm.handler.iface;

import com.dubm.model.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface SimpleControllerHandler {
    ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
