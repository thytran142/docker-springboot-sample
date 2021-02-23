package com.example.ec.domain;

/**
 * Created by maryellenbowman on 7/3/16.
 */

/**
 * Enumeration of the level of effort.
 *
 * Created by Mary Ellen Bowman
 */
public enum Difficulty {
    Easy("Easy"), Medium("Medium"), Difficult("Difficult"), Varies("Varies");

    private String label;

    private Difficulty(String label) {
        this.label = label;
    }

    public static Difficulty findByLabel(String byLabel) {
        for(Difficulty d:Difficulty.values()) {
            if (d.label.equalsIgnoreCase(byLabel)) {
                return d;
            }
        }
        return null;
    }
    public String getLabel() {
        return this.label;
    }

}
