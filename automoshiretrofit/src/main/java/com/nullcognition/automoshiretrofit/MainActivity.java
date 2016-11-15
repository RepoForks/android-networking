package com.nullcognition.automoshiretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.google.gson.JsonObject;
import com.squareup.moshi.Moshi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class MainActivity extends AppCompatActivity {

  private Moshi moshi = new Moshi.Builder().build();

  private Retrofit retrofit = new Retrofit.Builder().baseUrl("https://httpbin.org/")
      .addConverterFactory(GsonConverterFactory.create())
      .addConverterFactory(MoshiConverterFactory.create())
      //.addConverterFactory(MoshiConverterFactory.create(moshi))
      //.add(AdapterFactory.create()).build())
      .build();

  public TestService testService = retrofit.create(TestService.class);

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //testService.post(AutoModel.create("text"));

  }

  @Override protected void onStart() {
    super.onStart();

    //postGsonModel();
    //postAutoGsonModel();
    postMoshiModel();
    //postModel();
  }

  private void postGsonModel() {
    testService.post(new GsonModel("text")).enqueue(new Callback<JsonObject>() {
      @Override public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
        Toast.makeText(MainActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
      }

      @Override public void onFailure(Call<JsonObject> call, Throwable t) {
        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
      }
    });
  }

  private void postModel() {
    testService.post(new Model("text")).enqueue(new Callback<JsonObject>() {
      @Override public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
        Toast.makeText(MainActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
      }

      @Override public void onFailure(Call<JsonObject> call, Throwable t) {
        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
      }
    });
  }

  private void postMoshiModel() {
    testService.post(new Model("text")).enqueue(new Callback<JsonObject>() {
      @Override public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
        Toast.makeText(MainActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
      }

      @Override public void onFailure(Call<JsonObject> call, Throwable t) {
        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
      }
    });
  }

  private void postAutoGsonModel() {
    testService.post(GsonAutoModel.create("text")).enqueue(new Callback<JsonObject>() {
      @Override public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
        Toast.makeText(MainActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
      }

      @Override public void onFailure(Call<JsonObject> call, Throwable t) {
        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
      }
    });
  }
}
