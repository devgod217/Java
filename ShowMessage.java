package com.java.codegeek;

import javax.swing.*;
import java.awt.event.*;
import java.util.Objects;

public class ShowMessage extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel l_player;
    private JLabel l_content;
    private final HotelGameMain hotelGameMain;
    private final int mode;



    static final int MODE_SHOW_MESSAGE = 1;
    static final int MODE_END_MESSAGE = 2;

    public ShowMessage(HotelGameMain hotelGameMain, int from, Hotel hotel, Player player, float fee, int mode) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        this.hotelGameMain = hotelGameMain;
        this.mode = mode;
        String playerName;
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/java/codegeek/icon/icons8-tom-36.png")));
        if(from == Hotel.P1){

            playerName = "P1";
        }
        else{
            icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/java/codegeek/icon/icons8-jerry-36.png")));
            playerName = "P2";
        }
        l_player.setIcon(icon);
        switch (mode) {
            case MODE_SHOW_MESSAGE -> {
                l_content.setText("<html>Hi," + playerName + "!<br> You have landed on my hotel " + hotel.getName() + ".<br> You must give me £ " + fee + " of overnight fee.<br>Your balance will be deducted as £" + (player.getBalance() - fee) + "</html>");
                buttonCancel.setVisible(false);
            }
            case MODE_END_MESSAGE -> {
                l_content.setText("<html>Hi," + playerName + "!<br> You have landed on my hotel " + hotel.getName() + ".<br> You must give me £ " + fee + " of overnight fee.<br>But your balance is £" + player.getBalance() + ".<br>So Game Over!<br>Retry please.</html>");
                buttonCancel.setVisible(true);
            }
        }
        buttonOK.addActionListener(e -> onOK());

        buttonCancel.addActionListener(e -> onCancel());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        switch (mode) {
            case MODE_END_MESSAGE -> {
                dispose();
                hotelGameMain.gameController.restartGame();
            }
            case MODE_SHOW_MESSAGE -> {

            }
        }
        dispose();
    }

    private void onCancel() {
        System.exit(0);
        dispose();
    }

    public static void main(String[] args) {

        System.exit(0);
    }
}
