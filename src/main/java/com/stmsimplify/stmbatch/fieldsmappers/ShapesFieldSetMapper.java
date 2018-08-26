package com.stmsimplify.stmbatch.fieldsmappers;

import com.stmsimplify.stmbatch.models.Shapes;
import com.stmsimplify.stmbatch.utils.common.UtilsCommon;
import org.bson.types.ObjectId;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.io.Serializable;
import java.util.Date;

public class ShapesFieldSetMapper implements FieldSetMapper<Shapes>, Serializable {

    private static final long serialVersionUID = 10006L;
    private static final String[] FIELD_NAMES =  new String[]{"shapeId","shapePtLat","shapePtLon","shapePtSequence"};

    @Override
    public Shapes mapFieldSet(FieldSet fieldSet) throws BindException {
        Shapes shapes = new Shapes();
        shapes.setId(fieldSet.readString(FIELD_NAMES[0]) + new ObjectId(new Date()));
        shapes.setShapeId(UtilsCommon.getLong(fieldSet, FIELD_NAMES[0], 0L));
        shapes.setShapePtLat(UtilsCommon.getDouble(fieldSet, FIELD_NAMES[1], 0d));
        shapes.setShapePtLon(UtilsCommon.getDouble(fieldSet,FIELD_NAMES[2],0d));
        shapes.setShapePtSequence(UtilsCommon.getLong(fieldSet, FIELD_NAMES[3], 0L));
        return shapes;
    }
}
