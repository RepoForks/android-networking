package com.nullcognition.automoshiretrofit;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

/**
 * Created by mms on 11/15/16.
 */
@AutoValue public abstract class GsonAutoModel {
  public static GsonAutoModel create(String text) {
    return new AutoValue_GsonAutoModel(text);
  }

  public static TypeAdapter<GsonAutoModel> typeAdapter(Gson gson) {
    return new AutoValue_GsonAutoModel.GsonTypeAdapter(gson);
  }

  abstract String text();
}