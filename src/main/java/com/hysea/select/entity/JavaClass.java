package com.hysea.select.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class JavaClass {

    List<Import> importList;

    List<Annotation> annotationList;

    String javaClassName;

    String classTypeName;

    public JavaClass() {

        this.importList = new ArrayList<>();
        this.annotationList = new ArrayList<>();

    }
}
