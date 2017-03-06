package com.suleiman.material.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suleiman on 02/03/17.
 */

public class Dessert {

    private String name;
    private String description;
    private String firstLetter;

    public Dessert(String name, String description) {
        this.name = name;
        this.firstLetter = String.valueOf(name.charAt(0));
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public static List<Dessert> prepareDesserts(String[] names, String[] descriptions) {
        List<Dessert> desserts = new ArrayList<>(names.length);

        for (int i = 0; i < names.length; i++) {
            Dessert dessert = new Dessert(names[i], descriptions[i]);
            desserts.add(dessert);
        }

        return desserts;
    }
}
