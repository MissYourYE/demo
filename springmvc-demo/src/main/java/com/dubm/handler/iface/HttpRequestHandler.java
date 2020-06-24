package com.dubm.handler.iface;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 指定处理器编写规范
 */
public interface HttpRequestHandler {
    void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
