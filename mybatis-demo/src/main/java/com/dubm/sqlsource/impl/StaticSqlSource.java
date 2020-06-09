package com.dubm.sqlsource.impl;

import com.dubm.sqlsource.BoundSql;
import com.dubm.sqlsource.ParameterMapping;
import com.dubm.sqlsource.Sqlsource;

import java.util.List;

public class StaticSqlSource implements Sqlsource {

    private String sql;
    private List<ParameterMapping> parameterMappings;

    public StaticSqlSource(String sql, List<ParameterMapping> parameterMappings) {
        this.sql = sql;
        this.parameterMappings = parameterMappings;
    }

    @Override
    public BoundSql getBoundSql(Object param) {
        return new BoundSql(sql,parameterMappings);
    }
}
