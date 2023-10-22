package com.hysea.block.create;

import com.hysea.block.entity.Block;

public abstract class BlockCreator<T> {

    public abstract Block createBlock(T t);

}
