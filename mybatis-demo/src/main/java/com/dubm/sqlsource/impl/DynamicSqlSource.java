package com.dubm.sqlsource.impl;

import com.dubm.sqlnode.DynamicContext;
import com.dubm.sqlnode.Sqlnode;
import com.dubm.sqlsource.BoundSql;
import com.dubm.sqlsource.Sqlsource;
import com.dubm.utils.GenericTokenParser;
import com.dubm.utils.ParameterMappingTokenHandler;

public class DynamicSqlSource implements Sqlsource {

    private Sqlnode sqlnode;

    public DynamicSqlSource(Sqlnode sqlnode) {
        this.sqlnode = sqlnode;
    }

    @Override
    public BoundSql getBoundSql(Object param) {
        DynamicContext dynamicContext = new DynamicContext(param);
        sqlnode.apply(dynamicContext);
        String sql = dynamicContext.getSql();
        ParameterMappingTokenHandler parameterMappingTokenHandler = new ParameterMappingTokenHandler();
        GenericTokenParser genericTokenParser = new GenericTokenParser("#{", "}", parameterMappingTokenHandler);
        String parse = genericTokenParser.parse(sql);
        return new BoundSql(parse, parameterMappingTokenHandler.getParameterMappings());
    }
}
