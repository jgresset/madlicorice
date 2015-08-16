package com.gresset.jack.CardUtilities;

public interface IDeck<T> {
	public void Shuffle();
	public T Deal();
	public void AddToDeck(T toAdd);
	public int numLeft();
}
