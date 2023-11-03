package com.hysea.select.entity.sql;

import com.hysea.util.Matchers;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Data
public class JoinSQL extends SQLBase {

    List<JoinRelationShip> joinRelationShipList;

    @Data
    public static class JoinRelationShip {

        private SelectItem left;

        private SelectItem right;

        @Override
        public String toString() {
            return "left join "
                    + right.getSqlTable().getTableName()
                    + " "
                    + right.getTableAlias()
                    + " on "
                    + left.getTableAlias() + "." + left.getAttributeName()
                    + " = "
                    + right.getTableAlias() + "." + right.getAttributeName()
                    + "\n";
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        List<JoinRelationShip> joinRelationShipList = getJoinRelationShipList();

        // left join sys_user su on su.user_id = sd.user_id
        for (JoinRelationShip joinRelationShip : joinRelationShipList) {
            res.append(joinRelationShip);
        }

        return res.toString();
    }

    @Override
    public String functionPartName() {
        return super.functionPartName();
    }
}
