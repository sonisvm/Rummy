
public class Hand 
{
	Card cardsInHand[];
	
<<<<<<< HEAD
	Hand()
	{
		//cardsInHand = Deck.getNewHand();
=======
	Hand(){
		cardsInHand = Dealer.getNewHand();
>>>>>>> 5952d4ca0452451af36c95319a34bc0cfb6afdb3
	}
	
	public boolean isSequence(Card cards[])
	{
		for(int i = 0; i < cards.length; i++)
		{
			if(!(cards[i].isPrev(cards[i+1]))) return false;
		}
		return true;
		
	}
	
	public boolean isSet(Card cards[])
	{
		for(int i = 0; i < cards.length; i++)
		{
			if(!(cards[i].isSameRank(cards[i+1]) && !cards[i].isSameSuite(cards[i+1]))) return false;
		}
		return true;
	}
	
	public boolean isCanasta(Card cards[]){
		
	}
	
	public boolean isPossibleSequence(Card cards[]){
		
	}
	
	public boolean isPossibleSet(Card cards[]){
		
	}
	
	public void removeCards(Card cards[]){
		
	}
	
	public void countHand(Card cards[]){
		
	}
}
