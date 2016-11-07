package ua.training.models.entities;

/**
 * Created by Andriy on 07.11.2016.
 */
public enum FieldType {
    FIRST_NAME("first name"),
    SECOND_NAME("second name"),
    LAST_NAME("last name"),
    NICKNAME("nickname"),
    COMMENT("comment"),
    GROUP("group"),
    HOME_PHONE("home phone"),
    FIRST_MOBILE_PHONE("first mobile phone"),
    SECOND_MOBILE_PHONE("second mobile phone (can be empty)"),
    EMAIL("e-mail"),
    SKYPE("skype"),
    ADDRESS_INDEX("address index"),
    CITY("city"),
    STREET("street"),
    HOUSE_NUMBER("house number"),
    APARTMENT_NUMBER("apartment number"),
    CREATION_TIME ("DATE (DD-MM-YYYY)");

    private String name;

    FieldType(String name) {
        this.name = name;
    }

    public String getName() {
        if (this == GROUP) {
            StringBuilder fieldName = new StringBuilder();
            fieldName.append(name).append(" (");
            for (Groups group : Groups.values()) {
                fieldName.append(group).append(", ");
            }
            fieldName.append(")");
            fieldName.deleteCharAt(fieldName.lastIndexOf(" "));
            fieldName.deleteCharAt(fieldName.lastIndexOf(","));
            name = fieldName.toString();
        }
        return name;
    }
}
