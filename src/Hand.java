import java.util.ArrayList;
import java.util.Collections;

public class Hand 
{
	private static ArrayList<Card> cardsInHand;
	
	Hand(){
		cardsInHand = Dealer.getNewHand();
	}
	
	public static boolean isSequence(ArrayList<Card> cards)
	{
		for(int i = 0; i < cards.size()-1; i++)
		{
			if(!(cards.get(i).isPrev(cards.get(i+1)))){
				return false;
			}
		}
		return true;
		
	}
	
	public static boolean isSet(ArrayList<Card> cards)
	{
		for(int i = 0; i < cards.size() - 1; i++)
		{
			if(!cards.get(i).isSameRank(cards.get(i+1)) || cards.get(i).isSameSuite(cards.get(i+1))) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isCanasta(ArrayList<Card> cards){
		for(int i = 0; i < cards.size() - 1; i++)
		{
			if(!cards.get(i).isSameRank(cards.get(i+1)) || !cards.get(i).isSameSuite(cards.get(i+1))) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPossibleSequence(ArrayList<Card> cards){
		
	}
	
	public static boolean isPossibleSet(ArrayList<Card> cards){
		
	}
	
	public static void removeCards(ArrayList<Card> cards){
		
	}
	
	public static int countHand(ArrayList<Card> cards){
		return cards.size();
	}
	
	
	public static void displayHand(){
		for(Card card : cardsInHand){
			System.out.println(card.toString());
		}
	}
	
	public static void main(String args[]){
		Hand hand = new Hand();
		hand.sortHand();
		hand.displayHand();
	}
}
