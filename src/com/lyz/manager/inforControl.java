package com.lyz.manager;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.ListView;

import com.lyz.adapter.borrowed_book_Information_Adapter;
import com.lyz.implement.historyTool;
import com.lyz.jhlibrary.userInformationActivity;
import com.lyz.myInterface.inforCallBack;
import com.lyz.pojos.user_Information;
import com.lyz.pojos.user_borrowed_book_Information;

public class inforControl implements inforCallBack {

	private Context mContext;
	private ListView bookHListView;

	private inforCallBack iCallBack;
	private mainFactory mFactory;

	public inforControl(Context mContext) {
		super();
		// TODO Auto-generated constructor stub
		this.mContext = mContext;
		iCallBack = this;
	}

	/* ======================获取书籍借阅历史的操作 begin======================= */
	public void executeGetBookHistory(ListView view) {
		if (bookHListView == null) {
			bookHListView = view;
		}
		if (mFactory == null) {
			mFactory = new mainFactory(mContext);
		}
		mFactory.setHistoryTool(new historyTool());
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				mFactory.getBookHistory(iCallBack);
			}
		}).start();
	}

	@Override
	public void doGetBookHistory(Object... objects) {
		// TODO Auto-generated method stub
		Message msg = new Message();
		msg.obj = objects[0];
		mHandler.sendMessage(msg);
	}

	/* ======================获取书籍借阅历史的操作 end======================= */

	@Override
	public void doGetBookList(Object... objects) {
		// TODO Auto-generated method stub

	}

	public void doCheckUserInformation(user_Information infor) {
		Intent intent = new Intent();
		intent.setFlags(3);
		intent.putExtra("userName", infor.getUserName());
		intent.putExtra("certNum", infor.getCertNum());
		intent.putExtra("maxlendingNum", infor.getMaxlendingNum());
		intent.putExtra("identityType", infor.getIdentityType());
		intent.putExtra("sex", infor.getSex());
		intent.putExtra("debt", infor.getDebt());

		intent.setClass(mContext, userInformationActivity.class);
		mContext.startActivity(intent);
	}

	@SuppressLint("HandlerLeak")
	private Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			String result = msg.obj.toString();
			ArrayList<user_borrowed_book_Information> book_Informations = AnylasisTool
					.borrowedBookInformation(result);
			borrowed_book_Information_Adapter mAdapter = new borrowed_book_Information_Adapter(
					mContext, book_Informations);
			bookHListView.setAdapter(mAdapter);
		}

	};
}
