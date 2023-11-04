package com.hysea.select.entity.sql;

import com.hysea.util.Matchers;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Data
public class WhereSQL extends SQLBase {

    List<CommonCondition> commonConditionList;

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class WhereItem extends SelectItem {

        @Override
        public String toString() {
            return getTableAlias() + "." + getAttributeName();
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class VarItem extends WhereItem{
        @Override
        public String toString() {
            return "#{"+getEntityAttribute()+"}";
        }

    }


    @Data
    public static class CommonCondition {

        public WhereItem var1;

        public WhereItem var2;

        public String functionPartName(){
            return "";
        }

    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class Condition extends CommonCondition{

    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class BigCondition extends CommonCondition{

        public WhereItem var3;

    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class LikeCondition extends Condition{
        @Override
        public String toString() {
            return getVar1() + " like " + getVar2();
        }

        @Override
        public String functionPartName(){
            return "Like"+getVar2().getEntityAttribute().getJavaClassName();
        }

    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class EqualCondition extends Condition{
        @Override
        public String toString() {
            return getVar1() + " = " + getVar2();
        }

        @Override
        public String functionPartName(){
            return "Equal"+getVar1().getEntityAttribute().getJavaClassName();
        }

    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class NotEqualCondition extends Condition{
        @Override
        public String toString() {
            return getVar1() + " != " + getVar2();
        }

        @Override
        public String functionPartName(){
            return "NotEqual"+getVar1().getEntityAttribute().getJavaClassName();
        }

    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class LtCondition extends Condition{
        @Override
        public String toString() {
            return getVar1() + " < " + getVar2();
        }

        @Override
        public String functionPartName(){
            return "Lt"+getVar1().getEntityAttribute().getJavaClassName();
        }

    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class GtCondition extends Condition{
        @Override
        public String toString() {
            return getVar1() + " > " + getVar2();
        }

        @Override
        public String functionPartName(){
            return "Gt"+getVar1().getEntityAttribute().getJavaClassName();
        }

    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class LtEqualCondition extends Condition{
        @Override
        public String toString() {
            return getVar1() + " <= " + getVar2();
        }

        @Override
        public String functionPartName(){
            return "LtEqual"+getVar1().getEntityAttribute().getJavaClassName();
        }

    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class GtEqualCondition extends Condition{
        @Override
        public String toString() {
            return getVar1() + " >= " + getVar2();
        }

        @Override
        public String functionPartName(){
            return "GtEqual"+getVar1().getEntityAttribute().getJavaClassName();
        }

    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class BetweenAnd extends BigCondition{
        @Override
        public String toString() {
            return getVar1() + " between " + getVar2() + " and " + getVar3();
        }

        @Override
        public String functionPartName(){
            return "Between"
                    + getVar2().getEntityAttribute().getJavaClassName()
                    + "And"
                    + getVar3().getEntityAttribute().getJavaClassName();
        }
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        List<CommonCondition> commonConditionList = getCommonConditionList();

        res.append("where ");

        StringJoiner stringJoiner = new StringJoiner("and\n");
        for (CommonCondition commonCondition : commonConditionList) {
            stringJoiner.add(commonCondition.toString());
        }

        res.append(stringJoiner);

        return res.toString();
    }

    @Override
    public String functionPartName() {

        StringBuilder res = new StringBuilder();
        List<CommonCondition> commonConditionList = getCommonConditionList();

        res.append("By");

        StringJoiner stringJoiner = new StringJoiner("And\n");
        for (CommonCondition commonCondition : commonConditionList) {
            stringJoiner.add(commonCondition.functionPartName());
        }

        res.append(stringJoiner);

        return res.toString();
    }
}
