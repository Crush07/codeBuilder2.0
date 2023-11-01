package com.hysea.select.entity.mapper_xml_level;

import com.hysea.select.entity.XMLFormat;
import com.hysea.select.entity.sql.SQLBase;
import com.hysea.select.entity.sql.SQLTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class MapperXML extends XMLFormat {

    private SQLBase sqlBase;

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class SelectCountXML extends MapperXML {



    }

    @Override
    public String toString() {
        return super.toString();
    }
}
