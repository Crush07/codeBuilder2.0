package com.hysea.select.entity;

import lombok.Data;

import java.util.List;

@Data
public class JavaClass {

    List<Import> importList;

    List<Annotation> annotationList;

    String entityName;

}
