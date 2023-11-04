package com.hysea;

import com.hysea.select.entity.Annotation;
import com.hysea.select.entity.Import;
import com.hysea.select.entity.po_level.Entity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceImplMain {
    public static void main(String[] args) {

        Entity instance = ServiceMain.getInstance();

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
                "Service"
        };
        List<Annotation> annotationList = Arrays.stream(annotationArray).map(s -> {
            Annotation annotation = new Annotation();
            annotation.setAnnotationName(s);
            return annotation;
        }).collect(Collectors.toList());
        entity.setAnnotationList(annotationList);

        entity.getImplementsClassList().add(instance);

        //实体代码块
        //实体名
        entity.setEntityBlock(new Entity.EntityBlock());
        entity.setJavaClassName("CarImpl");
        entity.setClassTypeName("class");

//        String[] methodArray = {
//                "id",
//                "order",
//                "name"
//        };
//
//        for (String s : methodArray) {
//            Entity.Method attribute = new Entity.Method();
//            attribute.setDefineName(s);
//            attribute.setJavaClassName("Integer");
//            attribute.setMethodRoleName("private");
//            entity.getEntityBlock().getChildList().add(attribute);
//        }

        System.out.println(entity);
//        System.out.println(JSONObject.parse(JSONObject.toJSONString(block)));

    }
}