package com.korolev.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private JButton oneBtn = new JButton("1");
    private JButton twoBtn = new JButton("2");
    private JButton threeBtn = new JButton("3");
    private JButton fourBtn = new JButton("4");
    private JButton fiveBtn = new JButton("5");
    private JButton sixBtn = new JButton("6");
    private JButton sevenBtn = new JButton("7");
    private JButton eightBtn = new JButton("8");
    private JButton nineBtn = new JButton("9");
    private JButton zeroBtn = new JButton("0");

    private JButton plusBtn = new JButton("+");
    private JButton minusBtn = new JButton("-");
    private JButton devideBtn = new JButton("/");
    private JButton powBtn = new JButton("*");
    private JButton equalsBtn = new JButton("=");
    private JButton cancelBtn = new JButton("<-");
    private JButton clearBtn = new JButton("CLR");

    JTextField view = new JTextField();

    private String viewText = "";
    private Float firstOperand = 0.0f;
    private Float secondOperand = 0.0f;
    private Float result = 0.0f;
    private char operation = '+';

    public Window(){
        // подготовка окна
        setFocusable(true);
        setTitle("Калькулятор");
        setBounds(0, 0, 400, 530);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // инициализация кнопок
        Font btnFont = new Font("Verdana",0,30);
        oneBtn.setBounds(0,100,100,80);
        oneBtn.setFont(btnFont);
        oneBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSymbol(1);
                repaint();
            }
        });
        add(oneBtn);
        twoBtn.setBounds(100,100,100,80);
        twoBtn.setFont(btnFont);
        twoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSymbol(2);
                repaint();
            }
        });
        add(twoBtn);
        threeBtn.setBounds(200,100,100,80);
        threeBtn.setFont(btnFont);
        threeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSymbol(3);
                repaint();
            }
        });
        add(threeBtn);
        fourBtn.setBounds(0,180,100,80);
        fourBtn.setFont(btnFont);
        fourBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSymbol(4);
                repaint();
            }
        });
        add(fourBtn);
        fiveBtn.setBounds(100,180,100,80);
        fiveBtn.setFont(btnFont);
        fiveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSymbol(5);
                repaint();
            }
        });
        add(fiveBtn);
        sixBtn.setBounds(200,180,100,80);
        sixBtn.setFont(btnFont);
        sixBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSymbol(6);
                repaint();
            }
        });
        add(sixBtn);
        sevenBtn.setBounds(0,260,100,80);
        sevenBtn.setFont(btnFont);
        sevenBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSymbol(7);
                repaint();
            }
        });
        add(sevenBtn);
        eightBtn.setBounds(100,260,100,80);
        eightBtn.setFont(btnFont);
        eightBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSymbol(8);
                repaint();
            }
        });
        add(eightBtn);
        nineBtn.setBounds(200,260,100,80);
        nineBtn.setFont(btnFont);
        nineBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSymbol(9);
                repaint();
            }
        });
        add(nineBtn);
        zeroBtn.setBounds(100,340,100,80);
        zeroBtn.setFont(btnFont);
        zeroBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSymbol(0);
                repaint();
            }
        });
        add(zeroBtn);
        cancelBtn.setBounds(200,340,100,80);
        cancelBtn.setFont(btnFont);
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(viewText.length() > 0) {
                    viewText = viewText.substring(0, viewText.length() - 1);
                    view.setText(viewText);
                    repaint();
                }
            }
        });
        add(cancelBtn);
        clearBtn.setBounds(0,340,100,80);
        clearBtn.setFont(btnFont);
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewText = "";
                view.setText(viewText);
                repaint();
            }
        });
        add(clearBtn);
        plusBtn.setBounds(300,100,100,80);
        plusBtn.setFont(btnFont);
        plusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getParseClear(1);
                operation = '+';
                repaint();
            }
        });
        add(plusBtn);
        minusBtn.setBounds(300,180,100,80);
        minusBtn.setFont(btnFont);
        minusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getParseClear(1);
                operation = '-';
                repaint();
            }
        });
        add(minusBtn);
        devideBtn.setBounds(300,260,100,80);
        devideBtn.setFont(btnFont);
        devideBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getParseClear(1);
                operation = '/';
                repaint();
            }
        });
        add(devideBtn);
        powBtn.setBounds(300,340,100,80);
        powBtn.setFont(btnFont);
        powBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getParseClear(1);
                operation = '*';
                repaint();
            }
        });
        add(powBtn);
        equalsBtn.setBounds(0,420,400,80);
        equalsBtn.setFont(btnFont);
        equalsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getParseClear(2);
                switch(operation){
                    case '+' -> {
                        result = firstOperand + secondOperand;
                    }
                    case '-' -> {
                        result = firstOperand - secondOperand;
                    }
                    case '/' -> {
                        result = firstOperand / secondOperand;
                    }
                    case '*' -> {
                        result = firstOperand * secondOperand;
                    }
                }
                viewText = result.toString();
                view.setText(viewText);
                repaint();
            }
        });
        add(equalsBtn);
        // инициализация окошка
        Font viewFont = new Font("Verdana",1,20);
        view.setBounds(0,0,400,100);
        view.setEditable(false);
        view.setFont(viewFont);
        add(view);

        setVisible(true);
    }

    private void addSymbol(int symb){
        viewText += symb;
        view.setText(viewText);
    }

    private void getParseClear(int operand){
        switch(operand){
            case 1 -> firstOperand = Float.parseFloat(viewText);
            case 2 -> secondOperand = Float.parseFloat(viewText);
        }
        viewText = "";
        view.setText(viewText);
    }
}
