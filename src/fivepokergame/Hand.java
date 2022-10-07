package fivepokergame;
/**
 * Evaluates the users hand to determine the poker hand
 *class that used @author Marc is code as a template 
 *link to original:https://bit.ly/3egjtNa
 * 
 */
public class Hand {

    private void sortHand(Card[] hand, int handSize) {
        //Requires: hand!=null && and hand.lenght==handSize
        //Modifies: hand
        //Effects: Sorts hand in ascending order based on hand[i].num.
        
        Card temp;
        for (int i = 0; i < handSize; i++) {
            temp = hand[i];
			int next = temp.getNum();
            int j = i;
            while (j > 0 && hand[j - 1].getNum() > next) {
            	hand[j] = hand[j - 1];
                j--;
            }
            hand[j] = temp;
        }
    }

    public String BestHand(Card[] hand, int handSize) {
        //Requires: hand!=null and hand.lenght==handSize
        //and hand to be sorted in ascending order based on hand[i].num
        //Effects: Finds the best poker hand in hand,
        //and returns an integer value that corresponds to that poker hand
        int BH, temp;
        BH = highCard(hand, handSize);
        temp = onepair(hand, handSize);
        if (temp > BH) {
            BH = temp;
        }
        temp = twoPair(hand, handSize);
        if (temp > BH) {
            BH = temp;
        }
        temp = threeOfKind(hand, handSize);
        if (temp > BH) {
            BH = temp;
        }
        temp = straight(hand,handSize);
        if (temp > BH) {
            BH = temp;
        }
        temp = flush(hand, handSize);
        if (temp > BH) {
            BH = temp;
        }
        temp = FourOfKind(hand, handSize);
        if (temp > BH) {
            BH = temp;
        }
        temp = StraightFlush(hand, handSize);
        if (temp > BH) {
            BH = temp;
        }
        
        return DetermineHand(BH);

    }
    
    private int highCard(Card[] hand, int handSize) {
    //Requires: hand!=null and hand.lenght==handSize
    //and hand to be sorted in ascending order based on hand[i].num
    //Effects: Finds the best highest card in the hand,
    //and returns an integer between 2 and 14 that corresponds to the highest card   
        return hand[handSize-1].getNum();

    }
    
    

    
    private int onepair(Card[] hand, int handSize) {
    //Requires: hand!=null and hand.lenght==handSize
    //Effects: Finds the highest pair in the hand,
    //and returns an integer between 15 and 27 that corresponds to that pair,
    // if no pairs are found,0 is returned
        int j, flag = 0;
        for (int i = 0; i < handSize-1; i++) {
            for (j = i + 1; j < handSize; j++) {
                if ((hand[i].getNum() == hand[j].getNum()) && (hand[i].getNum() > flag)) {
                    flag = hand[i].getNum();
                }
            }
        }
        if (flag == 0) {
            return 0;
        } else {
            return flag + 13;
        }
    }

    private int twoPair(Card[] hand, int handSize) {
    //Requires: hand!=null and hand.lenght==handSize
    //Effects: Finds a two pair in the hand,
    //and returns an integer between 28 and 40 that corresponds to that two pair,
    // if no two pairs are found,0 is returned 
        int j, flag = 0, count = 0;
        for (int i = 0; i < handSize-1; i++) {
            for (j = i + 1; j < handSize; j++) {
                if ((hand[i].getNum() == hand[j].getNum()) && (hand[i].getNum() != flag)) {
                    count++;
                    if (hand[i].getNum() > flag) {
                        flag = hand[i].getNum();
                    }
                }
            }
        }
        if (count == 2) {
            return flag + 26;
        } else {
            return 0;
        }

    }

    private int threeOfKind(Card[] hand, int handSize) {
    //Requires: hand!=null and hand.lenght==handSize
    //Effects: Finds 3 of a kind in the hand,
    //and returns an integer between 41 and 53 that corresponds to that 3 of a kind,
    // if no 3 of a kind  are found,0 is returned   
        int j, count = 0;
        for (int i = 0; i < handSize-1; i++) {
            if (count == 2) {
                return hand[i - 1].getNum() + 39;
            }
            count = 0;
            for (j = i + 1; j < handSize; j++) {
                if (hand[i].getNum() == hand[j].getNum()) {
                    count++;
                }
            }
        }
        return 0;
    }

    private int straight(Card[] hand, int handSize) {
    //Requires: hand!=null and hand.lenght==handSize
    //and hand to be sorted in ascending order based on hand[i].num
    //Effects: Finds a straight in the hand,
    //and returns an integer between 54 and 66  that corresponds to that straight,
    //if no straights  are found,0 is returned   
        if (hand[0].getNum() == 1 && hand[1].getNum() == 2 && hand[2].getNum() == 3 && hand[3].getNum() == 4 && hand[4].getNum() == 13) {
            return 57;
        }
        if(CheckAscend(hand,handSize)==true)
        {
        	return 0;
        }
        return 52 + hand[handSize-1].getNum();
    }

