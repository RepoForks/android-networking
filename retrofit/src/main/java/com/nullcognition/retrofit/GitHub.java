package com.nullcognition.retrofit;
// ersin 22/09/15 Copyright (c) 2015+ All rights reserved.

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;


// both synchronous/async request use the same interface method call, use execute or enqueue for respective sync and async requests from the client


public interface GitHub{

	@GET("/users/{user}/repos") Call<List<Repo>> listRepos(@Path("user") String user);
}

