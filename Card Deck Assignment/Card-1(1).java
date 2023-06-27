package com.mycompany.deckassignment;

/**
 * Desc:   This class represents a single playing card w/name and suit
 * @author jg
 */
    public class Card implements Comparable<Card> 
    {
    private String cardName;
    private String cardSuite;

    // Constructor that creates a new instance of the 
    // Card class with a specified name and suite.
    public Card(String name, String suite)
    {
        this.cardName = name;
        this.cardSuite = suite;
    }
    
    // Returns the name of the card as a String
    // Getter || Accessor 
    public String getCardName()
    {
        return cardName;
    }
    
    // Sets the name of card using the instance of the Card object
    // Setter || Mutator
    public void setCardName(String cardName) 
    {
        this.cardName = cardName;
    }
    
    // Returns the suit of the card
    // Getter || Accessor 
    public String getCardSuite() 
    {
        return cardSuite;
    }
    
    // Setter || Mutator
    public void setCardSuite(String cardSuite) 
    {
        this.cardSuite = cardSuite;
    }

    @Override
    // Returns a string of the card in a format "Suit of Name"
    public String toString() 
    {
        return this.cardSuite+" of "+this.cardName;
    }

    @Override
    // Equals method determines if a specific object is equal to this Card Obj
    public boolean equals(Object obj) 
    {
        // Two Card objects are considered equal to this Card Object
    if(this.cardName.equalsIgnoreCase(((Card)obj).cardName) &&
        this.cardSuite.equalsIgnoreCase(((Card)obj).cardSuite))
        {
            return true;
        }
    return false;
    }

    @Override
    // Compare To is a method that compares 2 card objects 
    // It overrides compareTo method in the Comparable interface
    public int compareTo(Card c) 
    {
        // An array of Card values which will be referenced later using 
        String nums[] = {"Ace", "2", "3", "4","5","6","7","8","9",
        "10", "Jack", "Queen", "King"};
        int thisIndex=-1, otherIndex=-1;
        // Loop through the array to find the index of the current card
        for(int i = 0; i < nums.length; i++)
        
        if(nums[i].equalsIgnoreCase(this.cardName))
        thisIndex = i;
        
        // Loop through the array to find the index of the other card
        for(int i=0;i < nums.length;i++)
        if(nums[i].equalsIgnoreCase(c.cardName))
        otherIndex = i;
        
        // Compare the two indexes to determine the order of the cards
        if(thisIndex < otherIndex) 
        {
            return -1;
        }
        else if(thisIndex > otherIndex) 
        {
            return 1;
        } 
        else 
        {
            return 0;
        }
    }

    /**
     * Builds a string representation of the card with the first letter of its name capitalized
     * and the Unicode symbol for its suit appended to it.
     *
     * @return a StringBuilder object containing the formatted card representation.
     */
    public StringBuilder displayCard() 
    {
        // A string array containing the names of the four suits in order.
        String sName[] = {"Spades", "Diamonds", "Hearts", "Clubs"};
        // A string array containing the Unicode symbols for each of 
        // the four suits.
        // Source: 
        // https://www.webnots.com/alt-code-shortcuts-for-playing-cards-suit/
        String code[] ={"♠", "♦", "♥", "♣"};
        int thisIdx = -1;
        // Determine the index of the current card's suit in the sName array.
        for(int i = 0; i < sName.length; i++) {
            if(sName[i].toLowerCase().equalsIgnoreCase
        (this.cardSuite.toLowerCase())) 
            {
                thisIdx = i;
            }
        }
        // Create a StringBuilder object and append the first 
        // letter of the card's name
        // capitalized and the Unicode symbol for its suit.
        StringBuilder sb = new StringBuilder();
        sb.append(this.cardName.substring(0, 1).toUpperCase() 
                + code[thisIdx]);
        return sb;
    }

}