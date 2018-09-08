package ru.mylife.cross_zero;

/*
3 * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и
количества фишек 4. Очень желательно не делать это просто набором условий для каждой из
возможных ситуаций;
*/

/*
Описание решения содержится в цикле
*/

import java.util.Random;
import java.util.Scanner;

public class Task_3 {

    private  char map[][];
    private  final int SIZE = 5;
    private  final int DOTS_TO_WINE=4;

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

    private void initMap(){
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
        //Решением являются два последовательных цикла: первый цикл просматривает столбцы/строки;
        //второй цикл просматривает диагонали.


        for (int i = 0, k1=0, k2=0; i < SIZE; i++) {
            // k1 - счетчик, подсчитывающий кол-во непрерывных, последовательных совпадений значений ячейки строки с символом symb
            // k2 - счетчик, подсчитывающий кол-во непрерывных, последовательных совпадений значений ячейки столбца с символом symb
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j]==symb) {      //если символ ячейки строки совпадает с symb
                    k1++;                   //увеличиваем значение счетчика
                    if(k1==DOTS_TO_WINE){   //если значение счетчика = DOTS_TO_WINE (количество совпадений необходимых для выигрыша)
                        return true;}       //возвращаем true. Игра завершена. Есть победитель
                } else {                    //в противном случае, если значение текущей ячейки не равно symb
                    if(k1>0){k1=0;}         //обнуляем счетчик
                }
                //идентичная схема, но вместо строк рассматриваются столбцы
                if (map[j][i]==symb) {k2++; if(k2==DOTS_TO_WINE){return true;}} else {if(k2>0){k2--;}}
            }
            k1=k2=0; //обнуляем счетчики для следующей итерации
        }
        for (int i = 0, k1=0,k2=0,k3=0,k4=0; (i+DOTS_TO_WINE)<=SIZE; i++) {*/
            /*
            k1,k2,k3,k4 - счетчики необходимые для подсчета кол-ва непрерывных, последовательных совпадений с symb по диагоналям
            k1,k2 - для диагоналей с вершиной в верхнем левом углу
            k3,k4 - для диагоналей с вершиной в верхнем правом углу
            Количество итераций внешнего цикла зависит от DOTS_TO_WINE, которая определяет с одной стороны кол-во последовательных
            совпадений необходимых для выигрыша, с другой кол-во смещений в сторону от центра, при которых возможно решение задачи.
            Например,   SIZE = 5;
                        DOTS_TO_WINE=3;
                        Количество возможных смещений от диагонали = SIZE - DOTS_TO_WINE = 2;
                        Т.е. выигрышная комбинация может содержаться не только на диагонали, но и на отрезках
                        расположенных с левой или правой стороны на удалении 1 или 2 шага.
            */
            //for (int j = 0, x=SIZE-1; (j+i) < SIZE&&(x-i)>=0; j++,x--) {
                /*
                Цикл просматривает диагональ с вершиной в левом верхнем углу.
                При смещениии в сторону (i>0) цикл начинает просматривавать отрезки слева и справа от диагонали,
                удаленные от диагонали на i шагов.
                */
             /*   if (map[j+i][j]==symb) {        //Есди значение ячейки совпадает с  symb,
                    k1++;                       //увеличивается соответствующий счетчик.
                    if (k1 == DOTS_TO_WINE) {   //Если значение счетчика становится равным DOTS_TO_WINE, найдена выигрышная последовательность.
                        return true;            //Выходим из цикла, игра завершена.
                    }
                }else {
                    k1=0;                       //Если значение ячейки не совпадает с symb, обнуляем счетчик и начинаем считать заново
                }
                if (map[j][j+i]==symb) {k2++; if(k2==DOTS_TO_WINE){return true;}} else {k2=0;}*/
                /*
                Цикл просматривает диагональ с вершиной в правом верхнем углу.
                При смещениии в сторону (i>0) цикл начинает просматривавать отрезки слева и справа от диагонали,
                удаленные от диагонали на i шагов.
                */
              /*  if (map[j+i][x]==symb) {k3++; if(k3==DOTS_TO_WINE){return true;}} else {k3=0;}
                if (map[j][x-i]==symb) {k4++; if(k4==DOTS_TO_WINE){return true;}} else {k4=0;}
            }
            k1=k2=k3=k4=0; //елси при текущем i (смещении) не найдена выигрышная последовательность, то обнуяем все счетчики
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