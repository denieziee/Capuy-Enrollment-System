package org.example.Entities;

public abstract class Person {
    private String id;
    private String name;

    public Person() {
        this("unknown");
    }

    public Person(String id) {
        this(id, "unknown");
    }

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getID() { return id; }
    public void setID(String ID) { this.id = ID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}