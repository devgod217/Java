package com.java.codegeek;



import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class HotelGameController {

    public Player[] players;
    private HotelGameMain mainViewUI;
    private HotelGameCLI mainViewCLI;
    public Place[] places;
    public int curDicePlayer = -1;
    public int curDiceValue = 0;
    public int[] curPlayerPlaceIndex;
    public String[] hotelName;
    public final int placeCount = 40;

    private final int runMode;

    static final int RUN_MODE_UI = 1;
    static final int RUN_MODE_CLI = 2;

    public HotelGameController(int runMode){
        this.runMode = runMode;
    }

    public void startGame(){

        switch (runMode){
            case RUN_MODE_UI -> initGameViewUI();
            case RUN_MODE_CLI -> initGameViewCLI();
        }

        selectFirstPlayer();
    }
    public void initGameViewCLI(){
        mainViewCLI = new HotelGameCLI();
        
        updateGameView();

    }
    public void initGameViewUI(){
        mainViewUI = new HotelGameMain();
        mainViewUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainViewUI.setSize(1800, 950);

        mainViewUI.setVisible(true);
        mainViewUI.pack();
        mainViewUI.setTitle("HotelGame");
        mainViewUI.initGameViewUI(this);

        updateGameView();

    }

    public void resetGameView(){
        mainViewUI.faces_p1 = new JLabel[placeCount];
        mainViewUI.faces_p2 = new JLabel[placeCount];
        mainViewUI.hotel_panels = new JPanel[placeCount];
        mainViewUI.hotel_stars = new JLabel[placeCount];


        for(int i=0;i<placeCount;i++){
            
            if(!hotelName[i].equals("")){
                mainViewUI.hotel_panels[i] = HotelGameMain.getComponentByName(mainViewUI,"p_" + hotelName[i].toLowerCase());
                mainViewUI.hotel_panels[i].setBackground(Color.WHITE);
                
            }

        }
        mainViewUI.player_moneys = new JLabel[players.length];
        mainViewUI.dices = new JLabel[players.length];

        for(int i=0;i<players.length;i++){
            mainViewUI.player_moneys[i] = HotelGameMain.getComponentByName(mainViewUI,"lbl_money_" + players[i].getName());
            mainViewUI.player_moneys[i].setText("£" + players[i].getBalance());
            mainViewUI.dices[i] = HotelGameMain.getComponentByName(mainViewUI,"lbl_dice_" + players[i].getName());
            mainViewUI.dices[i].setVisible(curDicePlayer == i);
        }

        updateGameView();
    }


    public void updateGameView(){
        switch (runMode){
            case RUN_MODE_UI -> {
                mainViewUI.updateGameView();
            }
            case RUN_MODE_CLI -> {
                mainViewCLI.showPlayersInfo(players, curDicePlayer, curPlayerPlaceIndex, hotelName);
                mainViewCLI.showHotelInfo(places,  hotelName);
            }
        }

    }

    public void initPlayers(){
        players = new Player[2];
        
        curPlayerPlaceIndex = new int[players.length];
    }

    public void initPlaces(){
        
        for(int i=0;i<placeCount;i++){
            switch (i % 5) {
                case 0, 2 -> places[i] = new Place(i, 0);
                case 1, 3 -> places[i] = new Hotel(hotelName[i], i, 50, Place.NONE, 0, Place.NONE);
                case 4 -> {
                    initPlacePrice += 20;
                    places[i] = new Hotel(hotelName[i], i, initPlacePrice, Place.NONE, 0, Place.NONE);
                    initPlacePrice += 30;
                }
            }

        }
        places[0].curLandPlayer = Place.BOTH;

    }

    public void selectFirstPlayer(){
        switch (runMode){
            case RUN_MODE_UI -> mainViewUI.showChoosePlayer();
            case RUN_MODE_CLI -> mainViewCLI.showSelectFirstPlayer();
        }

    }


    public void setBuyHotel(int index, int playerNo){
        
        updateGameView();
    }

    public void setUpgradeStar(int index, int playerNo){
        
        places[index] = hotel;
        players[playerNo-1].setBalance(players[playerNo-1].getBalance() - hotel.getPrice()/2);
        updateGameView();
    }
    public void setFirstPlayer(int playerNo){
        curDicePlayer = playerNo;

        if(runMode == RUN_MODE_CLI){
            mainViewCLI.showMessage("-----Start game with the first player, P" + (curDicePlayer+1) + ".-----");
            updateGameView();
            doDicing(0);
        }
        else{
            if(curDicePlayer == 0){
                mainViewUI.btn_d2.setEnabled(true);
                mainViewUI.btn_d1.setEnabled(false);
            }
            else{
                mainViewUI.btn_d1.setEnabled(true);
                mainViewUI.btn_d2.setEnabled(false);
            }
            updateGameView();
        }
    }


    public void checkLandingHotel(int placeIndex){
        if(!hotelName[placeIndex].equals("")){
            Hotel hotel = (Hotel)places[placeIndex];

            if(hotel.getOwner() == 0 && players[curDicePlayer].getBalance() >= hotel.getPrice()){
                switch (runMode){
                    case RUN_MODE_UI -> mainViewUI.showBuyHotel(hotel, players[curDicePlayer]);
                    case RUN_MODE_CLI -> mainViewCLI.showBuyHotel(hotel, players[curDicePlayer]);
                }

            }
            if(hotel.getOwner() == (curDicePlayer+1) && players[curDicePlayer].getBalance() >= hotel.getPrice()/2){
                switch (runMode){
                    case RUN_MODE_UI -> mainViewUI.showUpgradeStar(hotel, players[curDicePlayer]);
                    case RUN_MODE_CLI -> mainViewCLI.showUpgradeStar(hotel, players[curDicePlayer]);
                }

            }
            else if(hotel.getOwner() > 0 && hotel.getOwner() != (curDicePlayer+1) && hotel.getStar() > 0){
                checkOvernightFee(hotel,players[curDicePlayer]);
            }

        }
    }

    public void checkOvernightFee(Hotel hotel, Player player){
        float feePrice = hotel.getPrice()/10.0f*hotel.getStar()*hotel.getStar();
        int hotelGroupNo = hotel.index/5;
        int gCount = 0;
        for(int i=hotelGroupNo*5;i<(hotelGroupNo+1)*5;i++){
            if(!hotelName[i].equals("")){
               
                if(gHotel.getOwner() == curDicePlayer+1){
                    feePrice/=2;
                    break;
                }
                else if(gHotel.getOwner() > 0 && gHotel.getOwner() != curDicePlayer+1){
                    gCount++;
                }
            }
        }
        if(gCount == 3){
            feePrice*=2;
        }
        

    }
    public void doDicing(int number){
        if(number == 0){
            switch (runMode){
                case RUN_MODE_UI -> curDiceValue = new Random().nextInt(12) + 1;
                case RUN_MODE_CLI -> curDiceValue = mainViewCLI.dice(curDicePlayer);
            }
        }
        else{
            curDiceValue = number;
        }

        
        updateGameView();
        checkLandingHotel(curPlayerPlaceIndex[curDicePlayer]);

        curDicePlayer = (curDicePlayer + 1) % players.length;



        updateGameView();


    }

    public void restartGame(){
        initPlaces();
        initPlayers();
        if(runMode == RUN_MODE_UI){
            resetGameView();
        }

        selectFirstPlayer();
    }
}
