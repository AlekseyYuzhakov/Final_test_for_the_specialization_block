package AnimalRegistry.Animals;

import java.util.ArrayList;
import java.util.Date;

public class Camel extends PackAnimals {

  private String kind;
  private int counter = 0;

  public Camel(String name, Date birthDate, ArrayList<String> commands) {
    super(name, birthDate, commands);
    this.kind = "Верблюд";
    counter++;

  }

  public String getKind() {
    return kind;
  }

  public int getCounter() {
    return counter;
  }

  public boolean equals(Animal o) {
    return super.getName() == o.getName();
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
