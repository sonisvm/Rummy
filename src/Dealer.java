import java.util.Random;

public class Dealer {
		
				
		public static Card getCard(int num){
			return new Card((num % 52) % 13, (num % 52) / 13);
		}
		
		public static Card[] getNewHand(){
			Random r = new Random();
			Card[] hand = new Card[13];
			int num;
			int High = 156;
			int Low = 1;
			for(int i=0;i<13;i++){
				num = r.nextInt(High-Low) + Low;
				hand[i] = getCard(num);
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