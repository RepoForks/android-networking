package com.nullcognition.logansquare.models;
// ersin 17/08/15 Copyright (c) 2015+ All rights reserved.

import com.bluelinelabs.logansquare.annotation.JsonIgnore;
import com.bluelinelabs.logansquare.annotation.JsonObject;

@JsonObject(fieldDetectionPolicy = JsonObject.FieldDetectionPolicy.NONPRIVATE_FIELDS,
            serializeNullObjects = true)
public class PrivateFields{

	// detected with out annotations but to serialize null value you must include ^^
	public String detected = null;
	// which will become serialized when converting from model to json
	// may also do the same with serializeNullCollectionElements = true

	@JsonIgnore public int notDetected;

	private int notDetectedPrivate;

	public int getNotDetectedPrivate(){ return notDetectedPrivate;}

	public void setNotDetectedPrivate(final int notDetectedPrivate){ this.notDetectedPrivate = notDetectedPrivate;}

}
