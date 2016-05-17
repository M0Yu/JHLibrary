package com.lyz.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.Toast;

import com.lyz.implement.captchaTool;
import com.lyz.implement.loginTool;
import com.lyz.jhlibrary.doLoginActivity;
import com.lyz.myInterface.loginCallBack;

public class loginControl implements loginCallBack {

	private ImageView mCaptchaView;
	private Context mContext;

	private loginCallBack iCallBack;
	private mainFactory mFactory;

	public loginControl(Context mContext) {
		super();
		// TODO Auto-generated constructor stub
		this.mContext = mContext;
		this.iCallBack = this;
	}

	/* ======================��ȡ��֤��Ĳ��� begin======================= */
	public void executeGetCaptcha(ImageView captchaView) {
		if (mCaptchaView == null) {
			mCaptchaView = captchaView;
		}
		if (mFactory == null) {
			mFactory = new mainFactory(mContext);
		}
		mFactory.setCaptchaTool(new captchaTool());
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				mFactory.getCaptchaBitmap(iCallBack);
			}
		}).start();
	}

	@Override
	public void doGetCaptcha(Object... objects) {
		// TODO Auto-generated method stub
		Message msg = new Message();
		msg.what = 1;
		msg.obj = objects[0];
		mHandler.sendMessage(msg);
	}

	/* ======================��ȡ��֤��Ĳ��� end======================= */

	/* ======================��ȡ��¼����Ĳ��� begin======================= */
	public void executeGetLoginResult(final String userName,
			final String passWord, final String captcha) {
		if (mFactory == null) {
			mFactory = new mainFactory(mContext);
		}
		mFactory.setLoginTool(new loginTool());
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				mFactory.getLoginResultString(iCallBack, userName, passWord,
						captcha);
				;
			}
		}).start();
	}

	@Override
	public void doGetLoginResult(Object... objects) {
		// TODO Auto-generated method stub
		Message msg = new Message();
		msg.what = 2;
		msg.obj = objects[0];
		mHandler.sendMessage(msg);
	}

	/* ======================��ȡ��¼����Ĳ��� end======================= */
	@SuppressLint("HandlerLeak")
	private Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			if (msg.what == 1) {
				mCaptchaView.setImageBitmap((Bitmap) msg.obj);
			}
			if (msg.what == 2) {
				String result = msg.obj.toString();
				if (result.contains("��������ȷ�Ķ���֤����")
						|| result.contains("��֤�����(wrong check code)")
						|| result.contains("�Բ�������������ʵ��")) {
					Toast.makeText(mContext, "��¼ʧ�ܣ�������", Toast.LENGTH_SHORT)
							.show();
				} else {
					Intent intent = new Intent();
					// mFactory.getCookie();
					intent.setFlags(1);
					intent.setClass(mContext, doLoginActivity.class);
					intent.putExtra("result", result);
					mContext.startActivity(intent);
				}
			}
		}

	};
}
