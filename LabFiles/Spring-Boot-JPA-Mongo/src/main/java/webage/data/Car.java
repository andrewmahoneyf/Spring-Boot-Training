package webage.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vehicles")
public class Car {

  @Id
  private String id;

  private String make;
  private String model;
  private int year;

  public Car() {}

  public String getId() {
    return id;
  }

  public String getMake() {
    return make;
  }

  public String getModel() {
    return model;
  }

  public int getYear() {
    return year;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setYear(int year) {
    this.year = year;
  }

}
