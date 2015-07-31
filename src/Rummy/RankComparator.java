package Rummy;

import java.util.Comparator;

public class RankComparator implements Comparator<Card> {

	@Override
	public int compare(Card c1, Card c2) {
		return Integer.compare(c1.getRank(),c2.getRank());
	}
}
