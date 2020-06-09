package com.dubm.sqlnode.impl;

import com.dubm.ClassTypeUtils;
import com.dubm.sqlnode.DynamicContext;
import com.dubm.sqlnode.Sqlnode;
import com.dubm.utils.GenericTokenParser;
import com.dubm.utils.OgnlUtils;
import com.dubm.utils.TokenHandler;

public class TextSqlNode implements Sqlnode {

    private String sqlText;

    public TextSqlNode(String sqlText) {
        this.sqlText = sqlText;
    }

    @Override
    public void apply(DynamicContext dynamicContext) {
        BindingTokenHandler bindingTokenHandler = new BindingTokenHandler(dynamicContext);
        GenericTokenParser genericTokenParser = new GenericTokenParser("#{", "}", bindingTokenHandler);
        String parseSql = genericTokenParser.parse(sqlText);
        dynamicContext.appendSql(parseSql);
    }

    public boolean isDynamic() {
        return sqlText.contains("${");
    }

    class BindingTokenHandler implements TokenHandler {

        private DynamicContext context;

        public BindingTokenHandler(DynamicContext context) {
            this.context = context;
        }


        @Override
        public String handleToken(String content) {
            Object parameter = context.getBindings().get("_parameter");
            if (parameter == null){
                return "";
            }else if (ClassTypeUtils.isSimpleType(parameter.getClass())){
                return parameter.toString();
            }
            Object value = OgnlUtils.getValue(content, parameter);
            return value == null ? "" : value.toString();
        }
    }

}
