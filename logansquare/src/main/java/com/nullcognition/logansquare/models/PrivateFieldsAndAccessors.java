package com.nullcognition.logansquare.models;
// ersin 17/08/15 Copyright (c) 2015+ All rights reserved.

import com.bluelinelabs.logansquare.annotation.JsonIgnore;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.List;

@JsonObject(fieldDetectionPolicy = JsonObject.FieldDetectionPolicy.NONPRIVATE_FIELDS_AND_ACCESSORS)
public class PrivateFieldsAndAccessors{

	public String detected;
	List<PrivateFieldsAndAccessors> alsoDetected;

	@JsonIgnore public int ingnoreAnnotation;
	private            int ingored;

	private int notIgnoredHasAccessors;

	public int getNotIgnoredHasAccessors(){ return notIgnoredHasAccessors;}

	public void setNotIgnoredHasAccessors(final int notIgnoredHasAccessors){
		this.notIgnoredHasAccessors = notIgnoredHasAccessors;
	}


}
