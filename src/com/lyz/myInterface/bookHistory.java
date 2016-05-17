package com.lyz.myInterface;

import org.apache.http.client.HttpClient;

public interface bookHistory {
	public void getBookHistory(HttpClient client, inforCallBack callBack,String cookie);
}
