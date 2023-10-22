package com.hysea.block.entity;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Line extends Block{

    /**
     * 行文本
     */
    String text;

    public static Line getEmptyLine(){
        return new Line("");
    }

}
