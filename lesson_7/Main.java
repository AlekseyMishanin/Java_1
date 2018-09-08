package ru.mylife.homework7;

import java.util.Random;
/*
1. Расширить задачу про котов и тарелки с едой.
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
(например, в миске 10 еды, а кот пытается покушать 15-20).
3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту
удалось покушать (хватило еды), сытость = true.
4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть
наполовину сыт (это сделано для упрощения логики программы).
5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и
потом вывести информацию о сытости котов в консоль.
6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
*/
public class Main {

    public static void main(String[] args) {
        String[] nameCat = {"Барсик","Мурзик", "Рыжик", "Палыч", "Трюдо", "Ньютон", "Трамп", "Свинтус", "Хоббит", "Царь"};
        final int LEN = nameCat.length;
        Cat[] cats = new Cat[LEN];
        Plate pl = new Plate(70);
        Random rand = new Random();
        for (int i = 0; i < LEN; i++) {
            cats[i] = new Cat(nameCat[rand.nextInt(LEN-1)],rand.nextInt(20));
            cats[i].info();
        }
        System.out.println();
        System.out.println("Кормим котов");
        for (Cat c: cats) {
            pl.info();
            c.eat(pl);
            if(c.getSatiety()){System.out.println(c.getName() + " наелся");} else {System.out.println(c.getName() + " не наелся");}
        }
    }
}
