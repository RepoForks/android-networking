package com.nullcognition.logansquare.models;
// ersin 17/08/15 Copyright (c) 2015+ All rights reserved.

import com.bluelinelabs.logansquare.annotation.JsonIgnore;
import com.bluelinelabs.logansquare.annotation.JsonObject;

@JsonObject(fieldDetectionPolicy = JsonObject.FieldDetectionPolicy.NONPRIVATE_FIELDS)
public class PrivateFields{

	public String detected;

	@JsonIgnore public int notDetected;

	private int notDetectedPrivate;

	public int getNotDetectedPrivate(){ return notDetectedPrivate;}

	public void setNotDetectedPrivate(final int notDetectedPrivate){ this.notDetectedPrivate = notDetectedPrivate;}

}
