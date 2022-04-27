package Figures.Visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerAction implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        System.out.println("Нажатие кнопки! От - " +
                e.getActionCommand() + "\n");

    }
}