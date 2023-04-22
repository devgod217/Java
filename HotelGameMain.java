package com.java.codegeek;
import java.awt.*;
import java.lang.reflect.Field;
import java.util.Scanner;
import javax.swing.*;

public class HotelGameMain extends JFrame{
    
    private JLabel j_6;
    private JLabel t_6;
    private JLabel j_23;
    private JLabel j_19;
    private JLabel t_19;
    private JLabel h_e1;
    private JLabel h_d2;
    private JLabel h_d1;
    private JLabel h_c3;
    private JLabel h_c2;
    private JLabel h_c1;
    private JLabel h_b3;
    private JLabel h_b2;
    private JLabel h_a3;
    private JLabel h_a2;
    private JLabel h_a1;
    private JLabel h_h3;
    private JLabel h_h2;
    private JLabel h_h1;
    private JLabel h_g3;
    private JLabel h_f3;
    private JLabel h_f2;
    private JLabel h_f1;
    private JLabel h_e3;
    private JLabel t_18;
    private JLabel t_16;
    private JLabel t_14;
    private JLabel t_13;
    private JLabel t_11;
    private JLabel t_9;
    private JLabel t_8;
    private JLabel t_4;
    private JLabel t_3;
    private JLabel t_1;
    private JLabel t_39;
    private JLabel t_38;
    private JLabel t_36;
    private JLabel t_34;
    private JLabel t_31;
    private JLabel t_29;
    private JLabel t_28;
    private JLabel t_26;
    private JLabel t_24;
    private JLabel t_23;
    private JLabel t_21;
    private JLabel j_18;
    private JLabel j_16;
    private JLabel j_14;
    private JLabel j_13;
    private JLabel j_11;
    private JLabel j_9;
    private JLabel j_8;
    private JLabel j_4;
    private JLabel j_3;
    private JLabel j_1;
    private JLabel j_39;
    private JLabel j_38;
    private JLabel j_36;
    private JLabel j_34;
    private JLabel j_31;
    private JLabel j_29;
    private JLabel j_28;
    private JLabel j_26;
    private JLabel j_24;
    private JLabel j_21;
    private JLabel j_2;
    private JLabel j_5;
    private JLabel j_7;
    private JLabel j_10;
    private JLabel j_12;
    private JLabel j_15;
    private JLabel j_17;
    private JLabel j_20;
    private JLabel j_22;
    private JLabel j_25;
    private JLabel j_27;
    private JLabel t_2;
    private JLabel t_5;
    private JLabel t_7;
    private JLabel t_10;
    private JLabel t_12;
    private JLabel t_15;
    private JLabel t_17;
    private JLabel t_20;
    private JLabel t_22;
    private JLabel t_25;
    private JLabel t_27;
    private JLabel s_a1;
    private JLabel s_a2;
    private JLabel s_a3;
    private JLabel s_b1;
    private JLabel s_b2;
    private JLabel s_b3;
    private JLabel s_c1;
    private JLabel s_c2;
    private JLabel s_c3;
    private JLabel s_d1;
    private JLabel s_d2;
    private JLabel s_d3;
    private JLabel s_e1;
    private JLabel s_e2;
    private JLabel s_e3;
    private JLabel s_f1;
    private JLabel s_f2;
    private JLabel s_f3;
    private JLabel s_g1;
    private JLabel s_g3;
    private JLabel s_h1;
    private JLabel s_h2;
    private JLabel s_h3;
    private JLabel j_0;
    private JLabel t_0;
    private JLabel t_37;
    private JLabel j_37;
    private JLabel j_30;
    private JLabel t_30;
    private JLabel t_35;
    private JLabel j_35;
    private JLabel lbl_money_t;
    private JButton btn_dice;
    private JPanel p_d3;
    private JPanel p_d2;
    private JPanel p_d1;
    private JPanel p_c3;
    private JPanel p_c2;
    private JPanel p_c1;
    private JPanel p_b3;
    private JPanel p_b2;
    private JPanel p_b1;
    private JPanel p_a3;
    private JPanel p_a2;
    private JPanel p_a1;
    private JPanel p_h3;
    private JPanel p_h2;
    private JPanel p_h1;
    private JPanel p_g3;
    private JPanel p_g1;
    private JPanel p_f3;
    private JPanel p_f2;
    private JPanel p_f1;
    private JPanel p_e3;
    private JPanel p_e2;
    private JPanel p_e1;
    private JPanel p_g2;
    private JLabel h_g2;
    private JLabel j_33;
    private JLabel t_33;
    private JLabel s_g2;
    private JLabel t_32;
    private JLabel j_32;
    public JSpinner spinner1;
    public JButton btn_d1;
    public JButton btn_d2;
    public JSpinner spinner2;

