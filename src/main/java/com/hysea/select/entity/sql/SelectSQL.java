package com.hysea.select.entity.sql;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Optional;

@Data
public class SelectSQL {

    private SelectColumnSQL selectColumnSQL;

    private FromSQL fromSQL;

    private JoinSQL joinSQL;

    private WhereSQL whereSQL;

    @Override
    public String toString() {

        String res = "";

        if(getSelectColumnSQL() != null){
            res += getSelectColumnSQL().toString();
        }
        if(getFromSQL() != null){
            res += getFromSQL().toString();
        }
        if(getJoinSQL() != null){
            res += getJoinSQL().toString();
        }
        if(getWhereSQL() != null){
            res += getWhereSQL().toString();
        }
        return res;
    }

    public String functionName(){

        String res = "";

        if(getSelectColumnSQL() != null){
            res += getSelectColumnSQL().functionPartName();
        }
        if(getFromSQL() != null){
            res += getFromSQL().functionPartName();
        }
        if(getJoinSQL() != null){
            res += getJoinSQL().functionPartName();
        }
        if(getWhereSQL() != null){
            res += getWhereSQL().functionPartName();
        }
        return res;
    }
}
