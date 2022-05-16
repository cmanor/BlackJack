package org.example;
import java.util.Scanner;

 // logic n stuff specific to the player

public class Player extends Person {

    private double wallet;
    private double bet;
    Scanner scanner = new Scanner(System.in);


    //Create a new Player
    public Player() {
        super.setName("Player");
    }
    public void winBet(){
        setWallet(getWallet() + getBet());
    }
    public void loseBet(){
        setWallet(getWallet()-getBet());
    }

    //prints how much money the player has
    public void printWallet(){
        System.out.println("You have $"+ this.getWallet() +  " in your wallet.");
    }

    public void hitOrStand(Deck deck, Deck discard) {

        //decision holds their numerical choice
        int  decision = 0;
        //getNum means we're in the process of getting a number (int) from input stream
        boolean getNum = true;

        //while we are getting a number
        while(getNum){
            //try to get that number
            try{
                System.out.println("Press 1 to HIT or any other number to STAND.");
                decision = scanner.nextInt();
                getNum = false;

            }
            //catch any exceptions and try again
            catch(Exception e){
                System.out.println("ERROR! ERROR!");
                scanner.next();
            }
        }

        //if they decide to hit
        if (decision == 1) {
            this.hit(deck, discard);
            //return if they have blackjack or busted
            if(this.getHand().calculatedValue()>20){
                return;
            }
            else{
                //let them choose again
                this.hitOrStand(deck, discard);
            }

        } else {
            //they stand if enter anything other than 1
            System.out.println("You stand.");
        }


    }

    public void takeBet(){
        System.out.print("How much would you like to bet?"+ "\n" + "$");
        double potentialBet = scanner.nextDouble();
        while(true) {
            if (potentialBet > 0 && potentialBet <= this.wallet) {
                setBet(potentialBet);
                return;
            } else {
                System.out.println("Haha. Place a REAL bet.");
                printWallet();
                System.out.print("How much would you like to bet?" + "\n" + "$");
                potentialBet = scanner.nextDouble();
            }
        }
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public double getBet() {
        return bet;
    }

    public void setBet(double bet) {
        this.bet = bet;
    }
}