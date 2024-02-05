package AnimalRegistry.Animals;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Animal {

  private String name;
  private String type;
  private Date birthDate;
  private ArrayList<String> commands;
  private int counter = 0;

  public Animal(String name, String type, Date birthDate, ArrayList<String> commands) {
    this.name = name;
    this.type = type;
    this.birthDate = birthDate;
    this.commands = commands;
    counter++;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public String getBirthDate() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    return sdf.format(birthDate);

  }

  public String getCommands() {
    String allcommands = "";
    for (String string : commands) {
      allcommands += string + ", ";
    }
    return allcommands;
  }

  public int getCounter() {
    return counter;
  }

  @Override
  public String toString() {
    return "Животное по имени " + name + ", вид " + type + ", дата рождения " + birthDate + ", умеет выполнять команды "
        + commands.toString() + "]";
  }
}