    private int flush(Card[] hand, int handSize) {
    //Requires: hand!=null and hand.lenght==handSize
    //and hand to be sorted in ascending order based on hand[i].num
    //Effects: Finds a flush in the hand,
    //and returns an integer between 67 and 79  that corresponds to that flush,
    //if no flushes are found,0 is returned  

    	int count=SignMatch(hand,handSize);
    	
    	if(count==handSize-1)
    	{
    		return 65 + hand[handSize-1].getNum();
    	}
    	
        
        return 0;
    }

    private int FullHouse(Card[] hand, int handSize) {
    //Requires: hand!=null and hand.lenght==handSize
    //Effects: Finds a FullHouse in the hand,
    //and returns an integer between 80 and 92  that corresponds to that flush,
    //if no FullHouses are found,0 is returned 
        int j, count = 0, temp = 0;
        for (int i = 0; i < handSize-1; i++) {
            if (count == 2) {
                temp = hand[i - 1].getNum();
            }
            count = 0;
            for (j = i + 1; j < handSize; j++) {
                if (hand[i].getNum() == hand[j].getNum()) {
                    count++;
                }
            }
        }
        if (temp != 0) {
            for (int i = 0; i < handSize-1; i++) {
                for (j = i + 1; j < handSize; j++) {
                    if ((hand[i].getNum() == hand[j].getNum()) && (hand[i].getNum() != temp)) {
                        return 78 + temp;
                    }
                }
            }

        }
        return 0;

    }

    private int FourOfKind(Card[] hand, int handSize) {
    //Requires: hand!=null and hand.lenght==handSize
    //Effects: Finds Four of a Kind in the hand,
    //and returns an integer between 93 and 105 that corresponds to that Four of a Kind,
    //if no Four of a Kind are found,0 is returned
        int j, count = 0;
        for (int i = 0; i < handSize-1; i++) {
            if (count == 3) {
                return hand[i - 1].getNum() + 91;
            }
            count = 0;
            for (j = i + 1; j < handSize; j++) {
                if (hand[i].getNum() == hand[j].getNum()) {
                    count++;
                }
            }
        }
        return 0;

    }

    private int StraightFlush(Card[] hand, int handSize) {
    //Effects: Finds a straight flush in the hand,
    //and returns an integer between 109 and 118 that corresponds to that Straight Flush,
    //if no Straight flushes are found,0 is returned
    	boolean flag = false;
    	int flagcount=0;
    	
    	//Checks to see if all the cards in the hand are the same sign 
    	
    	
    	if(SignMatch(hand,handSize)==handSize-1)
    	{
    		flag=true;
    	}
    		
    	
    	
    	//if they are analyze for flush
        if (flag == true) 
        {
        	// in the special case of a royal flush
            if (hand[0].getNum() == 1 && hand[1].getNum() == 2 && hand[2].getNum() == 3 && hand[3].getNum() == 4 && hand[4].getNum() == 13) {
                return 109;
            }
            
            if(CheckAscend(hand,handSize)==true)
            {
            	return 0;
            }
           
            return 104 + hand[handSize-1].getNum();

        }
        return 0;

    }

    /**
  	*Checks if the suits match in the dealt hand
  	*handSize= dealt hand size
  	*hand- hand array
  	*/
    private int SignMatch(Card[] hand,int handSize) {
    	
    	int flagcount=0;
    	//if the signs match increment flagcount
    	for(int i =1; i<handSize; i++)
    	{
    		if ((hand[0].getSign() == hand[i].getSign()) ) 
       	 	{
    			flagcount++;
            }
    	}
    	return flagcount;
    }
    
    /**
  	*Checks if numbers are in ascending order
  	*handSize= dealt hand size
  	*hand- hand array
  	*/
    private boolean CheckAscend(Card[] hand,int handSize) {
    	
    	boolean ascend= false;
    	 for (int i = 0; i < handSize-1; i++) 
    	 {
              if ((hand[i].getNum() + 1) != (hand[i + 1].getNum())) 
              {
                  ascend= true;
              }
          }
    	return ascend;
    }
    
    

    /**
  	*Based on the individual hand evaluations assign a string
  	*/
    private String DetermineHand(int handValue) {
        String handOutput="";
       
        
        if (handValue>15 && handValue<=27) 
        {
        	handOutput="One Pair";
        }else if (handValue>28 && handValue<=40) 
        {
        	 handOutput="Two Pair";
        }else if (handValue>41 && handValue<=53) 
        {
        	 handOutput="Three Of Kind";
        }else if (handValue>54 && handValue<=66) 
        {
        	 handOutput="Straight";
        }else if (handValue>67 && handValue<=79) 
        {
        	 handOutput="Flush";
        }else if (handValue>80 && handValue<=92) 
        {
        	 handOutput="Full House";
        }else if (handValue>93 && handValue<=105) 
        {
        	 handOutput="Four of Kind";
        }else if (handValue>109 && handValue<=118) 
        {
        	 handOutput="Straight Flush";
        }else 
        {
        	handOutput="High Cards";
        }
       
        
        return handOutput;

    }
    
   
}