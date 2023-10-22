package com.hysea.block.create;

import com.hysea.block.entity.Block;
import com.hysea.block.entity.Line;
import com.hysea.select.entity.Annotation;
import com.hysea.select.entity.Import;
import com.hysea.select.entity.po_level.Entity;

import java.util.ArrayList;
import java.util.List;

public class EntityCreator extends BlockCreator<Entity>{

    @Override
    public Block createBlock(Entity entity) {

        Block res = new Block();

        List<Block> blockList = new ArrayList<>();
        res.setChildList(blockList);

        List<Import> importList = entity.getImportList();
        for (Import anImport : importList) {
            Block block = new Block();
            block.setSingleLine(new Line());
            block.getSingleLine().setText("import " + anImport.getImportJavaName() + ";");
            block.getSingleLine().setRetractionSize(0);
            res.getChildList().add(block);
        }

        res.getChildList().add(Line.getEmptyLine());

        List<Annotation> annotationList = entity.getAnnotationList();
        for(Annotation annotation : annotationList){
            Block block = new Block();
            block.setSingleLine(new Line());
            block.getSingleLine().setText("@" + annotation.getAnnotationName());
            block.getSingleLine().setRetractionSize(0);
            res.getChildList().add(block);
        }

        Entity.EntityBlock entityBlock = entity.getEntityBlock();


        Block entityCodeBlock = new Block();
        entityCodeBlock.setSingleLine(new Line());
        entityCodeBlock.getSingleLine().setText("public class " + entity.getEntityName());
        entityCodeBlock.getSingleLine().setRetractionSize(0);

        List<Entity.Attribute> childList = entityBlock.getChildList();
        List<Block> attributeBlockList = new ArrayList<>();
        entityCodeBlock.setChildList(attributeBlockList);
        for (Entity.Attribute attribute : childList) {

            Block block = new Block();
            block.setSingleLine(new Line());
            block.getSingleLine().setText(attribute.getAttributeRoleName()
                    + " " + attribute.getAttributeTypeName()
                    + " " + attribute.getAttributeName());
            block.getSingleLine().setRetractionSize(0);

        }

        return res;
    }
}
