package AnimalRegistry.Animals;

import java.util.ArrayList;
import java.util.Date;

public class PackAnimals extends Animal {
  private int counter = 0;
  protected String type;

  public PackAnimals(String name, Date birthDate, ArrayList<String> commands) {
    super(name, birthDate, commands);
    this.type = "Вьючное животное";
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
