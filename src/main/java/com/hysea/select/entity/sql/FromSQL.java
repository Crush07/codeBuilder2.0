package com.hysea.select.entity.sql;

import com.hysea.util.Matchers;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Data
public class FromSQL extends SQLBase {

    private SQLTable sqlTable;

    @Override
    public String toString() {

        // from
        return "from " +
                "\n" +

                // sys_dept sd
                getSqlTable().getTableName() +
                " " +
                getTableAlias() +
                "\n";
    }

    public String getTableAlias(){
        String tableName = getSqlTable().getTableName();

        return Matchers.getStringByRegex("(^[a-zA-Z0-9]{2}|[a-zA-Z0-9]{1}[_])", tableName).stream().map(s -> s.substring(0, 1)).collect(Collectors.joining());

    }

    @Override
    public String functionPartName() {
        return super.functionPartName();
    }
}
