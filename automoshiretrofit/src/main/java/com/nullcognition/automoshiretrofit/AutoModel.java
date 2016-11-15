package com.nullcognition.automoshiretrofit;

import com.google.auto.value.AutoValue;

/**
 * Created by mms on 11/15/16.
 */

@AutoValue public abstract class AutoModel {

  public static AutoModel create(String text) {
    return new AutoValue_AutoModel(text);
  }

  abstract String text();
}
