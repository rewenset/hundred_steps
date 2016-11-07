package ua.training.models;

import ua.training.models.entities.Record;

import java.util.ArrayList;

/**
 * Created by Andriy on 06.11.2016.
 */
public class Model {
    private ArrayList<Record> records = new ArrayList<Record>();

    public void addRecord(Record record) {
        records.add(record);
    }
}
