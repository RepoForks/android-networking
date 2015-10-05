package com.nullcognition.retrofit;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.okhttp.HttpUrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit.BaseUrl;
import retrofit.Call;
import retrofit.Callback;
import retrofit.MoshiConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
// retrofit 2 - notes from:
// http://inthecheesefactory.com/blog/retrofit-2.0/en
// http://qiita.com/yongjhih/items/e0a4e3db04efcfa0ca2e // fork of retrofit
// https://github.com/square/retrofit/tree/master/samples/src/main/java/com/example/retrofit
// https://www.youtube.com/watch?v=KIAoQbAu3eA


public class MainActivity extends AppCompatActivity{

	public static final String API_URL = "https://api.github.com";
	Retrofit retrofit;
	BaseUrl  baseUrl; // an interface that returns a HttpUrl, which an involved class
	HttpUrl  httpUrl;

	GitHub github;
	List<Repo> repos = null;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

//		Moshi moshi = new Moshi.Builder().add(SOME_OBJECT).build();
//		then pass moshi into the create method for the converter factory

		// if needing interceptors, create it in the okhttp level stack and pass
		// the ok http client to the retrofit builder

		retrofit = new Retrofit.Builder()
				.baseUrl(API_URL)
				.addConverterFactory(MoshiConverterFactory.create())
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.build();

		github = retrofit.create(GitHub.class);

		Call<List<Repo>> call = github.listRepos("ersin-ertan");

		Observable<List<Repo>> observable = github.loadRepoListRx("octocat");

		// Call instances can be executed either synchronously or asynchronously. Each instance can only be used once,
		// but calling clone() will create a new instance that can be used.

		synchronousCall(call);
		asynchronousCall(call.clone());
		rxObservable(observable);
	}
	private void rxObservable(final Observable<List<Repo>> observable){

		observable.observeOn(AndroidSchedulers.mainThread())
		          .subscribe(new Subscriber<List<Repo>>(){
			          @Override
			          public void onCompleted(){
				          Toast.makeText(getApplicationContext(), "Completed", Toast.LENGTH_SHORT).show();
			          }

			          @Override
			          public void onError(Throwable e){
				          Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
			          }

			          @Override
			          public void onNext(List<Repo> repoObject){
				          Toast.makeText(getApplicationContext(), repoObject.get(0).name, Toast.LENGTH_SHORT).show();
			          }
		          });
	}

	private void asynchronousCall(final Call<List<Repo>> call){

		call.enqueue(new Callback<List<Repo>>(){
			@Override public void onResponse(final Response<List<Repo>> response){

				// will be called even if there is a parse error, thus check for null
				if(response.body() == null){
					Log.d("MainActivity", response.errorBody().toString());
					return;
				}

				repos = response.body();
				List<String> strings = new ArrayList<String>(repos.size());
				for(Repo r : repos){ strings.add(r.name);}

				((ListView) findViewById(R.id.listView)).setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, strings));

				Toast.makeText(MainActivity.this, "Async done", Toast.LENGTH_SHORT).show();
			}
			@Override public void onFailure(final Throwable t){ Toast.makeText(MainActivity.this, "Async Fail", Toast.LENGTH_SHORT).show();}
		});

//		call.cancel(); // to stop
	}

	private void synchronousCall(final Call<List<Repo>> call){ // network on main thread exception

		new AsyncTask<Void, Void, Void>(){
			@Override protected Void doInBackground(final Void... params){
				try{ repos = call.execute().body();}
				catch(IOException e){ e.printStackTrace();}

				return null;
			}
			@Override protected void onPostExecute(final Void aVoid){
				super.onPostExecute(aVoid);

				List<String> strings = new ArrayList<String>(repos.size());
				for(Repo r : repos){ strings.add(r.name);}

				((ListView) findViewById(R.id.listView)).setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, strings));
				Toast.makeText(MainActivity.this, "Sync done", Toast.LENGTH_SHORT).show();

			}
		}.execute();


	}


}



