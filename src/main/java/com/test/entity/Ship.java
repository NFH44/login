package com.test.entity;

public class Ship {
    //id
    private int id;
    //nationid
    private int nationId;
    //舰名
    private String shipName;
    //等级
    private int Lv;
    //类型
    private String shipType;
    //造价
    private Double Price;
    private int DP;
    //排水
    private int Displacement;
    //兵位
    private int Soldier;
    //船位
    private int Pos;
    //辅助位
    private int Aid;
    //低速
    private int lowSpeed;
    //极速
    private int extSpeed;
    //备注
    private String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNationId() {
        return nationId;
    }

    public void setNationId(int nationId) {
        this.nationId = nationId;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public int getLv() {
        return Lv;
    }

    public void setLv(int lv) {
        Lv = lv;
    }

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public int getDP() {
        return DP;
    }

    public void setDP(int DP) {
        this.DP = DP;
    }

    public int getDisplacement() {
        return Displacement;
    }

    public void setDisplacement(int displacement) {
        Displacement = displacement;
    }

    public int getSoldier() {
        return Soldier;
    }

    public void setSoldier(int soldier) {
        Soldier = soldier;
    }

    public int getPos() {
        return Pos;
    }

    public void setPos(int pos) {
        Pos = pos;
    }

    public int getAid() {
        return Aid;
    }

    public void setAid(int aid) {
        Aid = aid;
    }

    public int getLowSpeed() {
        return lowSpeed;
    }

    public void setLowSpeed(int lowSpeed) {
        this.lowSpeed = lowSpeed;
    }

    public int getExtSpeed() {
        return extSpeed;
    }

    public void setExtSpeed(int extSpeed) {
        this.extSpeed = extSpeed;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "id=" + id +
                ", nationId=" + nationId +
                ", shipName='" + shipName + '\'' +
                ", Lv=" + Lv +
                ", shipType='" + shipType + '\'' +
                ", Price=" + Price +
                ", DP=" + DP +
                ", Displacement=" + Displacement +
                ", Soldier=" + Soldier +
                ", Pos=" + Pos +
                ", Aid=" + Aid +
                ", lowSpeed=" + lowSpeed +
                ", extSpeed=" + extSpeed +
                ", note='" + note + '\'' +
                '}';
    }
}
