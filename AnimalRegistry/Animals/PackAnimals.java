package AnimalRegistry.Animals;

import java.util.ArrayList;
import java.util.Date;

public class PackAnimals extends Animal {
  private int counter = 0;

  public PackAnimals(String name, String type, Date birthDate, ArrayList<String> commands) {
    super(name, type, birthDate, commands);
    counter++;
  }
  public int getCounter() {
    return counter;
  }

  @Override
  public String toString() {
    return "Вьючное животное ";
  }

}
