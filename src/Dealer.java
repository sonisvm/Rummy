import java.util.Random;

public class Dealer {
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
		
		public static void main(String args[]){
			getNewHand();
		}
		
}
