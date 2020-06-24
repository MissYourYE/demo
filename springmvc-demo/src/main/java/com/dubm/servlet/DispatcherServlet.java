package com.dubm.servlet;

import com.dubm.adapter.HttpRequestHandlerAdapter;
import com.dubm.adapter.SimplerControllerHandlerAdapter;
import com.dubm.adapter.iface.HandlerAdapter;
import com.dubm.mapping.BeanNameUrlHandlerMapping;
import com.dubm.mapping.SimpleUrlHandlerMapping;
import com.dubm.mapping.iface.HandlerMapping;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DispatcherServlet extends AbstractServlet {

    private List<HandlerMapping> handlerMappingList = new ArrayList<>();
    private List<HandlerAdapter> handlerAdapters = new ArrayList<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        handlerMappingList.add(new BeanNameUrlHandlerMapping());
        handlerMappingList.add(new SimpleUrlHandlerMapping());
        handlerAdapters.add(new HttpRequestHandlerAdapter());
        handlerAdapters.add(new SimplerControllerHandlerAdapter());
    }


    @Override
    protected void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        // 先通过处理器映射器，通过uri找到对应的处理器
        Object handler = getHandler(req);

        if (handler == null) return;

        // 通过处理器查找其对应的处理器适配器
        HandlerAdapter ha =  getHandlerAdapter(handler);
        // 适配器执行
        ha.handlerRequest(handler,req,resp);
    }

    private HandlerAdapter getHandlerAdapter(Object handler) {
        for (HandlerAdapter handlerAdapter : handlerAdapters) {
            if (handlerAdapter.supports(handler)){
                return handlerAdapter;
            }
        }
        return null;
    }

    private Object getHandler(HttpServletRequest req) {
        for (HandlerMapping h : handlerMappingList) {
            if (h.getHandler(req)!=null){
                return h.getHandler(req);
            }
        }
        return null;
    }
}
