package com.dubm.sqlnode.impl;

import com.dubm.sqlnode.DynamicContext;
import com.dubm.sqlnode.Sqlnode;
import com.dubm.utils.OgnlUtils;

public class IfSqlNode implements Sqlnode {

    private String text;
    private MixedSqlNode mixedSqlNode;

    public IfSqlNode(String text, MixedSqlNode mixedSqlNode) {
        this.text = text;
        this.mixedSqlNode = mixedSqlNode;
    }

    @Override
    public void apply(DynamicContext dynamicContext) {
        boolean b = OgnlUtils.evaluateBoolean(text, dynamicContext.getBindings().get("_parameter"));
        if (b){
            mixedSqlNode.apply(dynamicContext);
        }
    }
}
