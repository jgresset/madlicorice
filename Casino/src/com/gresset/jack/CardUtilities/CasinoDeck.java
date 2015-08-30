package com.gresset.jack.CardUtilities;

import java.util.Queue;
import java.security.SecureRandom;
import java.util.LinkedList;

public class CasinoDeck implements IDeck<CasinoCard> {

	private LinkedList<CasinoCard> deck;
	private static SecureRandom r;
	public CasinoDeck(){
		deck = new LinkedList<CasinoCard>();
		if(r == null)
			r = new SecureRandom();
		for(Suits s : Suits.values()){
			for(CasinoRank r: CasinoRank.values()){
				deck.add(new CasinoCard(s,r));
			}
		}
	}
	@Override
	public void Shuffle() {
		for(int i =deck.size()-1; i>0; i--){
			int index = r.nextInt(i+1);
			CasinoCard c = deck.get(index);
			CasinoCard s = deck.get(i);
			deck.set(index, s);
			deck.set(i, c);
		}
	}

	@Override
	public CasinoCard Deal() {
		return ((Queue<CasinoCard>)deck).remove();
	}

	@Override
	public void AddToDeck(CasinoCard toAdd) {
		((Queue<CasinoCard>)deck).add(toAdd);
		
	}

	@Override
	public int numLeft() {
		return deck.size();
	}

}
