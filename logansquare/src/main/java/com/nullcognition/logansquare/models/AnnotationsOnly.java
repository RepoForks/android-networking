package com.nullcognition.logansquare.models;
// ersin 17/08/15 Copyright (c) 2015+ All rights reserved.

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import com.bluelinelabs.logansquare.annotation.OnJsonParseComplete;
import com.bluelinelabs.logansquare.annotation.OnPreJsonSerialize;

// recommended way; safest
@JsonObject
public class AnnotationsOnly{

	// brackets must be \" in side "" to not be considered a ", each newline with + requires
	// encapsulating ""
	public static final String jsonString =
			"{" +
					"\"url\":\"urlField\"," +
					"\"_id\":\"3403\"," +
					"\"privateData\": \"4\"" +
					"}";

	@JsonField public        String url;
	@JsonField(name = "_id") int    imageId;
	// change parsed/processing name, package level scope works

	public int getId(){return imageId;}

	public int notUsed;

	@JsonField private int privateData;

	public int getPrivateData(){return privateData;}

	public void setPrivateData(final int privateData){this.privateData = privateData;}

	@OnPreJsonSerialize void onPreSerialize(){}

	@OnJsonParseComplete void onParseComplete(){}

}
