package com.nullcognition.automoshiretrofit;

/**
 * Created by mms on 11/15/16.
 */

public class GsonModel {

  public String text;

  GsonModel(String t) {
    text = t;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
