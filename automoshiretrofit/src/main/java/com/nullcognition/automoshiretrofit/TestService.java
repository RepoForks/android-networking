package com.nullcognition.automoshiretrofit;

import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by mms on 11/15/16.
 */

public interface TestService {

  // some kind of model object or jsonobject is required
  @POST("post") Call<JsonObject> post(@Body AutoModel model);

  @POST("post") Call<JsonObject> post(@Body GsonAutoModel model);

  @POST("post") Call<JsonObject> post(@Body GsonModel model);

  @POST("post") Call<JsonObject> post(@Body Model model);
}
