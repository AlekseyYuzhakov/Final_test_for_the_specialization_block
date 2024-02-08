package AnimalRegistry.Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.Scanner;

import AnimalRegistry.Animals.Animal;
import AnimalRegistry.View.Menu;

public class CoreApp {
  FileHandler fh = new FileHandler();
  String absolutePathString = "Animalstorage.txt";
  Scanner sc = new Scanner(System.in);
  ArrayList<Animal> animalCollection = new ArrayList<Animal>();
  Menu view = Menu.getInstance();

  public void AppStart() {
    view.Greet();
    animalCollection = fh.ReadFile(absolutePathString);
    Boolean flag = true;
    Integer choice = 0;
    Menu view = new Menu();

    while (flag) {
      view.MainMenu();
      sc.hasNext();
      Animal temp = null;
      try {
        choice = sc.nextInt();
      } catch (Exception e) {
        System.out.println("Введены не корректные данные, введите число ");
      }
      switch (choice) {
        case 1:
          boolean duplicatcheck = true;
          temp = create();
          if (temp != null) {
            for (Animal animal : animalCollection) {
              if (temp.getName().equals(animal.getName())) {
                duplicatcheck = false;
                System.out.println("Такое животное уже есть в в cписке " + animal.getName());
                System.out.println("Животное не добавлено в коллекцию ");
              }
            }
            if (duplicatcheck) {
              System.out.println("Животное добавлено в коллекцию ");
              animalCollection.add(temp);
            }
          }
          break;
        case 2:
          for (Animal animal : animalCollection) {
            System.out.println(animal.toString());
          }
          break;
        case 3:
          System.out.println("Напишите имя искомого животного ");
          System.out.println();
          sc.hasNext();
          String search = sc.nextLine();
          String tempComs = "";
          for (Animal animal : animalCollection) {
            if (animal.getName().equals(search)) {
              System.out.println("Укажите через запятую каким командам обучить животное " + animal.getName());
              tempComs = sc.nextLine();
              for (String str : tempComs.strip().split(",")) {
                animal.addCommands(str);
              }

            } else {
              System.out.println("Животного с именем " + search + " в базе нет ");
            }
          }
          break;
        case 4:
          flag = false;
          sc.close();
          fh.WriteFile(absolutePathString, animalCollection);
          break;
        default:
          flag = false;
          break;
      }
    }
  }

  public Animal create() {
    Animal temp = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String name = "";
    Date date = new Date();
    String comandInput = "";
    ArrayList<String> commands = new ArrayList<String>();
    Integer typeChoice = 0;
    Integer kindChoice = 0;
    try {
      view.choseTypeMenu();
      sc.nextLine();
      typeChoice = sc.nextInt();
      if (typeChoice < 1 || typeChoice > 2) {
        throw new Exception("Не корректный ввод ");
      } else {
        typeChoice = typeChoice * 10;
        if (typeChoice == 10) {
          view.choseKindMenuForPacks();
        } else
          view.choseKindMenuForPets();
      }
      kindChoice = sc.nextInt();
      if (kindChoice < 1 || kindChoice > 3) {
        throw new Exception("Не корректный ввод ");
      } else {
        typeChoice = typeChoice + kindChoice;
      }
      System.out.println("Введите имя животного ");
      sc.nextLine();
      name = sc.nextLine();
      try {
        System.out.println("Введите дату рождения животного в формате гггг-мм-дд");
        date = sdf.parse(sc.nextLine());
      } catch (Exception e) {
        throw new Exception("Не удалось разобрать дату ");
      }
      System.out.println("Перечислите через запятую какими командами владеет животное ");
      comandInput = sc.nextLine();
      for (String string : comandInput.strip().split(",")) {
        commands.add(string);
      }

      temp = new AnimalBuilder()
          .setName(name)
          .setBirthDate(date)
          .setCommands(commands)
          .build(typeChoice);

      System.out.println("Животное создано ");
    } catch (Exception e) {
      System.out.println("Выбран не существующий вариант " + e.getMessage());
    }
    return temp;
  }

}
