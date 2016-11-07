package ua.training.controllers;

import ua.training.models.Model;
import ua.training.models.entities.Groups;
import ua.training.models.entities.Record;
import ua.training.models.entities.FieldType;
import ua.training.views.View;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Andriy on 06.11.2016.
 */
public class RecordController implements FieldsRegexes {
    private Controller mainController;
    private View view;
    private Model model;

    private static HashMap<FieldType, Pattern> recordFieldsPatterns;

    public RecordController(Controller controller) {
        this.mainController = controller;
        this.view = mainController.getView();
        this.model = mainController.getModel();

        if (recordFieldsPatterns == null) {
            initRecordFieldsPatterns();
        }
    }

    /**
     * Entry point of record creation.
     * @param sc Input stream.
     */
    public void createNewRecord(Scanner sc) {
        Record record = new Record();

        view.printMessageWithNewLine(View.NEW_RECORD_CREATION);
        for (FieldType fieldType : FieldType.values()) {
            record.setField(fieldType, getFieldValue(sc, fieldType));
        }

        model.addRecord(record);
    }

    /**
     * Gets value of specified field type.
     * @param sc Input stream.
     * @param fieldType Type of field.
     * @return Value of specified field.
     */
    public String getFieldValue(Scanner sc, FieldType fieldType) {
        String value;
        String name = fieldType.getName();

        Pattern pattern = recordFieldsPatterns.get(fieldType);
        do {
            view.printField(name);
            value = mainController.getValueWithScanner(sc);
            if (pattern.matcher(value).matches()) {
                break;
            }
            view.printMessageWithNewLine(View.WRONG_INPUT);
        } while (true);

        return value;
    }

    public void initRecordFieldsPatterns() {
        recordFieldsPatterns = new HashMap<FieldType, Pattern>();

        for (FieldType fieldType : FieldType.values()) {
            String regexp = "";
            switch (fieldType) {
                case FIRST_NAME:
                case SECOND_NAME:
                case LAST_NAME:
                    regexp = NAMES_REGEX;
                    break;
                case NICKNAME:
                case SKYPE:
                    regexp = NICKNAME_OR_SKYPE_REGEX;
                    break;
                case COMMENT:
                    regexp = COMMENT_REGEX;
                    break;
                case GROUP:
                    StringBuilder pattern = new StringBuilder();
                    for (Groups group : Groups.values()) {
                        pattern.append("(").append(group).append(")").append("|");
                    }
                    pattern.deleteCharAt(pattern.lastIndexOf("|"));
                    regexp = pattern.toString();
                    break;
                case HOME_PHONE:
                    regexp = HOME_PHONE_REGEX;
                    break;
                case FIRST_MOBILE_PHONE:
                case SECOND_MOBILE_PHONE:
                    regexp = MOBILE_PHONE_REGEX;
                    break;
                case EMAIL:
                    regexp = EMAIL_REGEX;
                    break;
                case ADDRESS_INDEX:
                    regexp = INDEX_REGEX;
                    break;
                case CITY:
                case STREET:
                    regexp = CITY_OR_STREET_REGEX;
                    break;
                case HOUSE_NUMBER:
                case APARTMENT_NUMBER:
                    regexp = HOUSE_OR_APARTMENT_NUMBER_REGEX;
                    break;
                case CREATION_TIME:
                    regexp = DATE_REGEX;
                    break;
            }
            recordFieldsPatterns.put(fieldType, Pattern.compile(regexp));
        }
    }
}
