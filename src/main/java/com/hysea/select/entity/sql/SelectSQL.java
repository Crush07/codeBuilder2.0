package com.hysea.select.entity.sql;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class SelectSQL {

    private SelectColumnSQL selectColumnSQL;

    private FromSQL fromSQL;

    private JoinSQL joinSQL;

    @Override
    public String toString() {
        return getSelectColumnSQL().toString()
                + getFromSQL().toString()
                + getJoinSQL().toString();
    }

    public String functionName(){
        return getSelectColumnSQL().functionPartName()
                + getFromSQL().functionPartName()
                + getJoinSQL().functionPartName();
    }
}
