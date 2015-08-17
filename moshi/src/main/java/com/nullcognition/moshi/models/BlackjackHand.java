package com.nullcognition.moshi.models;
// ersin 17/08/15 Copyright (c) 2015+ All rights reserved.

import java.util.List;

public final class BlackjackHand{

	public final Card       hidden_card;
	public final List<Card> visible_cards;

	public BlackjackHand(Card hidden_card, List<Card> visible_cards){
		this.hidden_card = hidden_card;
		this.visible_cards = visible_cards;
	}

	@Override public String toString(){
		return hidden_card != null && visible_cards !=null ?
				"hidden=" + hidden_card + ",\nvisible=" + visible_cards
				: "blackjackHand.toString error";
	}
}
