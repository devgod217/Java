package com.java.codegeek;

import javax.swing.*;
import java.awt.event.*;

public class ManageHotel extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel lbl_title;
    private JLabel lbl_price;
    private JLabel l_hn;
    private JLabel l_hp;
    private JLabel l_hs;
    private JLabel l_cb;
    private JLabel l_ab;

    static final int MODE_BUY_HOTEL = 1;
    static final int MODE_UPGRADE_STAR = 2;

    private final int mode;
    private final HotelGameMain hotelGameMain;
    private final Hotel hotel;
    private final Player player;
    public ManageHotel(HotelGameMain hotelGameMain, Hotel hotel, Player player, int mode) {
        this.mode = mode;
        this.hotelGameMain = hotelGameMain;
        this.hotel = hotel;
        this.player = player;

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        l_hn.setText(hotel.getName());
        l_hs.setText("★" + hotel.getStar());
        l_cb.setText("£" + player.getBalance());

        switch (mode) {
            case MODE_BUY_HOTEL -> {
                lbl_title.setText("Buy Hotel");
                lbl_price.setText("Hotel Price");
                l_hp.setText("£" + hotel.getPrice());
                l_ab.setText("£" + (player.getBalance() - hotel.getPrice()));
            }
            case MODE_UPGRADE_STAR -> {
                lbl_title.setText("Upgrade Star");
                lbl_price.setText("Upgrade Price");
                l_hp.setText("£" + hotel.getPrice() / 2);
                l_ab.setText("£" + (player.getBalance() - hotel.getPrice() / 2));
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
            case MODE_BUY_HOTEL -> hotelGameMain.gameController.setBuyHotel(hotel.index, player.getNo() + 1);
            case MODE_UPGRADE_STAR -> hotelGameMain.gameController.setUpgradeStar(hotel.index, player.getNo() + 1);
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


}
