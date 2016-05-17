package com.lyz.implement;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.lyz.myInterface.loginCallBack;
import com.lyz.myInterface.loginCheck;
import com.lyz.pojos.Urls_String;

public class loginTool implements loginCheck {

	@Override
	public void getLoginResult(HttpClient client, loginCallBack callBack,
			String userName, String passWord, String captcha) {
		// TODO Auto-generated method stub
		callBack.doGetLoginResult(executeGetLoginResult(client, userName,
				passWord, captcha));
	}

	private String executeGetLoginResult(HttpClient client, String userName,
			String passWord, String captcha) {
		HttpPost post = new HttpPost(Urls_String.LOGIN_URL);
		try {
			ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("number", userName));
			params.add(new BasicNameValuePair("passwd", passWord));
			params.add(new BasicNameValuePair("captcha", captcha));
			params.add(new BasicNameValuePair("select", "cert_no"));
			params.add(new BasicNameValuePair("returnUrl", ""));
			post.setEntity(new UrlEncodedFormEntity(params));
			HttpResponse response = client.execute(post);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				return EntityUtils.toString(response.getEntity(), "utf-8");
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
