package com.dubm.sqlsource.impl;

import com.dubm.sqlnode.DynamicContext;
import com.dubm.sqlnode.Sqlnode;
import com.dubm.sqlsource.BoundSql;
import com.dubm.sqlsource.Sqlsource;
import com.dubm.utils.GenericTokenParser;
import com.dubm.utils.ParameterMappingTokenHandler;

public class RowSqlsource implements Sqlsource {

    private Sqlsource sqlsource;

    public RowSqlsource(Sqlnode sqlnode) {
        DynamicContext dynamicContext = new DynamicContext(null);
        sqlnode.apply(dynamicContext);
        String sql = dynamicContext.getSql();
        ParameterMappingTokenHandler parameterMappingTokenHandler = new ParameterMappingTokenHandler();
        GenericTokenParser genericTokenParser = new GenericTokenParser("#{", "}", parameterMappingTokenHandler);
        String parse = genericTokenParser.parse(sql);
        sqlsource = new StaticSqlSource(parse,parameterMappingTokenHandler.getParameterMappings());
    }

    @Override
    public BoundSql getBoundSql(Object param) {
        return sqlsource.getBoundSql(param);
    }
}
