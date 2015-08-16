package com.gresset.jack.CardUtilities;

/**
 * @author Jacques Gresset
 * 
 *
 */
public abstract class AbstractCard {
	
	
	/**
	 * Flips the card over, this is simply a tool to define what can be seen
	 */
	public abstract void flip();
	
	
	/**
	 * Gets the card's visibility as a boolean
	 * @return the orientation of the card where true = card is face up, false = card is not face up
	 */
	public abstract boolean isFaceUp();
	
}
