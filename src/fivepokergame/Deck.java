package fivepokergame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Creates a deck and deals a hand
 *@author Maimouna Diallo
 * 
 */
public class Deck {
	
	//declaring variables
	private ArrayList<Card> cardDeck;
    private Random random;   

    public Deck() 
    {
    	//initiliazing variables
        cardDeck = new ArrayList<Card>();
        random = new Random();
    }

    /**
	*Creates the deck of 52 cards
	*/
    public ArrayList<Card>  createDeck()
    {
    	//clear deck
    	cardDeck.clear();
    	
        for (int i = 1; i < 5; i++) //ensures the signs are distributed
        {
            for (int n = 1; n < 14; n++) 
            {
                Card newCard = new Card(i, n);
                cardDeck.add(newCard);
            }
        }
       return cardDeck;
    }
    
    /**
	*Shuffles Deck
	*/
    public void ShuffleDeck()
    {
    	 Collections.shuffle(cardDeck);
    }
    
    /**
	*Selects cards from the top of the deck
	*handSize- size of the hand dealt
	*/ 
    public Card[]  DealHand(int handSize)
    {
    	Card[] Hand= new Card[handSize];
    	ShuffleDeck();
    	
    	
    	for (int i = 0; i < handSize; i++) 
    	{
    		Card newCard = cardDeck.get(i);
    		Hand[i]=newCard;
        }
    	
    	return Hand;
    }
    
    

}
