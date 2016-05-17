package com.lyz.manager;

import org.apache.http.client.HttpClient;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.lyz.myInterface.bookHistory;
import com.lyz.myInterface.captcha;
import com.lyz.myInterface.inforCallBack;
import com.lyz.myInterface.loginCallBack;
import com.lyz.myInterface.loginCheck;

public class mainFactory {
	private Context mContext;
	private static HttpClient client;

	private captcha mCaptcha;
	private loginCheck mLogin;
	private bookHistory mHistory;
	private String cookie;

	public mainFactory(Context context) {
		super();
		// TODO Auto-generated constructor stub
		this.mContext = context;
		if (client == null) {
			client = new DefaultHttpClient();
		}
	}

	public void setCaptchaTool(captcha c) {
		mCaptcha = c;
	}

	public void getCaptchaBitmap(loginCallBack callBack) {
		mCaptcha.getCaptcha(client, callBack);
	}

	public void setLoginTool(loginCheck l) {
		mLogin = l;
	}

	public void getLoginResultString(loginCallBack callBack, String userName,
			String passWord, String captcha) {
		mLogin.getLoginResult(client, callBack, userName, passWord, captcha);
	}

	public void setHistoryTool(bookHistory h) {
		mHistory = h;
	}

	public void getBookHistory(inforCallBack callBack) {
		mHistory.getBookHistory(client, callBack, cookie);
	}

}
