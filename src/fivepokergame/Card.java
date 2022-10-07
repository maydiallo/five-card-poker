package fivepokergame;

/**
 * Creates a card that has two attributes
 *@author Maimouna Diallo
 * 
 */
public class Card {
	
	//declaring variables
    private int sign; //the signs of the cards 1=hearts, 2=diamonds, 3=clubs, 4=spades
    private int num;//where 1=ace and 2,3 and 4 is king, queen and jack respectively
    
	/**
	*Constructor
	* sign- suit of the card
	* num- number of card
	*/	
    public Card(int sign, int num)
    {
        this.setSign(sign);
        this.setNum(num);
    }

    //retrives the sign
	public int getSign() {
		return sign;
	}

	//updates the sign
	public void setSign(int sign) {
		this.sign = sign;
	}

	//retrieves the number
	public int getNum() {
		return num;
	}

	//updates the number
	public void setNum(int num) {
		this.num = num;
	}

	
}
