package com.nullcognition.moshi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.nullcognition.moshi.models.BlackjackHand;
import com.nullcognition.moshi.models.Card;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;
import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.nullcognition.moshi.models.Suit.*;

public class ActivityMain extends Activity{

	@Bind(R.id.txtV_result)
	TextView txtV_result;

	@OnClick(R.id.btn_parse)
	public void onParseClick(){
		String json =
				"{\n" +
						"  \"hidden_card\": {\n" +
						"    \"rank\": \"6\",\n" +
						"    \"suit\": \"SPADES\"\n" +
						"  },\n" +
						"  \"visible_cards\": [\n" +
						"    {\n" +
						"      \"rank\": \"4\",\n" +
						"      \"suit\": \"CLUBS\"\n" +
						"    },\n" +
						"    {\n" +
						"      \"rank\": \"A\",\n" +
						"      \"suit\": \"HEARTS\"\n" +
						"    }\n" +
						"  ]\n" +
						"}";

		Moshi                      moshi       = new Moshi.Builder().build();
		JsonAdapter<BlackjackHand> jsonAdapter = moshi.adapter(BlackjackHand.class);
		BlackjackHand              blackjackHand;
		try{
			blackjackHand = jsonAdapter.fromJson(json);
			txtV_result.setText(blackjackHand.toString());
		}
		catch(IOException e){
			e.printStackTrace();
			Toast.makeText(ActivityMain.this, "conversion error", Toast.LENGTH_SHORT).show();
		}
	}

	@OnClick(R.id.btn_parse_custom)
	public void onParseCustomClick(){
		String json = "" // values have been consolidated to one key-pair
				+ "{\n"
				+ "  \"hidden_card\": \"7H\",\n"
				+ "  \"visible_cards\": [\n"
				+ "    \"5D\",\n"
				+ "    \"KS\"\n"
				+ "  ]\n"
				+ "}\n";

		Moshi moshi = new Moshi.Builder()
				.add(new CardAdapter())
				.build();
		JsonAdapter<BlackjackHand> jsonAdapter = moshi.adapter(BlackjackHand.class);
		BlackjackHand              blackjackHand;
		try{
			blackjackHand = jsonAdapter.fromJson(json);
			txtV_result.setText(blackjackHand.toString());
		}
		catch(IOException e){
			e.printStackTrace();
			Toast.makeText(ActivityMain.this, "conversion error", Toast.LENGTH_SHORT).show();
		}
	}

	@OnClick(R.id.btn_serialize)
	public void onSerializeClick(){
		BlackjackHand blackjackHand = new BlackjackHand(
				new Card('1', CLUBS),
				Arrays.asList(new Card('2', DIAMONDS), new Card('8', SPADES)));

		Moshi moshi = new Moshi.Builder().build();
		JsonAdapter<BlackjackHand> jsonAdapter = moshi.adapter(BlackjackHand.class);

		String json;
		try{
			json = jsonAdapter.toJson(blackjackHand);
			txtV_result.setText(json);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}


	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
	}
}









