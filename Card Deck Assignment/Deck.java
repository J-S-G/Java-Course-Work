package com.mycompany.deckassignment;

import java.util.*;
   /**
   * Desc: Deck Class implements the Card interface, 
   * which allows iteration over the cards in the deck.
   * @author jg
   */
    public class Deck implements Iterator<Card>
    {
    // An ArrayList to store the cards in the deck
    ArrayList<Card> cardDeck = null;

    // The number of remaining cards in the deck
    private int remainingCards;

    //Constructs a new Deck object, consisting of 52 cards.
    //The cards are added to the deck in the order Ace to King, and Clubs to Spades.
    //The remainingCards variable is initialized to 52.
    public Deck()
    {
    // Create a new ArrayList to store the cards in the deck
    cardDeck = new ArrayList<Card>();

    // The possible card values and suits
    String nums[] = {"Ace", "2", "3", "4","5","6","7","8","9",
    "10", "Jack", "Queen", "King"};
    String sName[] = {"Clubs", "Diamonds", "Hearts","Spades"};

    int counter = 0;
    // Loop through all the possible card combinations and add them to the deck
    for(int i=0; i<sName.length;i++)
    {
    for(int j=0;j<nums.length;j++)
    {
    Card c = new Card(nums[j], sName[i]);
    cardDeck.add(counter, c);
    counter++;
    }
    }
    // Set the remainingCards variable to 52
    this.remainingCards = counter;
    }

    /**
    * Returns the number of remaining cards in the deck.
    * @return The number of remaining cards in the deck
    */
    public int getRemainingCards()
    {
    return remainingCards;
    }

    /**
    * Shuffles the cards in the deck using the Collections.shuffle() method.
    */
    public void shuffleCards()
    {
    Collections.shuffle(this.cardDeck);
    }

    /**
    * Returns true if there are remaining cards in the deck, and false otherwise.
    @return true if there are remaining cards in the deck, and false otherwise
    */
    @Override
    public boolean hasNext()
    {
        return this.remainingCards > 0;
    }
    
    @Override // Indicates that this method overrides a method inherited from 
    // The super class or interface
    public Card next() // This method returns the next element in iteration 
    {
        // Retrieves card object at the index from the current object reference 
        Card c= this.cardDeck.get(this.remainingCards);
        
        // The cards are decremented by 1 ea. iteration 
        this.remainingCards--;
        
        // Finally the card object is returned which is then outputted in the 
        // DeckDriver Class
        return c;
    }
    
    @Override// Indicates that this method overrides a method inherited from 
    // The super class or interface
    public String toString()
    {
        // cards variable is instantaited with an empty string 
        String cards="";
        // The for loop iterates through the Card Deck and outputs the 
        // Card object followed by a newline  
        for(Card card: this.cardDeck)
        {
            // The card object is casted as a String variable
            cards += card.toString() + "\n";
        }
        // Finally the cards String variable is populated with Card objects 
        // and their corresponding data 
        return cards;
    }
    
}