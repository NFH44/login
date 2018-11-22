package com.test.armour.entity;


public class Armour {

  private Integer id;
  private Integer nationId;
  private String  armName;
  private Integer kg;
  private Double  price;
  private Double  APdefense;  //ap防御
  private Double  HEdefense;  //he防御
  private Double  waterCabin; //防水隔舱
  private Integer torpedo;    //鱼雷带

  @Override
  public String toString() {
    return "Armour{" +
            "id=" + id +
            ", nationId=" + nationId +
            ", armName='" + armName + '\'' +
            ", kg=" + kg +
            ", price=" + price +
            ", APdefense=" + APdefense +
            ", HEdefense=" + HEdefense +
            ", waterCabin=" + waterCabin +
            ", torpedo=" + torpedo +
            '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getNationId() {
    return nationId;
  }

  public void setNationId(Integer nationId) {
    this.nationId = nationId;
  }

  public String getArmName() {
    return armName;
  }

  public void setArmName(String armName) {
    this.armName = armName;
  }

  public Integer getKg() {
    return kg;
  }

  public void setKg(Integer kg) {
    this.kg = kg;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getAPdefense() {
    return APdefense;
  }

  public void setAPdefense(Double APdefense) {
    this.APdefense = APdefense;
  }

  public Double getHEdefense() {
    return HEdefense;
  }

  public void setHEdefense(Double HEdefense) {
    this.HEdefense = HEdefense;
  }

  public Double getWaterCabin() {
    return waterCabin;
  }

  public void setWaterCabin(Double waterCabin) {
    this.waterCabin = waterCabin;
  }

  public Integer getTorpedo() {
    return torpedo;
  }

  public void setTorpedo(Integer torpedo) {
    this.torpedo = torpedo;
  }
}
