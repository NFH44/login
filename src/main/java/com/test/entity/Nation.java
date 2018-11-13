package com.test.entity;

public class Nation {
    private int id;
    private String nation;
    private String port;
    private String name;
    private String ename;

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Override
    public String toString() {
        return "Nation{" +
                "id=" + id +
                ", nation='" + nation + '\'' +
                ", port='" + port + '\'' +
                ", name='" + name + '\'' +
                ", ename='" + ename + '\'' +
                '}';
    }
}
