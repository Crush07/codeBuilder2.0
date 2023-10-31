package com.hysea.select.entity.sql;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SelectSQL extends SQLBase {

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class SomethingOfSelect extends SQLTable.Attribute{

        private boolean isAll;

        private String functionName;

        @Override
        public String toString() {

            if(isAll()){
                return "*";
            }
            return "SomethingOfSelect{" +
                    "isAll=" + isAll +
                    ", functionName='" + functionName + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "select ";
    }
}
