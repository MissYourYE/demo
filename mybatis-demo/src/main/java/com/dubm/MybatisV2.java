package com.dubm;

import com.dubm.sqlnode.Sqlnode;
import com.dubm.sqlnode.impl.IfSqlNode;
import com.dubm.sqlnode.impl.MixedSqlNode;
import com.dubm.sqlnode.impl.StaticSqlNode;
import com.dubm.sqlnode.impl.TextSqlNode;
import com.dubm.sqlsource.Sqlsource;
import com.dubm.sqlsource.impl.DynamicSqlSource;
import com.dubm.sqlsource.impl.RowSqlsource;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.Text;

import java.util.ArrayList;
import java.util.List;

public class MybatisV2 {

    private boolean isDynamic;

    private Sqlsource getSqlSource(Element element){
        return parserScriptNode(element);
    }

    private Sqlsource parserScriptNode(Element element) {
        MixedSqlNode mixedSqlNode =  parseAllTags(element);
        Sqlsource sqlsource;
        if (isDynamic){
            sqlsource = new DynamicSqlSource(mixedSqlNode);
        }else {
            sqlsource = new RowSqlsource(mixedSqlNode);
        }
        return sqlsource;
    }

    private MixedSqlNode parseAllTags(Element element) {
        List<Sqlnode> sqlNodes = new ArrayList<>();
        int count = element.nodeCount();
        for (int i = 0; i < count; i++) {
            Node node = element.node(i);
            if (node instanceof Text){
                String sqlText = node.getText().trim();
                // 跳过空行
                if ("".equals(sqlText)){
                    continue;
                }
                TextSqlNode textSqlNode = new TextSqlNode(sqlText);
                if (textSqlNode.isDynamic()){
                    isDynamic = true;
                    sqlNodes.add(textSqlNode);
                }else {
                    sqlNodes.add(new StaticSqlNode(sqlText));
                }
            }else if (node instanceof Element){
                isDynamic = true;
                Element e = (Element) node;
                String elementName = e.getName();
                if ("if".equals(elementName)){
                    String testContent = element.attributeValue("test");
                    // 递归封装
                    MixedSqlNode mixedSqlNode = parseAllTags(element);
                    IfSqlNode ifSqlNode = new IfSqlNode(testContent, mixedSqlNode);
                    sqlNodes.add(ifSqlNode);
                }else if ("foreach".equals(elementName)){
                    // todo
                    System.out.println("省略");
                }
            }
        }
        return new MixedSqlNode(sqlNodes);
    }
}
