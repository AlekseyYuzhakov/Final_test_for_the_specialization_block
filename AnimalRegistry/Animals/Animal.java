package AnimalRegistry.Animals;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Animal {

  private String name;
  private Date birthDate;
  private ArrayList<String> commands;
  private int counter = 0;

  public Animal(String name, Date birthDate, ArrayList<String> commands) {
    this.name = name;
    this.birthDate = birthDate;
    this.commands = commands;
    counter++;
  }

  public String getName() {
    return name;
  }

  public String getBirthDate() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    return sdf.format(birthDate);

  }

  public String getCommands() {
    String allcommands = "";
    for (String string : commands) {
      allcommands += string + ",";
    }
    return allcommands;
  }

  public void addCommands(String newCommands) {
    this.commands.add(newCommands);
  }

  public int getCounter() {
    return counter;
  }

  public String getStoregeInfo() {
    return this.toString();
  }
  
  
  public boolean equals(Animal o) {
    return this.name == o.name;
  }

  @Override
  public String toString() {
    return name + "," + birthDate + "," + commands.toString();
  }

}
