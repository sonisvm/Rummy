package Rummy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	

	
	public List<Card> sortByRank(List<Card> cards) {
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
	
	private Map<Integer,List<Card>> possibleRummyMatches = new HashMap<Integer,List<Card>>();
//	
//    public boolean getMinList(List<Card> initialList,List<Card> finalList,List<CombinationSequence> combinations,int cardsUsed) {
//    	boolean flag = false;
//    	if(isRummy(initialList)){
//
//    		finalList.addAll(initialList);
//    		flag = true;
//    	}	
//    	
//    	if(flag || isRummy(finalList))	
//    	{
//    		this.possibleRummyMatches.put(cardsUsed, finalList);
//    		return true;
//    	}
//    		
//    	for(CombinationSequence c :combinations) 
//    	{
//    		List<Card> clist = c.getCardCombination();
//    		for(int i = 0;i<clist.size();i++) { 
//    			finalList.addAll(clist);
//    			if(clist.size() < 3)
//    				cardsUsed = 3 -clist.size() + cardsUsed;
//    			for(Card usedCard: clist) {
//    				initialList.remove(usedCard);
//    			}
//    			getMinList(initialList,finalList,findAllSequences(initialList),cardsUsed)); 
//    				
//    			
//    		}
//    	}
//		return true;
//    	
//    }

	
    public void getMinList(List<Card> initialList,List<Card> finalList,List<CombinationSequence> combinations,int cardsUsed) {
    	
    	if(initialList.isEmpty()) {
    		if(isRummy(finalList)) {
    			this.possibleRummyMatches.put(cardsUsed, finalList);
    		}    		
    		return;
    	}
    	
    	for(CombinationSequence c :combinations) 
    	{
    		List<Card> clist = c.getCardCombination();
    		for(int i = 0;i<clist.size();i++) { 
    			finalList.addAll(clist);
    			if(clist.size() < 3)
    				cardsUsed = cardsUsed + 3 -clist.size();
    			for(Card usedCard: clist) {
    				initialList.remove(usedCard);
    			}
    			getMinList(initialList,finalList,findAllSequences(initialList),cardsUsed);     				
    			
    		}
    	}
    	
    }
    
	
    public List<CombinationSequence> findAllSequences(List<Card> clist) {
		return null;
    	
    }
	public static void main(String args[]){
		Hand hand = new Hand();
		
		hand.displayHand();
		hand.removeSequences();

		hand.findAndRemoveSetsAndCanasta();

		hand.displayHand();
		hand.removeSets();
		hand.displayHand();
		
	}

	private void removeSets() {
		// TODO Auto-generated method stub
		
	}
	 
}
