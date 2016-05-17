package com.lyz.myInterface;

import org.apache.http.client.HttpClient;

public interface loginCheck {
	public void getLoginResult(HttpClient client, loginCallBack callBack,
			String userName, String passWord, String captcha);
}
