
public class Hand 
{
	Card cardsInHand[];
	
	Hand()
	{
		//cardsInHand = Deck.getNewHand();
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
