package com.java.codegeek;

import javax.swing.*;

public class ChoosePlayer extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private final HotelGameMain parent;
    private int selPlayer = 1;
    public ChoosePlayer(HotelGameMain parent) {
        this.parent = parent;

        setContentPane(contentPane);
        setModal(true);

        getRootPane().setDefaultButton(buttonOK);


        buttonOK.addActionListener(e -> onOK());

        radioButton1.addChangeListener(e -> selPlayer = 1);
        radioButton2.addChangeListener(e -> selPlayer = 0);
    }

    private void onOK() {
        parent.gameController.setFirstPlayer(selPlayer);

        dispose();
    }


}
