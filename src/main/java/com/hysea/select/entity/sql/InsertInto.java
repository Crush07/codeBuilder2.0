package com.hysea.select.entity.sql;

import com.hysea.select.entity.po_level.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.StringJoiner;

@EqualsAndHashCode(callSuper = true)
@Data
public class InsertInto extends SQLBase {

    private SQLTable sqlTable;

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        res.append("insert into ").append(getSqlTable().getTableName()).append(" ");

        List<SQLTable.Attribute> attributeList = getSqlTable().getAttributeList();

        res.append("(");
        StringJoiner stringJoiner = new StringJoiner(",");
        for (SQLTable.Attribute attribute : attributeList) {
            stringJoiner.add("`" + attribute.getAttributeName() + "`");
        }
        res.append(")");

        return res.toString();
    }
}
