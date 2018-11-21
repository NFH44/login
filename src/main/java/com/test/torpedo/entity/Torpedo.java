package com.test.torpedo.entity;
public class Torpedo {

  private Integer id;
  private Integer nationId;
  private String  name;
  private Integer lv;
  private Integer price;
  private Integer amount;   //联装
  private Integer time;     //装填时间
  private Integer caliber;

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getLv() {
    return lv;
  }

  public void setLv(Integer lv) {
    this.lv = lv;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public Integer getTime() {
    return time;
  }

  public void setTime(Integer time) {
    this.time = time;
  }

  public Integer getCaliber() {
    return caliber;
  }

  public void setCaliber(Integer caliber) {
    this.caliber = caliber;
  }

  @Override
  public String toString() {
    return "Torpedo{" +
            "id=" + id +
            ", nationId=" + nationId +
            ", name='" + name + '\'' +
            ", lv=" + lv +
            ", price=" + price +
            ", amount=" + amount +
            ", time=" + time +
            ", caliber=" + caliber +
            '}';
  }
}
