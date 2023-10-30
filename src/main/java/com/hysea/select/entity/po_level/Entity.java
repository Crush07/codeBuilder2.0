package com.hysea.select.entity.po_level;

import com.hysea.block.entity.Line;
import com.hysea.select.entity.Annotation;
import com.hysea.select.entity.Block;
import com.hysea.select.entity.Import;
import com.hysea.select.entity.JavaClass;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Data
public class Entity extends JavaClass {

    private Entity extendsClass;

    private List<Entity> implementsClassList;

    private EntityBlock entityBlock;

    public Entity() {

        this.implementsClassList = new ArrayList<>();

    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class EntityBlock extends Block<Define> {

        @Override
        public String toString() {

            StringBuilder res = new StringBuilder();

            res.append("{").append("\n");
            List<Define> childList = getChildList();
            for (Define define : childList) {
                res.append(define);
            }
            res.append("}").append("\n");

            return res.toString();
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class Attribute extends Define {

        private String AttributeRoleName;

        @Override
        public void beExtend() {

        }

        @Override
        public String toString() {

            StringBuilder res = new StringBuilder();

            if (getAttributeRoleName() != null) {
                res.append(getAttributeRoleName()).append(" ");
            }

            res.append(getJavaClassName()).append(" ");

            res.append(getDefineName()).append(";");

            res.append("\n");

            return res.toString();
        }

    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class Method extends Define {

        private String roleName;

        /**
         * 可以是空，代表省略权限值
         */
        private String MethodRoleName;

        /**
         * 形参列表
         */
        private List<Define> parameterList;

        /**
         * 是否重写
         */
        private boolean needOverride;

        /**
         * 是否有方法体
         */
        private boolean hasMethodBody;

        @Override
        public void beExtend() {
            this.needOverride = true;
        }

        @Override
        public String toString() {

            StringBuilder res = new StringBuilder();

            if(needOverride){
                Annotation annotation = new Annotation();
                annotation.setAnnotationName("Override");
                getAnnotationList().add(annotation);
                hasMethodBody = true;
            }



            //打印函数的注解
            List<Annotation> annotationList = getAnnotationList();
            for (Annotation annotation : annotationList) {
                res.append(annotation);
            }

            if (getMethodRoleName() != null) {
                res.append(getMethodRoleName()).append(" ");
            }

            res.append(getJavaClassName()).append(" ");

            res.append(getDefineName());

            res.append("(");

            res.append(")");


            if(hasMethodBody){
                res.append("{")
                        .append("\n")
                        .append("}")
                        .append("\n");
            }else{
                res.append(";").append("\n");
            }

            return res.toString();
        }
    }

    @Data
    public abstract static class Define {

        private String javaClassName;

        private String defineName;

        private List<Annotation> annotationList;

        abstract public void beExtend();

        public Define() {
            this.annotationList = new ArrayList<>();
        }
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

        List<Import> importList = getImportList();
        for (Import anImport : importList) {
            res.append(anImport);
        }

        List<Annotation> annotationList = getAnnotationList();
        for (Annotation annotation : annotationList) {
            res.append(annotation);
        }

        res.append("public")
                .append(" ")
                .append(getClassTypeName())
                .append(" ")
                .append(getJavaClassName());

        List<Entity> implementsClassList = getImplementsClassList();
        if (implementsClassList.size() > 0) {
            res.append(" ").append("implements").append(" ");
        }

        StringJoiner implementsString = new StringJoiner(",");
        for (Entity implementEntity : implementsClassList) {
            implementsString.add(implementEntity.getJavaClassName());

            List<Define> childList = implementEntity.getEntityBlock().getChildList();
            childList = childList.stream().peek(Define::beExtend).collect(Collectors.toList());

            getEntityBlock().getChildList().addAll(childList);
        }

        res.append(implementsString);

        res.append(getEntityBlock());

        return res.toString();
    }
}
