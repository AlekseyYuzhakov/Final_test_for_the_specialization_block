package AnimalRegistry.Animals;

import java.util.ArrayList;
import java.util.Date;

public class Pets extends Animal {

  private int counter = 0;
  protected String type;

  public Pets(String name, Date birthDate, ArrayList<String> commands) {
    super(name, birthDate, commands);
    this.type = "Домашнее животное";
    counter++;

  }

  public String getType() {
    return type;
  }

  public int getCounter() {
    return counter;
  }

  @Override
  public String getStoregeInfo() {
    return this.toString();
  }

}
