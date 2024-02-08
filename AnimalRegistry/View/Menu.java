package AnimalRegistry.View;

public class Menu {

  private static Menu instance;

  public static Menu getInstance() {
    if (instance == null) {
      return new Menu();
    }
    return instance;
  }

  public void Greet() {
    System.out.println("Приветствую пользователь ");
  }

  public void choseTypeMenu() {
    System.out.println("Выберете тип животного: ");
    System.out.println("1. Вьючное животное ");
    System.out.println("2. Домашние животное ");

  }

  public void choseKindMenuForPets() {
    System.out.println("Выберете вид домашнего животного: ");
    System.out.println("1. Кошка ");
    System.out.println("2. Собака ");
    System.out.println("3. Хомяк ");
  }

  public void choseKindMenuForPacks() {
    System.out.println("Выберете вид вьючного животного: ");
    System.out.println("1. Верблюд ");
    System.out.println("2. Осел ");
    System.out.println("3. Лошадь ");

  }

  public void MainMenu() {
    System.out.println("1. Добавить живонтное ");
    System.out.println("2. Посмотреть список животных ");
    System.out.println("3. Научить животное новой команде ");
    System.out.println("4. Выйти ");
  }

}
