package ru.mylife.HomeWork_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    public MyWindow(){
        setBounds(300,300,400,400);
        setTitle("WindowDemo");
        JPanel panel = new JPanel();        //создаем панель
        panel.setLayout(new FlowLayout());  //определяем компоновщик в панели
        add(panel,BorderLayout.CENTER);     // добавляем панель в родительское окно и растягиваем панель, используя BorderLayout
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton[] jbt = new JButton[20];        //создаем массив объектов JButton
        for (int i = 0; i < jbt.length; i++) {
            jbt[i] = new JButton("#" + i);  //создаем объект JButton
            panel.add(jbt[i]);                  //привязываем кнопку к панели
            int temp = i;                       //определяем неизменяемую локальную переменную для лямбда выражения
            jbt[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel.setBackground(Color.getHSBColor(temp*10,temp*10,temp*10)); //перекрашиваем фон панели
                    for (Component compot : panel.getComponents()){                           //пробегаем по всем компонентам, привязанным к панели
                        compot.setBackground(Color.getHSBColor(temp*(int)(Math.random()*10),temp*(int)(Math.random()*10),temp*(int)(Math.random()*10))); //рандомно раскрашиваем кнопки
                    }
                }
            });
        }
        setVisible(true);
    }
}
