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
		m.put(Suits.Clubs, 0);
		m.put(Suits.Hearts, 0);
		
	}
	@Test
	public void testShuffle() {
		CasinoDeck deck = new CasinoDeck();
	}

}
