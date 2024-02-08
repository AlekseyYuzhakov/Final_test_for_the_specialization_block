package AnimalRegistry.Model;

import java.util.ArrayList;
import java.util.Date;

import AnimalRegistry.Animals.Animal;
import AnimalRegistry.Animals.Camel;
import AnimalRegistry.Animals.Cat;
import AnimalRegistry.Animals.Dog;
import AnimalRegistry.Animals.Donkey;
import AnimalRegistry.Animals.Hamster;
import AnimalRegistry.Animals.Horse;

public class AnimalBuilder {

  private String name;
  private Date birthDate;
  private ArrayList<String> commands;
  private int counter = 0;

  public AnimalBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public AnimalBuilder setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
    return this;
  }

  public AnimalBuilder setCommands(ArrayList<String> commands) {
    this.commands = commands;
    return this;
  }

  public void setCounter(int counter) {
    this.counter = counter;
  }

  public int getCounter() {
    return counter;
  }

  public Animal build(int choice) {
    Animal temp = null;
    switch (choice) {
      case 11:
        temp = new Camel(name, birthDate, commands);
        break;
      case 12:
        temp = new Donkey(name, birthDate, commands);
        break;
      case 13:
        temp = new Horse(name, birthDate, commands);
        break;
      case 21:
        temp = new Cat(name, birthDate, commands);
        break;
      case 22:
        temp = new Dog(name, birthDate, commands);
        break;
      case 23:
        temp = new Hamster(name, birthDate, commands);
        break;
      default:
        System.out.println("Что то пошло не так попробуйте еще раз ");
        break;
    }
    return temp;
  }

}
