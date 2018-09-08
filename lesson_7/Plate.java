package ru.mylife.homework7;

public class Plate {
    private int food;
    Plate(int food){this.food=food;}
    public void decreaseFood(Cat cat){if (food>=cat.getAppetite()) {food-=cat.getAppetite(); cat.setSatiety(true);} else {cat.setSatiety(false); fillPlate(5); decreaseFood(cat); }}
    public void info(){System.out.println("В тарелке " + food + "ед. еды.");}
    public void fillPlate(int food){this.food+=food; System.out.println("Подсыпали в тарелку " + food + "ед. еды");} //метод с помощью которого можно добавить еды в тарелку
}
