package ua.training.models.entities;

import java.util.LinkedHashMap;

/**
 * Created by Andriy on 06.11.2016.
 */
public class Record {
    private LinkedHashMap<FieldType, Object> fields = new LinkedHashMap<FieldType, Object>();

    public Record() {
        for (FieldType type : FieldType.values()) {
            fields.put(type, null);
        }
    }

    public void setField(FieldType type, Object value) {
        fields.put(type, value);
    }

    public Object getField(FieldType type) {
        return fields.get(type);
    }
}
