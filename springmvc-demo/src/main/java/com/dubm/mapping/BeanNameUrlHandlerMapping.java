package com.dubm.mapping;

import com.dubm.handler.ShowUserHandler;
import com.dubm.mapping.iface.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BeanNameUrlHandlerMapping implements HandlerMapping {

    private Map<String,Object> urlHandlers = new HashMap<>();

    public BeanNameUrlHandlerMapping() {
        urlHandlers.put("/showUser",new ShowUserHandler());
    }

    @Override
    public Object getHandler(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        return urlHandlers.get(requestURI);
    }
}
