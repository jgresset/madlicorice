package com.gresset.jack.CardUtilities;

/**
 * @author Jacques Gresset
 *
 */
public class CasinoCard extends AbstractCard {

	private Suits suit;
	private CasinoRank rank;
	private boolean isFaceUp;
	
	CasinoCard(Suits s, CasinoRank r){
		this.suit = s;
		this.rank = r;
		isFaceUp = false;
	}
	
	@Override
	public void flip() {
		isFaceUp = !isFaceUp;
	}

	@Override
	public boolean isFaceUp() {
		return isFaceUp;
	}
	/**
	 * @return the suit of the current card
	 */
	public Suits getSuit(){
		return suit;
	}
	
	/**
	 * @return the rank of the current card
	 */
	public CasinoRank getRank(){
		return rank;
	}

}
