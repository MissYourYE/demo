package com.dubm.sqlnode.impl;

import com.dubm.sqlnode.DynamicContext;
import com.dubm.sqlnode.Sqlnode;

import java.util.List;

public class MixedSqlNode implements Sqlnode {

    private List<Sqlnode> sqlnodes;

    public MixedSqlNode(List<Sqlnode> sqlnodes) {
        this.sqlnodes = sqlnodes;
    }

    @Override
    public void apply(DynamicContext dynamicContext) {
        sqlnodes.forEach(s -> s.apply(dynamicContext));
    }
}
