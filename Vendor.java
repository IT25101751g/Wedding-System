package model;

public class Vendor {
    private int id;
    private String name;
    private String service;

    public Vendor(int id, String name, String service) {
        this.id = id;
        this.name = name;
        this.service = service;
    }

    public String toString() {
        return name + " (" + service + ")";
    }


    public int getId() { return id; }
    public String getName() { return name; }
    public String getService() { return service; }
}