package org.example;

 // shared logic for player and dealer

public abstract class Person {

    //persons active cards
    private Hand hand;
    private String name;

     // Create a new Person
    public Person(){
        this.hand = new Hand();
        this.name = "";
    }

    public Hand getHand(){
        return this.hand;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public void printHand(){
        System.out.println(this.name + "'s hand looks like this:");
        System.out.println(this.hand + " Valued at: " + this.hand.calculatedValue());
    }

      //taking cards from the deck
    public void hit(Deck deck, Deck discard){

        //no cards left in deck
        if (!deck.hasCards())
            deck.reloadDeckFromDiscard(discard);

        //take a card from the deck
        this.hand.takeCardFromDeck(deck);
        System.out.println(this.name + " gets a card");
        this.printHand();

        Game.pause();
    }
     // Check if Person has 21
    public boolean hasBlackjack(){
        if(this.getHand().calculatedValue() == 21){
            return true;
        }
        else{
            return false;
        }
    }
}
