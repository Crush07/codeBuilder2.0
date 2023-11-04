package com.hysea;

import com.hysea.select.entity.Import;
import com.hysea.select.entity.po_level.Entity;
import com.hysea.select.entity.sql.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapperXmlMain {

    public static SelectSQL getInstance(){

        Entity instance = ClassMain.getInstance();

        SQLTable sqlTable = new SQLTable();
        sqlTable.setTableName("sys_dept");
        sqlTable.setAttributeList(new ArrayList<>());
        List<SQLTable.Attribute> attributeList = sqlTable.getAttributeList();
        SQLTable.Attribute attribute = new SQLTable.Attribute();
        attribute.setEntityAttribute((Entity.Attribute) instance.getEntityBlock().getChildList().get(0));
        attribute.setAttributeName(instance.getEntityBlock().getChildList().get(0).getDefineName());
        attributeList.add(attribute);

        SelectSQL selectSQL = new SelectSQL();

        selectSQL.setSelectColumnSQL(new SelectColumnSQL());
        SelectColumnSQL selectColumnSQL = selectSQL.getSelectColumnSQL();

        selectColumnSQL.setSelectSQLLineList(new ArrayList<>());
        List<SelectColumnSQL.SelectSQLLine> selectSQLLineList = selectColumnSQL.getSelectSQLLineList();

        SelectColumnSQL.SelectSQLLine selectSQLLine = new SelectColumnSQL.SelectSQLLine();
        selectSQLLine.setSqlTable(sqlTable);
        selectSQLLine.setSelectItemList(new ArrayList<>());
        List<SelectItem> selectItemList = selectSQLLine.getSelectItemList();
        SelectItem selectItem = new SelectItem();
        selectItem.setAttributeName(sqlTable.getAttributeList().get(0).getAttributeName());
        selectItem.setEntityAttribute(sqlTable.getAttributeList().get(0).getEntityAttribute());
        selectItem.setSqlTable(sqlTable);
        selectItemList.add(selectItem);
        selectSQLLine.setSelectItemList(selectItemList);
        selectSQLLineList.add(selectSQLLine);

        selectSQL.setFromSQL(new FromSQL());
        FromSQL fromSQL = selectSQL.getFromSQL();
        fromSQL.setSqlTable(sqlTable);

        return selectSQL;

    }

    public static void main(String[] args) {

        System.out.println(getInstance());
//        System.out.println(JSONObject.parse(JSONObject.toJSONString(block)));

    }
}