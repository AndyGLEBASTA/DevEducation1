package Figures.Visual;

import Figures.Figure;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerAction implements ActionListener {
    Figure x;
    ListenerAction(Figure x){
        this.x = x;
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(this.x);

    }
}