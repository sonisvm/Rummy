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
		
		/*public static void main(String args[]){
			Card[] cards=getNewHand();
			for(int i=0;i<13;i++){
				System.out.println(cards[i].getRank() + " "+ cards[i].getSuit());
			}
		}*/
		
}
