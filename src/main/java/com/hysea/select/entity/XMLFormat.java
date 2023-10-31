package com.hysea.select.entity;

import com.hysea.select.entity.po_level.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
public class XMLFormat {

    /**
     * 是否为纯文本
     */
    private boolean isText;

    /**
     * 标签名
     */
    private String tagName;

    /**
     * 是否是单标签
     */
    private boolean isSingle;

    /**
     * 属性列表
     */
    private List<Attribute> attributeList;

    /**
     * 子标签
     */
    private List<XMLFormat> childNodeList;

    /**
     * 标签内容
     */
    private String content;

    @Data
    public static class Attribute {

        private String AttributeName;

        private String AttributeValue;

        @Override
        public String toString() {

            return getAttributeName() + "=\"" + getAttributeValue() + "\" ";

        }

    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

        if(isText()){
            res.append(getContent());
        }else{

            res.append("<").append(getTagName());

            List<Attribute> attributeList = getAttributeList();

            for (Attribute attribute : attributeList) {
                res.append(attribute);
            }

            if(isSingle()){
                res.append("/>");
            }else{
                res.append(">\n");

                List<XMLFormat> childNodeList = getChildNodeList();
                for (XMLFormat childNode : childNodeList) {
                    res.append(childNode);
                }

                res.append("</").append(getTagName()).append(">");
                res.append("\n");
            }
        }

        return res.toString();
    }
}
