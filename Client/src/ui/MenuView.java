package ui;

import data.enums.Pallet;

import javax.swing.*;
import java.awt.*;


public class MenuView extends JFrame {
    public MenuView() {
        configure();
        configureTitle();
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

    private void configureTitle() {
        JLabel title = new JLabel("Draw Together");
        title.setVisible(true);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title);
        title.setVerticalAlignment(SwingConstants.CENTER);
    }
}
