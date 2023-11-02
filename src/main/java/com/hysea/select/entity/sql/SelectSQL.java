package com.hysea.select.entity.sql;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.StringJoiner;

@EqualsAndHashCode(callSuper = true)
@Data
public class SelectSQL extends SQLBase {

    private List<SelectItem> selectItemList;

    private SQLTable sqlTable;

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class SelectItem extends SQLTable.Attribute{

    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class SomethingOfSelect extends SelectItem {

        private boolean isAll;

        @Override
        public String toString() {

            if(isAll()){
                return "*";
            }else{
                return getAttributeName();
            }
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class Function extends SelectItem {

        private String functionName;

        private List<FunctionParam> paramList;

        @EqualsAndHashCode(callSuper = true)
        @Data
        public static class FunctionParam extends SomethingOfSelect{

            @Override
            public String toString() {
                return super.toString();
            }

        }

        @Override
        public String toString() {

            StringBuilder res = new StringBuilder();

            res.append(getFunctionName()).append("(");
            List<FunctionParam> paramList = getParamList();

            StringJoiner paramStringJoiner = new StringJoiner(",");
            for (FunctionParam functionParam : paramList) {
                paramStringJoiner.add(functionParam.toString());
            }

            res.append(")");
            return res.toString();
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("select ");

        List<SelectItem> selectItemList = getSelectItemList();

        StringJoiner selectItemStringJoiner = new StringJoiner(",");
        for (SelectItem selectItem : selectItemList) {
            selectItemStringJoiner.add(selectItem.toString());
        }

        res.append(selectItemStringJoiner);

        res.append(" from ").append(getSqlTable().getTableName());
        return res.toString();
    }
}
