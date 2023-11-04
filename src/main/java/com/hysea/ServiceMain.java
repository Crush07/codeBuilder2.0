package com.hysea;

import com.hysea.select.entity.Import;
import com.hysea.select.entity.po_level.Entity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceMain {

    public static Entity getInstance(){


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
//        String[] annotationArray = {
//                "Data"
//        };
//        List<Annotation> annotationList = Arrays.stream(annotationArray).map(s -> {
//            Annotation annotation = new Annotation();
//            annotation.setAnnotationName(s);
//            return annotation;
//        }).collect(Collectors.toList());
//        entity.setAnnotationList(annotationList);

        //实体代码块
        //实体名
        entity.setEntityBlock(new Entity.EntityBlock());
        entity.setJavaClassName("Car");
        entity.setClassTypeName("interface");

        String[] methodArray = {
                "id",
                "order",
                "name"
        };

        for (String s : methodArray) {
            Entity.Method method = new Entity.Method();
            method.setDefineName(s);
            method.setJavaClassName("Integer");
            method.setMethodRoleName("private");
            method.setNeedOverride(false);
            method.setHasMethodBody(false);
            entity.getEntityBlock().getChildList().add(method);
        }

        return entity;
    }

    public static void main(String[] args) {

        System.out.println(getInstance());
//        System.out.println(JSONObject.parse(JSONObject.toJSONString(block)));

    }
}