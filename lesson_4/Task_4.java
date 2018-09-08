package ru.mylife.cross_zero;

import java.util.Random;
import java.util.Scanner;

/*
4 *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
*/

/*
Описание решения содержится в цикле
*/

public class Task_4 {

    private  char map[][];
    private  final int SIZE = 5;
    private  final int DOTS_TO_WINE=4;

    private  final char DOT_EMPTY = '*';
    private  final char DOT_X = 'X';
    private  final char DOT_O = 'O';
    private  final int DIFFICULTY_LEVEL = 3;

    private  Scanner sc = new Scanner(System.in);
    private  Random rand = new Random();

    public void playGame() {

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
        /*
        Вкратце смысл следующий: последовательно просматриваются строки/столбцы/диагонали/отрезки, смещенные от диагонали
        на опр.количество шагов на предмет наличия непрерывной последовательности из символов DOT_X в количестве DIFFICULTY_LEVEL.
        Если данный отрезок найден, то запускается новый цикл, который просматривает этот отрезок на наличие символа DOT_O. Если данный
        символ размещен в отрезке, то компьютер полагает, что ранее успешно поднасрал игроку, далее начинает просматриваться
        следующий отрезок. Если при просмотре строки символ DOT_O не найден, то осуществляется поиск символа DOT_EMPTY. В найденной
        ячейке массива значение DOT_EMPTY заменяется на DOT_O. Если в циклах не найдены отрезки с интересующими
        последовательностями, то машина полагает, что игрок пока не представляет угрозы, поэтому запускается последний цикл в котором
        рандомно выбирается ячейка, которой присваивается DOT_O
        */
        int x,y;
        for (int i = 0, k1=0, k2=0; i < SIZE; i++) {
            //k1,k2 - счетчики, для подсчета количества непрерывных совпадений с символом DOT_X
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j]==DOT_X) {         //если в отрезке найден DOT_X
                    k1++;                       //увеличиваем значение счетчика на 1
                    if(k1>=DIFFICULTY_LEVEL){   //если значение счетички >= DIFFICULTY_LEVEL
                        for (int j1 = 0; j1 < SIZE; j1++) { //запускаем цикл для поиска DOT_O и DOT_EMPTY
                            if(map[i][j1]==DOT_O) {         //если найдено DOT_O
                                break;                      //завершаем цикл
                            }
                            if (map[i][j1]==DOT_EMPTY) {    //если найдено DOT_EMPTY
                                map[i][j1]=DOT_O;           //меняем значение на DOT_O
                                return;                     //выходим из метода
                            }
                        }
                    }
                }
                if (map[j][i]==DOT_X) {k2++; if(k2>=DIFFICULTY_LEVEL){
                    for (int j1 = 0; j1 < SIZE; j1++) {
                        if(map[j1][i]==DOT_O) {
                            break;
                        }
                        if (map[j1][i]==DOT_EMPTY) {
                            map[j1][i]=DOT_O;
                            return;
                        }
                    }
                }
                }
            }
            k1=k2=0;
        }
        for (int i = 0, k1=0,k2=0,k3=0,k4=0; (i+DOTS_TO_WINE)<=SIZE; i++) {
            for (int j = 0, u=SIZE-1; (j+i) < SIZE&&(u-i)>=0; j++,u--) {
                if (map[j+i][j]==DOT_X) {
                    k1++;
                    if(k1==DIFFICULTY_LEVEL){
                        for (int j1 = j, u1=SIZE-1; (j1+i) < SIZE&&(u1-i)>=0; j1++,u1--) {
                            if(map[j1+i][j1]==DOT_O) {
                                break;
                            }
                            if (map[j1+i][j1]==DOT_EMPTY) {
                                map[j1+i][j1]=DOT_O;
                                return;
                            }
                        }
                    }
                }
                if (map[j][j+i]==DOT_X) {
                    k2++;
                    if(k2==DIFFICULTY_LEVEL){
                        for (int j1 = j, u1=SIZE-1; (j1+i) < SIZE&&(u1-i)>=0; j1++,u1--) {
                            if(map[j1][j1+i]==DOT_O) {
                                break;
                            }
                        if (map[j1][j1+i]==DOT_EMPTY) {
                                map[j1][j1+i]=DOT_O;
                                return;
                            }
                        }
                    }
                }
                if (map[j+i][u]==DOT_X) {
                    k3++;
                    if(k3==DIFFICULTY_LEVEL){
                        for (int j1 = 0, u1=SIZE-1; (j1+i) < SIZE&&(u1-i)>=0; j1++,u1--) {
                            if(map[j1+i][u1]==DOT_O) {
                                break;
                            }
                            if (map[j1+i][u1]==DOT_EMPTY) {
                                map[j1+i][u1]=DOT_O;
                                return;
                            }
                        }
                    }
                }
                if (map[j][u-i]==DOT_X) {k4++; if(k4==DIFFICULTY_LEVEL){
                    for (int j1 = 0, u1=SIZE-1; (j1+i) < SIZE&&(u1-i)>=0; j1++,u1--) {
                        if(map[j1][u1-i]==DOT_O) {
                            break;
                        }
                        if (map[j1][u1-i]==DOT_EMPTY) {
                            map[j1][u1-i]=DOT_O;
                            return;
                        }
                    }
                }
                }
            }
            k1=k2=k3=k4=0;
        }
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isValidCell(x,y));
        System.out.println("Компьютер походил в точку " + (x + 1) + (y +1));
        map[x][y] = DOT_O;



    }

    private  boolean checkWin(char symb){
        /*описание работы данного цикла содержится в одноименном методе класса Task_3*/
       /* for (int i = 0, k1=0, k2=0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j]==symb) {k1++; if(k1==DOTS_TO_WINE){return true;}} else {k1=0;}
                if (map[j][i]==symb) {k2++; if(k2==DOTS_TO_WINE){return true;}} else {k2=0;}
            }
            k1=k2=0;
        }
        for (int i = 0, k1=0,k2=0,k3=0,k4=0; (i+DOTS_TO_WINE)<=SIZE; i++) {
            for (int j = 0, x=SIZE-1; (j+i) < SIZE&&(x-i)>=0; j++,x--) {
                if (map[j+i][j]==symb) {k1++; if(k1==DOTS_TO_WINE){return true;}} else {k1=0;}
                if (map[j][j+i]==symb) {k2++; if(k2==DOTS_TO_WINE){return true;}} else {k2=0;}
                if (map[j+i][x]==symb) {k3++; if(k3==DOTS_TO_WINE){return true;}} else {k3=0;}
                if (map[j][x-i]==symb) {k4++; if(k4==DOTS_TO_WINE){return true;}} else {k4=0;}
            }
            k1=k2=k3=k4=0;
        }*/
        for (int shift_down=0, shift_right=0, step=0; step<((SIZE*4)-(DOTS_TO_WINE*4)); step++){
            for(int i = 0,win_diagonal_1=0,win_diagonal_2=0; i<(SIZE-(SIZE-DOTS_TO_WINE)); i++){
                for (int j = 0, win_line=0, win_column=0; j < (SIZE-(SIZE-DOTS_TO_WINE)); j++) {
                    if (map[i+shift_down][j+shift_right]==symb) {win_line++;}
                    if (map[j+shift_down][i+shift_right]==symb) {win_column++;}
                    if (win_line==DOTS_TO_WINE||win_column==DOTS_TO_WINE){return true;}
                }
                if (map[i+shift_down][i+shift_right]==symb){win_diagonal_1++;}
                if (map[i+shift_down][(SIZE-1-i-(SIZE-DOTS_TO_WINE))+shift_right]==symb){win_diagonal_2++;}
                if (win_diagonal_1==DOTS_TO_WINE||win_diagonal_2==DOTS_TO_WINE){return true;}
            }
            if((shift_down+DOTS_TO_WINE)<SIZE){
                shift_down++;
            } else{
                shift_down=0;
                shift_right++;
            }
        }
        return false;
    }
}
