package com.lyz.implement;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.lyz.myInterface.captcha;
import com.lyz.myInterface.loginCallBack;
import com.lyz.pojos.Urls_String;

public class captchaTool implements captcha {

	@Override
	public void getCaptcha(HttpClient client, loginCallBack callBack) {
		callBack.doGetCaptcha(excuteCaptcha(client));
	}

	private Bitmap excuteCaptcha(HttpClient client) {
		// TODO Auto-generated method stub
		HttpPost post = new HttpPost(Urls_String.CAPTCHA_URL);
		try {
			HttpResponse response = client.execute(post);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				return BitmapFactory.decodeStream(response.getEntity()
						.getContent());
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
