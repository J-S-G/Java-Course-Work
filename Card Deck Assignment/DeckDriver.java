package com.mycompany.deckassignment;
/**
 * Desc:   This class represents the output of 2 inherited classes: 
 * Card and Deck
 * @author jg
 */
public class DeckDriver 
{
    public static void main(String[] args) 
    {
        // A new deck object is created that can store data
        Deck deck = new Deck();
        
        // these are the tracking variables 
        int testCases = 0;
        int inBetween = 0;
        int notInBetween = 0;
        int matchesCard = 0;
        
        // Index n will increment by 1 for each iteration 
        int n = 0;
        
        // the Card objects are empty before the program runs
        // After the program runs each card is instantiated with a 
        // integer value
        Card c1 = null, c2 = null, c3 = null;
        // The while loop executes 3 times allowing for 3 Card objects to 
        // reference an integer value from the deck
        while(n < 3)
        {
            testCases++;
            // Shuffle Cards method is called where a random integer value 
            // will be returned
            // Each Card object is compared to the next for consistent 
            // Card references
            deck.shuffleCards();
            
            // Each condition is using the hasNext method which checks to make 
            // sure there are more cards in the deck and preventing 
            // reiterating cards
            if(deck.hasNext())
            {
                c1 = deck.next();
            }
            if(deck.hasNext())
            {
                c2 = deck.next();
            }
            if(c1.equals(c2))
            {
                c3=c2;
            }
            if(deck.hasNext())
            {
                c3 = deck.next();
            }
            // These conditions are making sure that the 
            // third card is in between the first two cards,
            // not in between, or matches one of the first two cards.
            if((c3.compareTo(c1) < 0 && c3.compareTo(c2) > 0 ))
            {
                inBetween++;
            }
            if((c3.compareTo(c1)>0 && c3.compareTo(c2)<0))
            {
                notInBetween++;
            }
            if((c3.compareTo(c1)== 0 || c3.compareTo(c2) == 0))
            {
                matchesCard++;
            }
            // Prints the results of each test case, 
            // including the cards involved in each test.
            System.out.println("\nTest Case #: "+testCases);
            System.out.println("\nCard1: \n"+c1.displayCard()+""
                    + "\nCard2: \n"+c2.displayCard()+"\nCard3: \n"
                    +c3.displayCard());
            n++;
        }
        
        // Outputs the incremented test variables that were incremented while 
        // the algorithm iterated
        System.out.println("Number of comparisons: " + testCases);
        System.out.println("number inBetween: " + inBetween);
        System.out.println("number notInBetween: " + notInBetween);
        System.out.println("number matchesCard: " + matchesCard);
    }
}