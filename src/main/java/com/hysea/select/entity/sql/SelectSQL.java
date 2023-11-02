package com.hysea.select.entity.sql;

import com.hysea.util.Matchers;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Data
public class SelectSQL extends SQLBase {

    List<SelectSQLLine> selectSQLLineList;

    @Data
    public static class SelectSQLLine{
        private List<SelectItem> selectItemList;

        private SQLTable sqlTable;


        @EqualsAndHashCode(callSuper = true)
        @Data
        public static class SelectItem extends SQLTable.Attribute{

        }

        @EqualsAndHashCode(callSuper = true)
        @Data
        public static class SomethingOfSelect extends SelectItem {

            /**
             * 是否是全部
             */
            private boolean isAll;

            /**
             * 别名
             */
            private String alias;

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
            List<SelectItem> selectItemList = getSelectItemList();

            StringJoiner selectItemStringJoiner = new StringJoiner(",");
            for (SelectItem selectItem : selectItemList) {
                selectItemStringJoiner.add(getTableAlias() + "." + selectItem.toString());
            }

            return selectItemStringJoiner.toString();
        }

        public String getTableAlias(){
            String tableName = getSqlTable().getTableName();

            return Matchers.getStringByRegex("(^[a-zA-Z0-9]{2}|[a-zA-Z0-9]{1}[_])", tableName).stream().map(s -> s.substring(0, 1)).collect(Collectors.joining());

        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        List<SelectSQLLine> selectSQLLineList = getSelectSQLLineList();

        // select sd.dept_id,sd.dept_name
        res.append("select ");
        for (int i = 0; i < selectSQLLineList.size(); i++) {
            res.append(selectSQLLineList.get(i));
        }
        res.append("\n");

        // from
        res.append(" from ")
                .append("\n");

        // sys_dept sd
        res.append(selectSQLLineList.get(0).getSqlTable().getTableName())
                .append(" ")
                .append(selectSQLLineList.get(0).getTableAlias())
                .append("\n");

        // left join sys_user su on su.user_id = sd.user_id
        for (int i = 1; i < selectSQLLineList.size(); i++) {
            res.append("left join ")
                    .append(selectSQLLineList.get(i).getSqlTable().getTableName())
                    .append(" ")
                    .append(selectSQLLineList.get(i).getTableAlias())
                    .append(" on ");
//                    .append()
        }

        return res.toString();
    }
}
