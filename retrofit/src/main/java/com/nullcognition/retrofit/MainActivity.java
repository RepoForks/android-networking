package com.nullcognition.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.squareup.okhttp.HttpUrl;

import java.io.IOException;
import java.util.List;

import retrofit.BaseUrl;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
// retrofit 2 - notes from:
// http://inthecheesefactory.com/blog/retrofit-2.0/en
// http://qiita.com/yongjhih/items/e0a4e3db04efcfa0ca2e
// https://github.com/square/retrofit/tree/master/samples/src/main/java/com/example/retrofit
// https://www.youtube.com/watch?v=KIAoQbAu3eA


public class MainActivity extends AppCompatActivity{

	public static final String API_URL = "https://api.github.com";
	Retrofit retrofit;
	BaseUrl  baseUrl; // an interface that returns a HttpUrl, which an involved class
	HttpUrl  httpUrl;

	GitHub github;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		retrofit = new Retrofit.Builder()
				.baseUrl(API_URL)
//				.addConverterFactory(MoshiConverterFactory.create()) // not working yet
						// see https://github.com/square/retrofit/tree/397c10e4fc211c5fbbb474c5065a80daa05c4922/retrofit-converters
// for a list of well known converters: json, xml, protobuf
				.build();

		github = retrofit.create(GitHub.class);

		synchronousCall();

	}

	private void synchronousCall(){

		Call<List<Repo>> call = github.listRepos("octocat"); // throwing an exception here
		// Caused by: java.lang.IllegalArgumentException: Unable to create converter for java.util.List<com.nullcognition.retrofit.Repo>

		List<Repo> repos = null;

		// synchronous

		try{ repos = call.execute().body();}
		catch(IOException e){ e.printStackTrace();}

		((ListView) findViewById(R.id.listView)).setAdapter(new ArrayAdapter<Repo>(this, android.R.layout.simple_list_item_1, repos));

		// asynchronous

		call.enqueue(new Callback<List<Repo>>(){
			@Override public void onResponse(final Response<List<Repo>> response){
			//	response.body() // body() returns a List<Contributors>
			}
			@Override public void onFailure(final Throwable t){ }
		});
	}


}



