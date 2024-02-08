package AnimalRegistry.Animals;

import java.util.ArrayList;
import java.util.Date;

public class Horse extends PackAnimals {

  private String kind;
  private int counter = 0;

  public Horse(String name, Date birthDate, ArrayList<String> commands) {
    super(name, birthDate, commands);
    this.kind = "Лошадь";
    counter++;
  }

  public String getKind() {
    return kind;
  }

  public int getCounter() {
    return counter;
  }

  @Override
  public String getStoregeInfo() {
    return super.type + ";" + kind + ";" + super.getName() + ";" + super.getBirthDate() + ";" + super.getCommands()
        + ";\n";
  }

  @Override
  public String toString() {
    return super.type + " " + kind + " по имени " + super.getName() + " с датой рождения " + super.getBirthDate()
        + " умеет исполнять команды " + super.getCommands();
  }

}
