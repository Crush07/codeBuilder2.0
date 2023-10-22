package com.hysea.block.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

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

}
