package com.dubm.sqlnode.impl;

import com.dubm.sqlnode.DynamicContext;
import com.dubm.sqlnode.Sqlnode;

public class StaticSqlNode implements Sqlnode {

    private String sqlText;

    public StaticSqlNode(String sqlText) {
        this.sqlText = sqlText;
    }

    @Override
    public void apply(DynamicContext dynamicContext) {
        dynamicContext.appendSql(sqlText);
    }
}
