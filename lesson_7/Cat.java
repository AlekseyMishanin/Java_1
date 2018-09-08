package ru.mylife.homework7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety=false;                                                  //поле сытости кота
    public Cat(String name, int appetite){this.name=name; this.appetite=appetite;}
    public int getAppetite(){return appetite;}
    public boolean getSatiety(){return satiety;}
    public String getName(){return name;}
    public void setSatiety(boolean satiety) {this.satiety=satiety;}
    public void eat (Plate p){p.decreaseFood(this);}
    public void info(){System.out.println(name + ", аппетит - " + appetite);}
}
