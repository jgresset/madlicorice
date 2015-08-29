package tests;

import static org.junit.Assert.*;
//import java.util.Map;
import java.util.HashMap;
import org.junit.Test;
import com.gresset.jack.CardUtilities.*;

public class CardTests {

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
			rankMap.put(c.getRank(), rankMap.get(c.getRank()));
		}
		for(CasinoRank r: CasinoRank.values()){
			assertEquals(rankMap.get(r),Integer.valueOf(Suits.values().length));
		}
		for(Suits s: Suits.values()){
			assertEquals(m.get(s),Integer.valueOf(CasinoRank.values().length));
		}
	}
	@Test
	public void testShuffle() {
		CasinoDeck deck = new CasinoDeck();
	}

}
