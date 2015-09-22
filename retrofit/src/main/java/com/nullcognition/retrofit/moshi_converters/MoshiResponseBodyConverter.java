//package com.nullcognition.retrofit.moshi_converters;
//// ersin 22/09/15 Copyright (c) 2015+ All rights reserved.
//
//import com.squareup.moshi.JsonAdapter;
//import com.squareup.okhttp.ResponseBody;
//
//import java.io.IOException;
//
//import okio.BufferedSource;
//import retrofit.Converter;
//
//public final class MoshiResponseBodyConverter<T> implements Converter<ResponseBody, T>{
//
//	private final JsonAdapter<T> adapter;
//
//	MoshiResponseBodyConverter(JsonAdapter<T> adapter){
//		this.adapter = adapter;
//	}
//
//	@Override public T convert(ResponseBody value) throws IOException{
//		BufferedSource source = value.source();
//		try{
//			return adapter.fromJson(source);
//		}
//		finally{
//			Utils.closeQuietly(source);
//		}
//	}
//}
