package ui;

import data.Pallet;

import javax.swing.*;
import java.awt.*;


public class MenuView extends JFrame {
    public MenuView() {
        configure();
    }

    private void configure(){
        setTitle("Server Connection");
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Pallet.MENU_BG.value());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }

    private void configureTitle(){
        JLabel title = new JLabel("Draw Together");
        title.setFont(new MontserratFont());
        title.setForeground(Pallet.MESSAGE.value());
        add(title);
    }
}
