package com.hysea.select.entity;

import lombok.Data;

import java.util.List;

@Data
public class Block<C>{

    private List<C> childList;

}
