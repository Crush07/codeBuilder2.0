package com.hysea.select.entity;

import lombok.Data;

import java.util.List;

/**
 * 代码块节点
 * 用于表述代码块以及层级关系
 */
@Data
public class CodeBlockNode{

    private Object value;

    private List<CodeBlockNode> childList;

}
