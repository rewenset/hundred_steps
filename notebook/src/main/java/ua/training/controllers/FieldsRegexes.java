package ua.training.controllers;

/**
 * Created by Andriy on 07.11.2016.
 */
public interface FieldsRegexes {
    String NAMES_REGEX = "^[\\p{L}.'-]+$";
    String NICKNAME_OR_SKYPE_REGEX = "^[a-z0-9_-]{3,15}$";
    String COMMENT_REGEX = ".{0,255}";
    String HOME_PHONE_REGEX = "^\\(\\d{3}\\)-\\d{3}-\\d{4}$"; //(XXX)-XXX-XXXX
    String MOBILE_PHONE_REGEX = "^\\d{3}-\\d{3}-\\d{4}$"; //XXX-XXX-XXXX
    String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*" +
            "@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    String INDEX_REGEX = "^[0-9]{5}$";
    String CITY_OR_STREET_REGEX = "^[a-zA-Z]+(?:[ '-][a-zA-Z]+)*$";
    String HOUSE_OR_APARTMENT_NUMBER_REGEX = "^\\d+[A-Za-z0-9-]*$";
    String DATE_REGEX = "\\d{2}/\\d{2}/\\d{4}"; //DD_MM_YYYY

}
