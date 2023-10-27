package com.hysea.block.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.StringJoiner;

@EqualsAndHashCode(callSuper = true)
@Data
public class Block extends Retraction{

    /**
     * 代码块文本
     */
    List<Line> lineList;

    /**
     * 包含子代码块
     */
    List<Block> childList;

    /**
     * 单行代码
     */
    Line singleLine;

    @Override
    public String toString() {
        StringJoiner res = new StringJoiner("\n");
        for(int i = 0;i < childList.size();i++){
            if(childList.get(i).getSingleLine() != null){
                res.add(childList.get(i).getSingleLine().toString());
            }
            if(childList.get(i).getChildList() != null && childList.get(i).getChildList().size() > 0){
                res.add("{");
                for(int j = 0;j < childList.get(i).getChildList().size();j++) {
                    if (childList.get(i).getChildList().get(j).getSingleLine() != null) {
                        res.add(childList.get(i).getChildList().get(j).getSingleLine().toString());
                    }
                }
                res.add("}");
            }
        }
        return res.toString();
    }
}
