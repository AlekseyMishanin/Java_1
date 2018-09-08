package ru.mylife.cross_zero;

import java.util.Random;
import java.util.Scanner;
/*
1 Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в
методичку;
*/

/*
Решение: просто перепечатал готовое решение задачи из методички
*/

public class Task_1 {

    private   char map[][];
    private  final int SIZE = 3;
    private  final int DOTS_TO_WINE=3;

    private  final char DOT_EMPTY = '*';
    private  final char DOT_X = 'X';
    private  final char DOT_O = 'O';

    private  Scanner sc = new Scanner(System.in);
    private  Random rand = new Random();

    public  void playGame() {

        initMap();
        printMap();
        while(true){
            humanTurn();
            printMap();
            if (checkWin(DOT_X)){
                System.out.println("Победил человиек");
                break;
            }
            if (isMapFull()){
                System.out.println("Ничья");
                break;
            }
            pcTurn();
            printMap();
            if (checkWin(DOT_O)){
                System.out.println("Победила машина");
                break;
            }
            if (isMapFull()){
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    private  void initMap(){
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j]=DOT_EMPTY;
            }
        }
    }

    private  void printMap(){
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private   boolean isMapFull(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j]==DOT_EMPTY){return false;}
            }
        }
        return true;
    }

    private  void humanTurn(){
        int x,y;
        do {
            System.out.println("Введите коордитаны в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isValidCell(x,y));
        map[x][y]=DOT_X;
    }

    private  boolean isValidCell(int x, int y){
        if(x<0||x>=SIZE||y<0||y>=SIZE) {return false;}
        if(map[x][y]==DOT_EMPTY) {return true;}
        return false;
    }

    private  void pcTurn(){
        int x,y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isValidCell(x,y));
        System.out.println("Компьютер походил в точку " + (x + 1) + (y +1));
        map[x][y] = DOT_O;
    }

    private  boolean checkWin(char symb) {
        if (map[0][0] == symb && map[0][1] == symb && map[0][2] == symb) { return true; }
        if (map[1][0] == symb && map[1][1] == symb && map[1][2] == symb) { return true; }
        if (map[2][0] == symb && map[2][1] == symb && map[2][2] == symb) { return true; }
        if (map[0][0] == symb && map[1][0] == symb && map[2][0] == symb) { return true; }
        if (map[0][1] == symb && map[1][1] == symb && map[2][1] == symb) { return true; }
        if (map[0][2] == symb && map[1][2] == symb && map[2][2] == symb) { return true; }
        if (map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) { return true; }
        if (map[2][0] == symb && map[1][1] == symb && map[0][2] == symb) { return true; }
        return false;
    }
}
