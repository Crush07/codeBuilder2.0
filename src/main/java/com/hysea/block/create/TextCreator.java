package com.hysea.block.create;

import com.hysea.block.entity.Block;
import com.hysea.block.entity.Text;

import java.util.List;

public abstract class TextCreator {

    public abstract Text createText(List<Block> blockList);

    public Text createTest(List<Block> blockList){
        return null;
    }

}
