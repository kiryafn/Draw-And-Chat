package ui;

import data.ChatContract;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class ChatView extends JPanel implements ChatContract.View {
    private JTextPane  chatArea   = new JTextPane();;
    private JTextField inputField = new JTextField();
    private JButton    sendButton = new JButton("Send");

    public ChatView() {
        setLayout(new BorderLayout());

        chatArea.setEditable(false);
        chatArea.setPreferredSize(new Dimension(550, 300));

        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        // 2. Панель для ввода сообщений
        JPanel inputPanel = new JPanel(new BorderLayout());

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);
    }

    @Override
    public void showMessage(String prefix, Color prexif_color, String sender, Color sender_color, String message, Color message_color) {
        StyledDocument doc = chatArea.getStyledDocument();

        Style prefixStyle = chatArea.addStyle("SenderStyle", null);
        StyleConstants.setForeground(prefixStyle, prexif_color);
        StyleConstants.setBold(prefixStyle, true);

        Style senderStyle = chatArea.addStyle("MessageStyle", null);
        StyleConstants.setForeground(senderStyle, sender_color);

        Style messageStyle = chatArea.addStyle("MessageStyle", null);
        StyleConstants.setForeground(messageStyle, message_color);

        try {
            doc.insertString(doc.getLength(), prefix + " ", prefixStyle);
            doc.insertString(doc.getLength(), sender + ": ", senderStyle);
            doc.insertString(doc.getLength(), message + "\n", messageStyle);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clearInput() {

    }
}