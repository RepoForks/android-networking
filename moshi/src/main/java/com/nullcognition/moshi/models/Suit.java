package com.nullcognition.moshi.models;
// ersin 17/08/15 Copyright (c) 2015+ All rights reserved.


public enum Suit{
	CLUBS, DIAMONDS, HEARTS, SPADES;

	@Override public String toString(){
		return name().substring(0, 1);
	}
}
