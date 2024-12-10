package ui;

import data.Client;

import javax.swing.*;
import java.awt.*;

public class OptionPanel extends JPanel {
    private Color currentColor = Color.BLACK;
    private int brushSize = 10;

    private final MySizeSlider sizeSlider = new MySizeSlider(JSlider.HORIZONTAL, 0, 50, brushSize);
    private final MyColorChooser colorChooser = new MyColorChooser();
    private final EraserButton eraserButton = new EraserButton();
   // private final ChatView chat;

    public OptionPanel(Client client) {
        //chat = new ChatView(client);
        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(635, 300));
        setVisible(true);

        //Add listeners
        colorChooser.getSelectionModel().addChangeListener(e -> currentColor = colorChooser.getColor());
        eraserButton.addActionListener(e -> currentColor = Color.WHITE);
        sizeSlider.addChangeListener(e -> brushSize = sizeSlider.getValue());

        JPanel colorPanel = new JPanel();
        colorPanel.add(colorChooser);

        JPanel otherPanel = new JPanel();
        otherPanel.add(eraserButton);
        otherPanel.add(sizeSlider);

        JPanel chatPanel = new JPanel();
        chatPanel.add(chat);

        add(colorPanel);
        add(otherPanel);

        JPanel a = new JPanel();
        a.setPreferredSize(new Dimension(400,200));

        add(a);
        add(chatPanel);


    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public int getBrushSize() {
        return brushSize;
    }

    public ChatView getChat(){
        return chat;
    }
}