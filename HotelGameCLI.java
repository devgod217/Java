package com.java.codegeek;


import java.util.Random;
import java.util.Scanner;

public class HotelGameCLI {



    public String cmd;
    public HotelGameController gameController;
    public void showPlayersInfo(Player[] players, int curDiceOwner, int[] curPlayerLocation, String[] hotelNames){
        System.out.println("-----Player Info-----");
        System.out.println("Name" + "\t" + "Balance" + "\t" + "IsDiceOwner" +"\t" + "Location");
        for(int i=0;i<players.length;i++){
            String isDiceOwner = curDiceOwner == players[i].getNo() ? "Yes" : "No";
            String location = hotelNames[curPlayerLocation[i]].equals("") ? "No Hotel" : hotelNames[curPlayerLocation[i]];


            System.out.println("P" + (players[i].getNo()+1) + "\t" + players[i].getBalance() + "\t" + isDiceOwner + "\t" + curPlayerLocation[i] + ":" + location);
        }
    }

    public void showHotelInfo(Place[] places, String[] hotelNames){
        System.out.println("-----Hotel Info-----");
        System.out.println("Name" + "\t" + "Price" + "\t" + "Star" + "\t"+ "Owner" + "\t" + "Landing" + "\t" + "Name" + "\t" + "Price" + "\t" + "Star" + "\t"+ "Owner" + "\t" + "Landing" + "\t" + "Name" + "\t" + "Price" + "\t" + "Star" + "\t"+ "Owner" + "\t" + "Landing");
        int count = 0;
        for(int i=0;i<places.length;i++){
            if(!hotelNames[i].equals("")){
                count++;
                Hotel hotel = (Hotel) places[i];
                String owner = hotel.getOwner() == Place.NONE ? "No" : "P" + hotel.getOwner();
                String landingPlayer = hotel.curLandPlayer == Place.NONE ? "No" : hotel.curLandPlayer == Place.P1 ? "P1" : hotel.curLandPlayer == Place.P2 ? "P2" : "P1 P2" ;

                System.out.print( hotel.getName()+" (" +i +")" + "\t" + hotel.getPrice() + "\t" + hotel.getStar() + "\t\t" + owner + "\t\t" + landingPlayer + "\t\t" );
                if(count%3==0){
                    System.out.println();
                }
            }

        }
    }
    public void showMessage(String message){
        System.out.println(message);
    }
    public void showSelectFirstPlayer(){
        while(true){
            System.out.println("-----Choose the first player-----");
            System.out.print("Input the first player number(1 or 2). ");
            Scanner input = new Scanner(System.in);
            String no = input.nextLine();

            if(no.equals("1") || no.equals("2")){

                gameController.setFirstPlayer(Integer.parseInt(no)-1);
                break;
            }
            System.out.println("Error : Invalid player number. number must be 1 or 2.");

        }


    }

    public void showUpgradeStar(Hotel hotel, Player player){

        System.out.println("-----Upgrade Star of " + hotel.getName() + " by Player P" + (player.getNo()+1) + "-----");
        System.out.print("Check hotel info (After balance : " + (player.getBalance() - hotel.getPrice()/2) + ") and input Y/N(default is Y) : ");
        Scanner input = new Scanner(System.in);
        String yn = input.nextLine();
        if(yn.equals("") || yn.equalsIgnoreCase("y")){
            gameController.setUpgradeStar(hotel.index, player.getNo() + 1);
        }
    }
    public void showBuyHotel(Hotel hotel, Player player){
        System.out.println("-----Buy Hotel " + hotel.getName() + " by Player P" + (player.getNo()+1) + "-----");
        System.out.print("Check hotel info (After balance : " + (player.getBalance() - hotel.getPrice()) + ") and input Y/N(default is Y) : ");
        Scanner input = new Scanner(System.in);
        String yn = input.nextLine();

        if(yn.equals("") || yn.equalsIgnoreCase("y")){
            gameController.setBuyHotel(hotel.index, player.getNo() + 1);
        }

    }
    public int dice(int playerNo){

        while (true){
            System.out.print("Player P" + (playerNo+1) + " is dicing... (Input a number[1-12]. None is random) : ");
            Scanner input = new Scanner(System.in);
            String no = input.nextLine();
            int diceNo;
            if(no.equals("")){
                diceNo = new Random().nextInt(12) + 1;
                System.out.println("Player P" + (playerNo+1) + "'s diced number : " + diceNo);
                return diceNo;
            }
            else{
                try {
                    diceNo = Integer.parseInt(no);
                    assert !no.equals("1") && !no.equals("2") : "Invalid player number. number must be 1 or 2.";
                    if(diceNo > 0 && diceNo < 13){
                        return diceNo;
                    }
                    else {
                        System.out.println("Error : Invalid number. number must be 1-12.");
                    }
                }catch (NumberFormatException e){

                    System.out.println("Error : Invalid number. number must be 1-12.");

                }
            }
        }
    }

    public static void main(String[] args) {

        HotelGameController hotelGameController = new HotelGameController(HotelGameController.RUN_MODE_CLI);

        hotelGameController.startGame();

        while (true) {
            hotelGameController.doDicing(0);
        }
    }


}
