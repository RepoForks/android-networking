package com.nullcognition.logansquare;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.bluelinelabs.logansquare.LoganSquare;
import com.nullcognition.logansquare.models.AnnotationsOnly;
import com.nullcognition.logansquare.models.PrivateFieldsAndAccessors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.nullcognition.logansquare.models.PrivateFieldsAndAccessors.Obj;

public class ActivityMain extends Activity{

	@Bind(R.id.textView)  TextView textView;
	@Bind(R.id.textView2) TextView textView2;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
	}

	@OnClick(R.id.btn_annotation)
	public void jsonToModelAnnotation(){
		textView.setText(AnnotationsOnly.jsonString);

		// both handler and runnable would be leaking memory if long running and activity was closed
		new Handler().postDelayed(new Runnable(){
			@Override public void run(){
				jsonToModel();
			}
		}, 2_000);
	}

	public void jsonToModel(){
		// Parses from inputstream and string, thus no need to convert inputstream to string
		// like wise to outputstream for serialization
		String jsonString = AnnotationsOnly.jsonString;

		AnnotationsOnly myModel = null;
		try{ myModel = LoganSquare.parse(jsonString, AnnotationsOnly.class);}
		catch(IOException e){e.printStackTrace();}
		if(myModel != null){
			textView.setText(myModel.url + " " + myModel.getId() + " " + myModel.getPrivateData());
		}
		else{ Toast.makeText(ActivityMain.this, "myModel null", Toast.LENGTH_SHORT).show();}
	}

	@OnClick(R.id.btn_serialize) public void serialized(){

		PrivateFieldsAndAccessors privateFieldsAndAccessors = new PrivateFieldsAndAccessors();
		privateFieldsAndAccessors.alsoDetected = new ArrayList<>(Arrays.asList(new Obj(), null, new Obj()));
		privateFieldsAndAccessors.setNotIgnoredHasAccessors(99);

		try{ textView2.setText(LoganSquare.serialize(privateFieldsAndAccessors));}
		catch(IOException e){ e.printStackTrace();
			Log.d("SERIALIZE", "serialized logansquare serialized fail");}
	}
}
