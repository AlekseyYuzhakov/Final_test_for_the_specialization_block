package AnimalRegistry.Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import AnimalRegistry.Animals.Animal;

public class FileHandler {

  public ArrayList<Animal> ReadFile(String absolutePathString) {
    ArrayList<Animal> animalCollection = new ArrayList<Animal>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    try (BufferedReader reader = new BufferedReader(new FileReader(absolutePathString))) {
      String line;
      while ((line = reader.readLine()) != null) {
        Date tempdate = new Date();
        Integer choice = 0;
        ArrayList<String> templist = new ArrayList<>();
        String[] data = line.split(";");
        if (data.length > 0) {
          String type = data[0];
          String kind = data[1];
          choice = getChoice(type, kind);
          String name = data[2];
          String date = data[3];
          try {
            tempdate = sdf.parse(date);

          } catch (Exception e) {
            System.out.println("Не удалось прочитать файл ");
          }
          for (String string : data[4].strip().split(",")) {
            templist.add(string);
          }
          Animal tempAnimal = null;
          tempAnimal = new AnimalBuilder()
              .setName(name)
              .setBirthDate(tempdate)
              .setCommands(templist)
              .build(choice);
          animalCollection.add(tempAnimal);
        }
      }
      System.out.println("Файл прочитан удачно ");
    } catch (Exception e) {
      System.out.println("Прочитать файл не удалось ");
    }
    return animalCollection;
  }

  public void WriteFile(String absolutePathString, ArrayList<Animal> animalCollection) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(absolutePathString, false));) {
      for (Animal animal : animalCollection) {
        String temp = animal.getStoregeInfo();
        writer.write(temp);
      }
      System.out.println("Файл записан удачно ");
      writer.flush();
      writer.close();

    } catch (Exception e) {
      System.out.println("Запись в файл не удалась ");
      System.out.println(e.getMessage());

    }

  }

  public Integer getChoice(String type, String kind) {
    Integer choice = 0;
    if (type.equals("Вьючное животное")) {
      choice = 10;
    } else {
      if (type.equals("Домашнее животное")) {
        choice = 20;
      }
    }
    switch (kind) {
      case "Верблюд":
        choice += 1;
        break;
      case "Осел":
        choice += 2;
        break;
      case "Лошадь":
        choice += 3;
        break;
      case "Кот":
        choice += 1;
        break;
      case "Собака":
        choice += 2;
        break;
      case "Хомяк":
        choice += 3;
        break;
      default:
        choice = 0;
        break;
    }
    return choice;
  }

}