    public JLabel[] faces_p1;
    public JLabel[] faces_p2;
    public JPanel[] hotel_panels;
    public JLabel[] hotel_stars;
    public JLabel[] player_moneys;

    public JLabel[] dices;

    public ChoosePlayer choosePlayer;
    public ManageHotel buyHotel;
    public ShowMessage showMessage;

    public HotelGameController gameController;

    public HotelGameMain(){
        setLayout(new GridLayout());
        setSize(1800,900);
        add(main_panel);
        SpinnerModel sm1 = new SpinnerNumberModel(1, 1, 12, 1);
        SpinnerModel sm2 = new SpinnerNumberModel(1, 1, 12, 1);
        spinner1.setModel(sm1);
        spinner2.setModel(sm2);
        btn_dice.addActionListener(e -> gameController.doDicing(0));
        btn_d1.addActionListener(e -> gameController.doDicing((int)spinner1.getValue()));

        btn_d2.addActionListener(e -> gameController.doDicing((int)spinner2.getValue()));
    }
    public void showChoosePlayer(){
        choosePlayer = new ChoosePlayer(this);
        choosePlayer.pack();
        choosePlayer.setTitle("Choose Player");
        choosePlayer.setLocation((this.getX() + (this.getWidth() - choosePlayer.getWidth())/2),(this.getY() + this.getHeight()/2));
        choosePlayer.setVisible(true);
    }

    public void showBuyHotel(Hotel hotel, Player player){
        buyHotel = new ManageHotel(this,hotel,player,ManageHotel.MODE_BUY_HOTEL);
        buyHotel.pack();
        buyHotel.setTitle("Buy Hotel");
        buyHotel.setLocation((this.getX() + (this.getWidth() - buyHotel.getWidth())/2),(this.getY() + this.getHeight()/2));
        buyHotel.setVisible(true);
    }

    public void showMessage(int from, Hotel hotel, Player player, float fee, int mode){
        showMessage = new ShowMessage(this,from,hotel,player,fee,mode);
        showMessage.pack();
        showMessage.setTitle("Message");
        showMessage.setLocation((this.getX() + (this.getWidth() - showMessage.getWidth())/2),(this.getY() + this.getHeight()/2 ));
        showMessage.setVisible(true);
    }

    public void showUpgradeStar(Hotel hotel, Player player){
        buyHotel = new ManageHotel(this,hotel,player,ManageHotel.MODE_UPGRADE_STAR);
        buyHotel.pack();
        buyHotel.setTitle("Upgrade Star");
        buyHotel.setLocation((this.getX() + (this.getWidth() - buyHotel.getWidth())/2),(this.getY() + this.getHeight()/2));
        buyHotel.setVisible(true);
    }

