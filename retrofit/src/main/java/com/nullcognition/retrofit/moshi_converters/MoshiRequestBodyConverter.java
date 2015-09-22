//package com.nullcognition.retrofit.moshi_converters;
//// ersin 22/09/15 Copyright (c) 2015+ All rights reserved.
//
//import com.squareup.moshi.JsonAdapter;
//import com.squareup.okhttp.MediaType;
//import com.squareup.okhttp.RequestBody;
//
//import java.io.IOException;
//
//import okio.Buffer;
//import retrofit.Converter;
//
//public final class MoshiRequestBodyConverter<T> implements Converter<T, RequestBody>{
//
//	private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
//
//	private final JsonAdapter<T> adapter;
//
//	MoshiRequestBodyConverter(JsonAdapter<T> adapter){
//		this.adapter = adapter;
//	}
//
//	@Override public RequestBody convert(T value) throws IOException{
//		Buffer buffer = new Buffer();
//		try{
//			adapter.toJson(buffer, value);
//		}
//		catch(IOException e){
//			throw new AssertionError(e); // Writing to Buffer does no I/O.
//		}
//		return RequestBody.create(MEDIA_TYPE, buffer.readByteString());
//	}
//}
