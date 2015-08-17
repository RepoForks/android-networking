package com.nullcognition.moshi;
// ersin 17/08/15 Copyright (c) 2015+ All rights reserved.


import com.nullcognition.moshi.models.Card;
import com.nullcognition.moshi.models.Suit;
import com.squareup.moshi.FromJson;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.ToJson;

public final class CardAdapter{

	@ToJson String toJson(Card card){
		return card.rank + card.suit.name().substring(0, 1);
	}

	@FromJson Card fromJson(String card){
		if(card.length() != 2){ throw new JsonDataException("Unknown card: " + card); }

		char rank = card.charAt(0);
		switch(card.charAt(1)){
			case 'C':
				return new Card(rank, Suit.CLUBS);
			case 'D':
				return new Card(rank, Suit.DIAMONDS);
			case 'H':
				return new Card(rank, Suit.HEARTS);
			case 'S':
				return new Card(rank, Suit.SPADES);
			default:
				throw new JsonDataException("unknown suit: " + card);
		}
	}
}
