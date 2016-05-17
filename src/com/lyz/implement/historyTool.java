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

import com.lyz.myInterface.bookHistory;
import com.lyz.myInterface.inforCallBack;
import com.lyz.pojos.Urls_String;

public class historyTool implements bookHistory {

	@Override
	public void getBookHistory(HttpClient client, inforCallBack callBack,
			String cookie) {
		// TODO Auto-generated method stub
		callBack.doGetBookHistory(executeGetHistory(client, cookie));
	}

	private String executeGetHistory(HttpClient client, String cookie) {
		HttpPost post = new HttpPost(Urls_String.Book_History_URL);
		try {
			// post.setHeader("Cookie", cookie);
			ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("para_string", "all"));

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
