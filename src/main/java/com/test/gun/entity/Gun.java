package com.test.gun.entity;


public class Gun {

  private Integer id;
  private Integer nationId;  //国籍id
  private String gunName;    //名称
  private Integer Lv;        //等级
  private Double Price;      //价格
  private Double caliber;    //口径
  private String gunType;    //类型
  private String note;       //备注

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

  public String getGunName() {
    return gunName;
  }

  public void setGunName(String gunName) {
    this.gunName = gunName;
  }

  public Integer getLv() {
    return Lv;
  }

  public void setLv(Integer Lv) {
    this.Lv = Lv;
  }

  public Double getPrice() {
    return Price;
  }

  public void setPrice(Double Price) {
    this.Price = Price;
  }

  public Double getCaliber() {
    return caliber;
  }

  public void setCaliber(Double caliber) {
    this.caliber = caliber;
  }

  public String getGunType() {
    return gunType;
  }

  public void setGunType(String gunType) {
    this.gunType = gunType;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  @Override
  public String toString() {
    return "Gun{" +
            "id=" + id +
            ", nationId=" + nationId +
            ", gunName='" + gunName + '\'' +
            ", lv=" + Lv +
            ", price=" + Price +
            ", caliber=" + caliber +
            ", gunType='" + gunType + '\'' +
            ", note='" + note + '\'' +
            '}';
  }
}
