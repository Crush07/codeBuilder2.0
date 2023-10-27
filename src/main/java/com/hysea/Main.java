package com.hysea;

import com.alibaba.fastjson.JSONObject;
import com.hysea.block.create.EntityCreator;
import com.hysea.block.entity.Block;
import com.hysea.select.entity.Annotation;
import com.hysea.select.entity.Import;
import com.hysea.select.entity.po_level.Entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Entity entity = new Entity();

        //import列表
        String[] importArray = {
                "java.util.Date",
                "java.util.List",
                "java.io.Serializable",
                "lombok.*"
        };
        List<Import> importList = Arrays.stream(importArray).map(s -> {
            Import anImport = new Import();
            anImport.setImportJavaName(s);
            return anImport;
        }).collect(Collectors.toList());
        entity.setImportList(importList);

        //annotation列表
        String[] annotationArray = {
                "Data"
        };
        List<Annotation> annotationList = Arrays.stream(annotationArray).map(s -> {
            Annotation annotation = new Annotation();
            annotation.setAnnotationName(s);
            return annotation;
        }).collect(Collectors.toList());
        entity.setAnnotationList(annotationList);

        //实体代码块
        //实体名
        entity.setEntityBlock(new Entity.EntityBlock());
        entity.setEntityName("Car");

        String[] attributeArray = {
                "id",
                "order",
                "name"
        };
        List<Entity.Attribute> attributeList = Arrays.stream(attributeArray).map(s -> {
            Entity.Attribute attribute = new Entity.Attribute();
            attribute.setAttributeName(s);
            attribute.setAttributeTypeName("Integer");
            attribute.setAttributeRoleName("private");
            return attribute;
        }).collect(Collectors.toList());
        entity.getEntityBlock().setChildList(attributeList);

        EntityCreator entityCreator = new EntityCreator();
        Block block = entityCreator.createBlock(entity);
        System.out.println(block);
//        System.out.println(JSONObject.parse(JSONObject.toJSONString(block)));

    }
}