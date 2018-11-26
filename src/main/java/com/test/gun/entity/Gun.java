package com.test.gun.entity;


public class Gun {

  private Integer id;
  private Integer nationId;  //国籍id
  private String gunName;    //名称
  private Integer Lv;        //等级
  private String angle;      //角度
  private String rotSpeet;   //转速
  private Double loadTime;   //装填时间
  private String muzzV;      //初速
  private Double Price;      //价格
  private Double caliber;    //口径
  private String gunType;    //类型
  private String note;       //备注

  @Override
  public String toString() {
    return "Gun{" +
            "id=" + id +
            ", nationId=" + nationId +
            ", gunName='" + gunName + '\'' +
            ", Lv=" + Lv +
            ", angle='" + angle + '\'' +
            ", rotSpeet='" + rotSpeet + '\'' +
            ", loadTime=" + loadTime +
            ", muzzV='" + muzzV + '\'' +
            ", Price=" + Price +
            ", caliber=" + caliber +
            ", gunType='" + gunType + '\'' +
            ", note='" + note + '\'' +
            '}';
  }

  public String getAngle() {
    return angle;
  }

  public void setAngle(String angle) {
    this.angle = angle;
  }

  public String getRotSpeet() {
    return rotSpeet;
  }

  public void setRotSpeet(String rotSpeet) {
    this.rotSpeet = rotSpeet;
  }

  public Double getLoadTime() {
    return loadTime;
  }

  public void setLoadTime(Double loadTime) {
    this.loadTime = loadTime;
  }

  public String getMuzzV() {
    return muzzV;
  }

  public void setMuzzV(String muzzV) {
    this.muzzV = muzzV;
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

}
