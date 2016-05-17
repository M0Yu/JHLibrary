package com.lyz.myInterface;

import org.apache.http.client.HttpClient;

public interface captcha {
	public void getCaptcha(HttpClient client, loginCallBack callBack);
}
