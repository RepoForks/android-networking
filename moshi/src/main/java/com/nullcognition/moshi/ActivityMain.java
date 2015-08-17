package com.nullcognition.moshi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.nullcognition.moshi.models.BlackjackHand;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityMain extends Activity{

	@Bind(R.id.txtV_parsedJson)
	TextView parsedJson;

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
			parsedJson.setText(blackjackHand.toString());
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
			parsedJson.setText(blackjackHand.toString());
		}
		catch(IOException e){
			e.printStackTrace();
			Toast.makeText(ActivityMain.this, "conversion error", Toast.LENGTH_SHORT).show();
		}
	}


	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
	}
}









