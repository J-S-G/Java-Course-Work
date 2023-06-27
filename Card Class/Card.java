package cardtester;

public class Card implements Comparable<Card> 
{
    /**
    * The different face values of a deck of cards
    */
    public enum Face 
    {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
    }

    /**
    *  The different types of suit a deck of cards can have
    */
    public enum Suit 
    {
        CLUBS, DIAMONDS, HEARTS, SPADES;
    }
    
    // attributes
    private Face face;
    private Suit suit;

    /**
     * constructor
     *
     * @param face
     * @param suit
     */
    public Card(Face face, Suit suit) {
        this.face = face;
        this.suit = suit;
    }

    /**
     * @return the face
     */
    public Face getFace() {
        return face;
    }

    /**
     * @return the suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * @param face the face to set
     */
    public void setFace(Face face) {
        this.face = face;
    }

    /**
     * @param suit the suit to set
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Card other = (Card) obj;
        return face == other.face && suit == other.suit;
    }

    /**
     * @return string representation of Card
     */
    @Override
    public String toString() {
        return face + " of " + suit;
    }

    @Override
    public int compareTo(Card o) {
        // compare the suit first
        int suitCompare = this.suit.compareTo(o.suit);

        // if the suits are the same, compare the faces
        if (suitCompare == 0) {
            return this.face.compareTo(o.face);
        } 
        // if the suits are different, return the suit comparison result
        else {
            return suitCompare;
        }
    }
}
