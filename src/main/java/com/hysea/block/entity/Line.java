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

    boolean hasSemicolon;

    public static Line getEmptyLine(){
        return new Line("",false);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for(int i = 0;i < retractionSize;i++){
            res.append("\t");
        }
        if(hasSemicolon){
            return res.toString() + text + ";";
        }else{
            return res.toString() + text;
        }
    }
}
