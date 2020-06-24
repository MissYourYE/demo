package com.dubm.mapping.iface;

import javax.servlet.http.HttpServletRequest;

/**
 * 根据request查询相对应的handler
 */
public interface HandlerMapping {
    Object getHandler(HttpServletRequest req);
}
