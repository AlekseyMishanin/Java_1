package ru.mylife.cross_zero;

import java.util.Random;
import java.util.Scanner;

/*
2 Переделать проверку победы, чтобы она не была реализована просто набором условий,
        например, с использованием циклов.
*/

/*
Решение: в медоте checkWin() заменил список условных операторов if на цикл
*/

public class Task_2 {

    private  char map[][];
    private  final int SIZE = 3;
    private  final int DOTS_TO_WINE=3;

    private  final char DOT_EMPTY = '*';
    private  final char DOT_X = 'X';
    private  final char DOT_O = 'O';

    private  Scanner sc = new Scanner(System.in);
    private  Random rand = new Random();

    public void playGame () {

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

    private void printMap(){
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
    private  boolean isMapFull(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j]==DOT_EMPTY){return false;}
            }
        }
        return true;
    }

    private void humanTurn(){
        int x,y;
        do {
            System.out.println("Введите коордитаны в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isValidCell(x,y));
        map[x][y]=DOT_X;
    }

    private boolean isValidCell(int x, int y){
        if(x<0||x>=SIZE||y<0||y>=SIZE) {return false;}
        if(map[x][y]==DOT_EMPTY) {return true;}
        return false;
    }

    private void pcTurn(){
        int x,y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isValidCell(x,y));
        System.out.println("Компьютер походил в точку " + (x + 1) + (y +1));
        map[x][y] = DOT_O;
    }

    private boolean checkWin(char symb){
        /*
        for (int i = 0, l=0, k=0; i < SIZE; i++) {
            //цикл проверяет совпадения по горизонтали/вертикали
            // l - подсчитывает по горизонтали количество символов совпадающих с symb
            // k - подсчитывает по вертикали количество символов совпадающих с symb
            for (int j = 0; j < SIZE; j++) {
                //за одну итерацию просматривается одна строка и один столпец
                //при наличии сопадение с symb соответствующий счетчик увеличивается на 1
                if (map[i][j]==symb) {l++;}
                if (map[j][i]==symb) {k++;}
            }
            //если значение одного из счетчиков равно DOTS_TO_WINE (необходимое кол-во совпадений для выигрыша)
            //то возвращаем true. В противном случае обнуляем счетчики и переходим к следующей строке и столбцу
            if(l==DOTS_TO_WINE||k==DOTS_TO_WINE){return true;} else {l=k=0;}
        }
        for (int i = 0, j=SIZE-i-1, l=0, k=0; i < SIZE&&j>=0; i++,j--) {
            //цикл проверяет совпадения по диагонали
            // l - подсчитывает по диагонали (вершина (0,0)) количество символов совпадающих с symb
            // k - подсчитывает по диагонали (вершина (0,N-1)количество символов совпадающих с symb
            if (map[i][i]==symb){l++;}
            if (map[i][j]==symb){k++;}
            //если значение одного из счетчиков равно DOTS_TO_WINE (необходимое кол-во совпадений для выигрыша)
            //то возвращаем true.
            if (l==DOTS_TO_WINE||k==DOTS_TO_WINE){return true;}
        }*/

        for (int shift_down=0, shift_right=0, step=0; step<=((SIZE*4)-(DOTS_TO_WINE*4)); step++){
            for(int i = 0,win_diagonal_1=0,win_diagonal_2=0; i<(SIZE-(SIZE-DOTS_TO_WINE)); i++){
                for (int j = 0, win_line=0, win_column=0; j < (SIZE-(SIZE-DOTS_TO_WINE)); j++) {
                    if (map[i+shift_down][j+shift_right]==symb) {win_line++;}
                    if (map[j+shift_down][i+shift_right]==symb) {win_column++;}
                    if (win_line==DOTS_TO_WINE||win_column==DOTS_TO_WINE){return true;}
                }
                if (map[i+shift_down][i+shift_right]==symb){win_diagonal_1++;}
                if (map[i+shift_down][(SIZE-1-i)+shift_right]==symb){win_diagonal_2++;}
                if (win_diagonal_1==DOTS_TO_WINE||win_diagonal_2==DOTS_TO_WINE){return true;}
            }
            if((shift_down+DOTS_TO_WINE)<=SIZE){
                shift_down++;
            } else{
                shift_down=0;
                shift_right++;
            }
        }
        return false;
    }
}
