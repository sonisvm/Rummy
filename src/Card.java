

public class Card {		
	private	int suit;
	private int rank;
	
	public Card(int rank,int suit)
	{
		this.rank = rank;
		this.suit = suit;
	}

	public int getSuit() {
		return suit;
	}
	public void setSuit(int suit) {
		this.suit = suit;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public Card CompareCardBySuit(Card c1)
	{
		if (this.suit > c1.suit) return this;
		else return c1;
	}
	
	public Card CompareCardByRank(Card c1)
	{
		if (this.rank > c1.rank) return this;
		else return c1;
	}
}
