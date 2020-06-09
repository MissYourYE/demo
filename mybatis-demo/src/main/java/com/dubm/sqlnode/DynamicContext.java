package com.dubm.sqlnode;

import java.util.HashMap;
import java.util.Map;

public class DynamicContext {
    private StringBuffer sb = new StringBuffer();
    private Map<String,Object> bindings = new HashMap<>();

    public DynamicContext(Object param){
        this.bindings.put("_parameter",param);
    }

    public String getSql(){
        return sb.toString();
    }

    public void appendSql(String sqlText){
        this.sb.append(sqlText);
        this.sb.append(" ");
    }

    public Map<String, Object> getBindings() {
        return bindings;
    }

    public void setBindings(Map<String, Object> bindings) {
        this.bindings = bindings;
    }
}
