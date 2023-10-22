package com.hysea.select.entity.po_level;

import com.hysea.select.entity.Annotation;
import com.hysea.select.entity.Block;
import com.hysea.select.entity.Import;
import com.hysea.select.entity.JavaClass;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Entity extends JavaClass {

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class EntityBlock extends Block<Attribute>{

        private String entityName;

    }

    @Data
    public static class Attribute {

        private String AttributeRoleName;

        private String AttributeTypeName;

        private String AttributeName;

    }

    private EntityBlock entityBlock;

}
