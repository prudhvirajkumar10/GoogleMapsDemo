package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class DatabaseHelper {

    public static void main(String[] args) {
        Schema schema = new Schema(1, "com.assessment.googlemapsdemo.database");
        schema.enableKeepSectionsByDefault();

        addTables(schema);

        try {
            new DaoGenerator().generateAll(schema, "./app/src/main/java");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void addTables(final Schema schema){
        addPlaceEntities(schema);
    }

    private static Entity addPlaceEntities(final Schema schema){
        Entity place = schema.addEntity("Place");
        place.addIdProperty().primaryKey().autoincrement();
        place.addLongProperty("place_id").notNull();
        place.addStringProperty("name").notNull();
        place.addStringProperty("latitude").notNull();
        place.addStringProperty("longitude").notNull();
        return place;
    }
}
