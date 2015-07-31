package Rummy;
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
	
	public boolean isPossibleSequence(ArrayList<Card> cards){
		for(int i = 0; i < cards.size(); i++)
		{
			if( !( (cards.get(i).isPrev(cards.get(i+1)) 
					|| (cards.get(i).isNext(cards.get(i+1)) 
					&& (Math.abs(cards.get(i).getRank() - cards.get(i+1).getRank()) == 2)))))
			{
				return false;
			}
		}
		return true;

	}
	
	
	public static void removeCards(ArrayList<Card> cards){
		
	}
	
	public void sortByRank() {
		Collections.sort(cardsInHand, new RankComparator());
	}
	
	public void sortBySuit() {
		Collections.sort(cardsInHand,new SuitComparator());
	}
	
	public static int countHand(ArrayList<Card> cards){
		return cards.size();
	}
	
	public static void removeSequences(){
		//sort by suit
		//sort by rank
		for(int i=0;i<cardsInHand.size();i++){
			
		}
	}
	
	public static void displayHand(){
		for(Card card : cardsInHand){
			System.out.println(card.toString());
		}
	}
	
	public static void main(String args[]){
		Hand hand = new Hand();
		
		hand.displayHand();
		hand.removeSequences();
		hand.removeSets();
		
	}
}
