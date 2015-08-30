package com.gresset.jack.CardUtilities.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
//import java.util.Map;
import java.util.HashMap;
import org.junit.Test;
import com.gresset.jack.CardUtilities.*;

public class CardTests {
	@Test
	public void testDeck(){
		CasinoDeck d = new CasinoDeck();
		assertEquals(d.numLeft(),52);
		HashMap<Suits,Integer> m = new HashMap<Suits,Integer>();
		HashMap<CasinoRank,Integer> rankMap = new HashMap<CasinoRank,Integer>();
		for(Suits s: Suits.values()){
			m.put(s, 0);
		}
		for(CasinoRank r: CasinoRank.values()){
			rankMap.put(r, 0);
		}
		while(d.numLeft()>0){
			CasinoCard c = d.Deal();
			m.put(c.getSuit(),m.get(c.getSuit())+1);
			rankMap.put(c.getRank(), rankMap.get(c.getRank())+1);
		}
		for(CasinoRank r: CasinoRank.values()){
			Integer num = rankMap.get(r);
			Integer expectedNum = Integer.valueOf(Suits.values().length);
//			System.out.println(String.format("%d %d",num,expectedNum));
			assertEquals(num,expectedNum);
		}
		for(Suits s: Suits.values()){
			assertEquals(m.get(s),Integer.valueOf(CasinoRank.values().length));
		}
	}
	@Test
	public void testCardEquals(){
//		CasinoCard c = new CasinoCard(Suits.Spades,CasinoRank.Ace);
//		CasinoCard other = new CasinoCard(Suits.Spades,CasinoRank.Ace);
//		CasinoCard different = new CasinoCard(Suits.Diamonds,CasinoRank.Ace);
//		assertEquals(c,other);
//		assertTrue(c.equals(other));
//		assertFalse(c.equals(different));
	}
	@Test
	public void testShuffle() {
		CasinoDeck deck = new CasinoDeck();
		int numberOfCards = deck.numLeft();
		HashMap<CasinoCard,int[]> distributionList = new HashMap<CasinoCard,int[]>();
		while(deck.numLeft()>0){
			CasinoCard c = deck.Deal();
			distributionList.put(c, new int[numberOfCards]);
		}
		int numIterations = 1000000;
		int threshold = 200;
		for(int i = 0; i < numIterations; i++){
			CasinoDeck d = new CasinoDeck();
			d.Shuffle();
			int index = 0;
			while(d.numLeft()>0){
				CasinoCard c = d.Deal();
				int[] currentDist = distributionList.get(c);
				currentDist[index] = currentDist[index]+1;
				index++;
			}
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int spades = 0;
		int diamonds = 0;
		int clubs = 0;
		int hearts = 0;
		for(int[] dist: distributionList.values()){
			for(int i: dist){
				System.out.println(i);
				if(min>i){
					min = i;
				}
				if(max<i){
					max = i;
				}
			}
		}
		System.out.println(String.format("%d %d", min,max));
		assertTrue(min+threshold>max);
		
	}

}
