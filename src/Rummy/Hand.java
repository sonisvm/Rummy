package Rummy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	
	public static List<Card> sortByRank(List<Card> cards) {
		List<Card> cardList = new ArrayList<Card>(cards);
		Collections.sort(cardList, new RankComparator());
		return cardList;
	}

	
	public List<Card> sortBySuit(List<Card> cards) {
		List<Card> cardList = new ArrayList<Card>(cards);
		Collections.sort(cardList,new SuitComparator());
		return cardList;
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
	public static void findAndRemoveSetsAndCanasta(){
		List<Card> cardsSortedByRank = sortByRank(cardsInHand);
		ArrayList<Card> cards = new ArrayList<Card>();
		for(int i=0;i < cardsSortedByRank.size()-2;i++){
			cards.add(cardsSortedByRank.get(i));
			cards.add(cardsSortedByRank.get(i+1));
			cards.add(cardsSortedByRank.get(i+2));
			if(isSet(cards)){
				if( i < cardsSortedByRank.size()-3){
					cards.add(cardsSortedByRank.get(i+3));
					if(isSet(cards)){
						removeCards(cards);
					}
					else{
						cards.remove(cards.size()-1);
					}
				
				}
				removeCards(cards);
				
			}
			
		}
	}
	
	public static void displayHand(){
		for(Card card : cardsInHand){
			System.out.print(card.toString() + " ");
		}
		System.out.println();
	}
	
	public static ArrayList<Card> getCardsInHand() {
		return cardsInHand;
	}
	
	public boolean isRummy(List<Card> cards) {
	    int i=0;
	    int numNaturalSeq=0;
	    ArrayList<Card> groupOfCards = new ArrayList<Card>();
	    groupOfCards.add(cards.get(i));
	    groupOfCards.add(cards.get(i+1));
	    groupOfCards.add(cards.get(i+2));
	    i += 3;
	    while(i<cards.size()){
	    	if(isSequence(groupOfCards) || isSet(groupOfCards) || isCanasta(groupOfCards)){
	    		numNaturalSeq++;
	    		groupOfCards.add(cards.get(i));
	    		i++;
	    	}
	    	else{
	    		groupOfCards.clear();
	    		groupOfCards.add(cards.get(i-1));
	    	}
	    }
	    if(numNaturalSeq >=2){
	    	return true;
	    }
		return false;
		
	}
	
    public List<Card> getMinList(List<Card> Cards,List<List<Card>> combinations) {
    	if(isRummy(Cards))
    		return CardList;
    	for(List<Card> clist: )
    	
    }
	public static void main(String args[]){
		Hand hand = new Hand();
		
		hand.displayHand();
		hand.removeSequences();

		hand.findAndRemoveSetsAndCanasta();

		hand.displayHand();
		

		
	}

	private void removeSets() {
		// TODO Auto-generated method stub
		
	}
	 
}
