package com.hysea.select.entity;

import com.hysea.select.entity.po_level.Entity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Block<C extends Entity.Define>{

    private List<C> childList;

    public Block() {
        this.childList = new ArrayList<>();
    }
}
