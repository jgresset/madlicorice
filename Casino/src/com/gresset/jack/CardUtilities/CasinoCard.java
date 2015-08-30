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
	@Override
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		if(obj.getClass()!= this.getClass()){
			return false;
		}
		final CasinoCard other = (CasinoCard)obj;
		if(other.getRank()!=this.getRank()){
			return false;
		}
		if(other.getSuit()!= this.getSuit()){
			return false;
		}
		return true;
	}
	@Override
	public int hashCode(){
		int hash = 1;
		hash *= 17 + this.getSuit().hashCode();
		hash *= 31 + this.getClass().hashCode();
		return hash;
	}
}
