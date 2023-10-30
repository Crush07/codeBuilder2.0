package com.hysea.select.entity;

import lombok.Data;

@Data
public class Import {

    private String importJavaName;

    @Override
    public String toString() {
        return "import " + importJavaName + ";\n";
    }
}
