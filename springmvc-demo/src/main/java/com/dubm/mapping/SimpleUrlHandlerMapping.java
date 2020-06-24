package com.dubm.mapping;

import com.dubm.handler.CreateUserHandler;
import com.dubm.mapping.iface.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class SimpleUrlHandlerMapping implements HandlerMapping {

    private Map<String,Object> urlHandlers =  new HashMap<>();

    public SimpleUrlHandlerMapping() {
        urlHandlers.put("/createUser",new CreateUserHandler());
    }

    @Override
    public Object getHandler(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        return urlHandlers.get(requestURI);
    }
}
