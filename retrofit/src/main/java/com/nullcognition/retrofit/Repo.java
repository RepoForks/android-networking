package com.nullcognition.retrofit;
// ersin 22/09/15 Copyright (c) 2015+ All rights reserved.


public class Repo{

	public long   id;
	public String name;
	public String url;

	public Repo(){}

	private Repo(long id, String name, String url){
		this.id = id;
		this.name = name;
		this.url = url;
	}
}
