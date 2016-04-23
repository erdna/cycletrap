package com.erdna.cycletrap.model;

/**
 * Created by André Nitzschke on 23/04/16.
 */
public class Trap {
    public long id;
    public String name;
    public double latitude;
    public double longitude;

    @Override
    public String toString() {
        return String.format("Trap[id=%d, name='%s']", id, name);
    }

}