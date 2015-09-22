package com.nullcognition.retrofit;
// ersin 22/09/15 Copyright (c) 2015+ All rights reserved.

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import rx.Observable;


// both synchronous/async request use the same interface method call, use execute or enqueue for respective sync and async requests from the client


public interface GitHub{

	@GET("/users/{user}/repos") Call<List<Repo>> listRepos(@Path("user") String user);

	// custom call adapters are allowed, the return type need not only be a Call
	// with rx java integration you can return an observable with the call adapter

	// to compare call with rx
	@POST("/users/{user}/repos") Call<List<Repo>> loadRepoList(@Path("user") String user);

	@POST("/users/{user}/repos") Observable<List<Repo>> loadRepoListRx(@Path("user") String user);

}


// baseUrl = "http://www.google.com/thisIsReplaced"
// if the annotation parameter is without a leading '/' and the baseUrl ends with a /withoutTrailingBackSlash
// then 'withoutTrailingBackSlash' the last file name will be replaced with the parameter

// baseUrl = "http://www.google.com/annotationParameterAppended"
// if the baseUrl ends with a folder, via the trailing '/' then the annotation paramemter will be appended to
// the baseUrl

// baseUrl = "http://www.google.com/thisIsDeleted/thisIsDeleted2
// if the baseUrl has arguments, and the annotation parameter leads with '/' then the arguments are stripped
// out and the url will be http://www.google.com/annotationParameter

// recommended practice is to end the baseUrl with a '/'
// and any @Url annotation parameters will start with a file or folder without a leading '/'

// baseUrl = "http://www.google.com/
// @GET("search/socks")

// or use the the fully qualified path explicitly
// @GET(http://www.google.com/search/socks")

// OkHttp is auto depended on
