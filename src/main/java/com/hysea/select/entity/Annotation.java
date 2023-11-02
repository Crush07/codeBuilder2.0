package com.hysea.select.entity;

import lombok.Data;

@Data
public class Annotation {

    private String annotationName;

    @Override
    public String toString() {
        return "@" + getAnnotationName() + "\n";
    }
}