    public void initGameViewUI(HotelGameController gameController){

        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        setLocation(dx, dy);
        invalidate();
        this.gameController = gameController;
        faces_p1 = new JLabel[gameController.placeCount];
        faces_p2 = new JLabel[gameController.placeCount];
        hotel_panels = new JPanel[gameController.placeCount];
        hotel_stars = new JLabel[gameController.placeCount];


        for(int i=0;i<gameController.placeCount;i++){
            faces_p1[i] = HotelGameMain.getComponentByName(this,"t_" + i);
            faces_p2[i] = HotelGameMain.getComponentByName(this,"j_" + i);
            if(!gameController.hotelName[i].equals("")){
                hotel_panels[i] = HotelGameMain.getComponentByName(this,"p_" + gameController.hotelName[i].toLowerCase());
                hotel_panels[i].setBackground(Color.WHITE);
                hotel_panels[i].setBorder(BorderFactory.createLineBorder(Color.black));
                hotel_stars[i] = HotelGameMain.getComponentByName(this,"s_" + gameController.hotelName[i].toLowerCase());
                hotel_stars[i].setBackground(Color.WHITE);
            }

        }
        player_moneys = new JLabel[gameController.players.length];
        dices = new JLabel[gameController.players.length];

        for(int i=0;i<gameController.players.length;i++){
            player_moneys[i] = HotelGameMain.getComponentByName(this,"lbl_money_" + gameController.players[i].getName());
            player_moneys[i].setText("£" + gameController.players[i].getBalance());
            dices[i] = HotelGameMain.getComponentByName(this,"lbl_dice_" + gameController.players[i].getName());
            dices[i].setVisible(gameController.curDicePlayer == i);
        }



    }

    public void updateGameView(){

        for(int i=0;i<gameController.placeCount;i++){
            faces_p1[i].setVisible(gameController.places[i].curLandPlayer == Place.P1 || gameController.places[i].curLandPlayer == Place.BOTH);
            faces_p2[i].setVisible(gameController.places[i].curLandPlayer == Place.P2 || gameController.places[i].curLandPlayer == Place.BOTH);
            if(!gameController.hotelName[i].equals("")){
                Hotel hotel = (Hotel) gameController.places[i];
                if(hotel.getOwner() == Place.P2){

                    hotel_panels[i].setBackground(Color.MAGENTA);
                }
                else if(hotel.getOwner() == Place.P1){

                    hotel_panels[i].setBackground(Color.cyan);
                }


                hotel_stars[i].setText("★"+hotel.getStar());

                hotel_stars[i].setForeground(Color.BLACK);

            }
        }

        for(int i=0;i<gameController.players.length;i++){

            player_moneys[i].setText("£" + gameController.players[i].getBalance());

            dices[i].setVisible(gameController.curDicePlayer == i);
        }
        lbl_dice_result.setText("" + gameController.curDiceValue);

        if(gameController.curDicePlayer == 0){
            btn_d2.setEnabled(true);
            btn_d1.setEnabled(false);
        }
        else{
            btn_d1.setEnabled(true);
            btn_d2.setEnabled(false);
        }
        validate();


    }


    /**
     * attempts to retrieve a component from a JFrame or JDialog using the name
     * of the private variable that NetBeans (or other IDE) created to refer to
     * it in code.
     * @param <T> Generics allow easier casting from the calling side.
     * @param window JFrame or JDialog containing component
     * @param name name of the private field variable, case-sensitive
     * @return null if no match, otherwise a component.
     */
    @SuppressWarnings("unchecked")
    static public <T extends Component> T getComponentByName(Window window, String name) {

        // loop through all the class fields on that form
        for (Field field : window.getClass().getDeclaredFields()) {

            try {
                // let us look at private fields, please
                field.setAccessible(true);

                // compare the variable name to the name passed in
                if (name.equals(field.getName())) {

                    // get a potential match (assuming correct &lt;T&gt;ype)
                    final Object potentialMatch = field.get(window);

                    // cast and return the component
                    return (T) potentialMatch;
                }

            } catch (SecurityException | IllegalArgumentException
                    | IllegalAccessException ex) {

                // ignore exceptions
            }

        }

        // no match found
        return null;
    }

    public static void main(String[] args) {

        HotelGameController hotelGameController = new HotelGameController(HotelGameController.RUN_MODE_UI);
        hotelGameController.startGame();


    }




}
