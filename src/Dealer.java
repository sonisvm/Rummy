package Rummy;

import java.util.ArrayList;
import java.util.Random;

public class Dealer {
		
				
		public static ArrayList<Card> getNewHand(){
			Random r = new Random();
			ArrayList<Card> hand = new ArrayList<Card>();
			int num;
			int High = 156;
			int Low = 1;
			for(int i=0;i<13;i++){
				num = r.nextInt(High-Low) + Low;
				hand.add(new Card(num));
			}
			 return hand;
		}
		
		public static void main(String args[]){
//			ArrayList<Card> cards=getNewHand();
//			for(Card c: cards){
//				System.out.println(c.getRank() + " "+ c.getSuit());
//			}
			Hand h = new Hand();
			h.sortByRank();
			h.displayHand();
			System.out.println();
			h.sortBySuit();
			h.displayHand();
		}
		
}
