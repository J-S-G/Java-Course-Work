package cardtester;

import cardtester.Card.Face;
import cardtester.Card.Suit;

/**
 *
 * @author jg
 */

/**
 * An Enumerated Type to represent the face.
 */
public class CardTester 
{   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
 		//  declare an instance of your card, called aCard
		Card aCard = new Card(Face.ACE, Suit.CLUBS);
		
		// iterate till the suits
		for(Suit suit : Suit.values()) 
                {
			aCard.setSuit(suit);
			// iterate till the face
			for(Face face:Face.values()) 
                        {
				aCard.setFace(face);
				System.out.println(aCard.toString());
			}
		}

		// test equals method
		System.out.println("\nTESTING EQUALS METHOD");
		Card aCard2 = new Card(Face.ACE, Suit.DIAMONDS);
		System.out.println("Two cards are equals? : "+aCard.equals(aCard));
		System.out.println("Two cards are equal? : "+aCard.equals(aCard2));
		
		// test compare to
		System.out.println("\nTESTING COMPARE TO METHOD");
		if(aCard.compareTo(aCard2) == 0) {
			System.out.println("Both are same.");
		}
                
                else if(aCard.compareTo(aCard2) > 0) 
                {
			System.out.println("Card 1 is greater than Card2");
		}
                
                else 
                {
			System.out.println("Card 2 is greater than Card1");
		}
	}
}

/*
Output: 

run:
ACE of CLUBS
TWO of CLUBS
THREE of CLUBS
FOUR of CLUBS
FIVE of CLUBS
SIX of CLUBS
SEVEN of CLUBS
EIGHT of CLUBS
NINE of CLUBS
TEN of CLUBS
JACK of CLUBS
QUEEN of CLUBS
KING of CLUBS
ACE of DIAMONDS
TWO of DIAMONDS
THREE of DIAMONDS
FOUR of DIAMONDS
FIVE of DIAMONDS
SIX of DIAMONDS
SEVEN of DIAMONDS
EIGHT of DIAMONDS
NINE of DIAMONDS
TEN of DIAMONDS
JACK of DIAMONDS
QUEEN of DIAMONDS
KING of DIAMONDS
ACE of HEARTS
TWO of HEARTS
THREE of HEARTS
FOUR of HEARTS
FIVE of HEARTS
SIX of HEARTS
SEVEN of HEARTS
EIGHT of HEARTS
NINE of HEARTS
TEN of HEARTS
JACK of HEARTS
QUEEN of HEARTS
KING of HEARTS
ACE of SPADES
TWO of SPADES
THREE of SPADES
FOUR of SPADES
FIVE of SPADES
SIX of SPADES
SEVEN of SPADES
EIGHT of SPADES
NINE of SPADES
TEN of SPADES
JACK of SPADES
QUEEN of SPADES
KING of SPADES

TESTING EQUALS METHOD
Two cards are equals? : true
Two cards are equal? : false

TESTING COMPARE TO METHOD
Card 1 is greater than Card2
BUILD SUCCESSFUL (total time: 0 seconds)

*/