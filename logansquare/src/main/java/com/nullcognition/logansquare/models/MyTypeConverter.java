package com.nullcognition.logansquare.models;
// ersin 22/08/15 Copyright (c) 2015+ All rights reserved.


import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;

import java.io.IOException;

// note classes coupled within this class are put in only for convenience of the example, and should
// be placed outside, whithin their own class file, most annotation processors that I have worked with
// require this

public class MyTypeConverter implements TypeConverter<MyTypeConverter.ClassNeedingTypeConversion>{ // extends a TypeConverter<Type>

	// for globally registered types use
	{
		LoganSquare.registerTypeConverter(ClassNeedingTypeConversion.class, new MyTypeConverter());
	}


	public static class ClassNeedingTypeConversion{ }

	// or if you only need certain variables to be type converted use


	@JsonObject
	public static class Model{

		@JsonField(typeConverter = MyTypeConverter.class)
		public ClassNeedingTypeConversion speciallyConvertedDate;
	}

	@Override public ClassNeedingTypeConversion parse(final JsonParser jsonParser) throws IOException{
		return null;
	}

	@Override public void serialize(final ClassNeedingTypeConversion object, final String fieldName, final boolean writeFieldNameForObject, final JsonGenerator jsonGenerator) throws IOException{

	}

}
