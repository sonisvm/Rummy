import java.util.ArrayList;

public class Hand 
{
	private ArrayList<Card> cardsInHand;
	
	Hand(){
		cardsInHand = Dealer.getNewHand();
	}
	
	public boolean isSequence(ArrayList<Card> cards)
	{
		for(int i = 0; i < cards.size(); i++)
		{
			if(!(cards.get(i).isPrev(cards.get(i+1)))){
				return false;
			}
		}
		return true;
		
	}
	
	public boolean isSet(ArrayList<Card> cards)
	{
		for(int i = 0; i < cards.size(); i++)
		{
			if(!cards.get(i).isSameRank(cards.get(i+1)) || cards.get(i).isSameSuite(cards.get(i+1))) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isCanasta(ArrayList<Card> cards){
		for(int i = 0; i < cards.size(); i++)
		{
			if(!cards.get(i).isSameRank(cards.get(i+1)) || !cards.get(i).isSameSuite(cards.get(i+1))) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isPossibleSequence(ArrayList<Card> cards){
		
	}
	
	public boolean isPossibleSet(ArrayList<Card> cards){
		
	}
	
	public void removeCards(ArrayList<Card> cards){
		
	}
	
	public void countHand(ArrayList<Card> cards){
		
	}
}
