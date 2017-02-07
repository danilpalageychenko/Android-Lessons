package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;




/**
 * Created by _dani on 07.02.2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1,"com.example.danil.android.daoGenerator");
        Entity audio = schema.addEntity("Audio");
        audio.addIdProperty().autoincrement();
        audio.addStringProperty("title").notNull();
        audio.addIntProperty("duration");

        DaoGenerator daoGenerator = new DaoGenerator();
        daoGenerator.generateAll(schema, args[0]);
    }
}
