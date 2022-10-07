import java.util.ArrayList;
import fivepokergame.Card;
import fivepokergame.Deck;
import fivepokergame.Hand;


/**
 * Makes use of the other classes to simulate the five poker card game
 *@author Maimouna Diallo
 * 
 */
public class run {
	//declaring variables
	private static ArrayList<Card> cardDeck;
	private static Deck deck;
	private static Card[] cardHand;
	private static Hand hand;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//strings for output
				String print="";
				String strLoad="Shuffling ... Shuffling ... Shuffling ..";
				String strOut1="Your Hand: ";
				String strOut2="You Have: ";
				
		//creation of deck and hand		
				deck= new Deck();
				hand = new Hand();
				cardDeck= new ArrayList<Card>();
				cardHand= new Card[5];
				cardDeck= deck.createDeck();
				cardHand = deck.DealHand(5);
				
		//Display the correct card information		
				for(int i=0; i < 5; i++)
				{
					print+= ConvertDeck(cardHand[i].getNum())+printSign(cardHand[i].getSign())+ ", ";
				}
				
		//display output 		
				System.out.println(strLoad);
				System.out.println(strOut1+ print);
				System.out.println(strOut2+ hand.BestHand(cardHand, 5));

	}
	
	/**
	*
	* Displays the correct card information
	* int correctNum- card number
	* 
	*/	
	private static String ConvertDeck(int correctNum)
	{
		String card;
		if(correctNum==1)
		{
			card="A";
		}else if(correctNum==2)
		{
			card="K";
			
		}else if(correctNum==3)
		{
			card="Q";
		}else if(correctNum==4)
		{
			card="J";
		}else 
		{
			int num=correctNum-3;
			card= Integer.toString(num);
		}
		return card;
		
	}
	

	/**
	*
	* Displays the sign of the card
	* int sign- card sign
	* 
	*/	
	private static String printSign(int sign)
    {
    	String str =""; 
    	if(sign==1)
    	{
    		str= " of hearts";
    		
    	}else if(sign==2)
    	{
    		str= " of diamonds";
    	}else if(sign==3)
    	{
    		str= " of clubs";
    		
    	}else if(sign==4)
    	{
    		str= " of spades";
    	}
    	return str;
    }

}
