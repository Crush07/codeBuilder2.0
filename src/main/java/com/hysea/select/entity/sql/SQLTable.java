package com.hysea.select.entity.sql;

import com.hysea.select.entity.po_level.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
public class SQLTable {

    private String tableName;

    private List<Attribute> attributeList;

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class Attribute extends SQLTable{

        /**
         * 属性名
         */
        private String attributeName;

        /**
         * 属性注释
         */
        private String attributeNote;

        /**
         * 对应实体属性
         */
        private Entity.Attribute entityAttribute;

    }

}
