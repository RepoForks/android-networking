package com.nullcognition.moshi.models;
// ersin 17/08/15 Copyright (c) 2015+ All rights reserved.


public final class Card{

	public final char rank;
	public final Suit suit;

	public Card(char rank, Suit suit){
		this.rank = rank;
		this.suit = suit;
	}

	@Override
	public String toString(){
		return suit != null ? rank + " " + suit.toString() : "suit.toString error";
	}
}
