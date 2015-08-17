package com.nullcognition.logansquare;

import android.app.Activity;
import android.os.Bundle;

import com.bluelinelabs.logansquare.LoganSquare;
import com.nullcognition.logansquare.models.AnnotationsOnly;

import java.io.IOException;

import butterknife.ButterKnife;

public class ActivityMain extends Activity{

	{
		// Parses from inputstream and string, thus no need to convert inputstream to string
		// like wise to outputstream for serialization
		String jsonString = "";

		try{ AnnotationsOnly myModel = LoganSquare.parse(jsonString, AnnotationsOnly.class);}
		catch(IOException e){e.printStackTrace();}
	}

	/**
	 * ## Large headline
	 * ### Smaller headline
	 *
	 * This is a comment that contains `code` parts.
	 *
	 * Code blocks:
	 *
	 * ```java
	 * int foo = 42;
	 * System.out.println(foo);
	 * ```
	 *
	 * Quote blocks:
	 *
	 * > This is a block quote
	 *
	 * lists:
	 *
	 * - first item
	 * - second item
	 * - third item
	 *
	 * This is a text that contains an [external link][link].
	 *
	 * [link]: http://external-link.com/
	 *
	 * @param id the user id
	 * @return the user object with the passed `id` or `null` if no user with this `id` is found
	 */
	public int meth(int id){return id;}

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
	}
}
