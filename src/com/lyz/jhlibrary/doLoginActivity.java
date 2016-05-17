package com.lyz.jhlibrary;

import com.lyz.manager.AnylasisTool;
import com.lyz.manager.inforControl;
import com.lyz.manager.mainFactory;
import com.lyz.pojos.user_Information;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class doLoginActivity extends Activity {

	private ListView historyListView;
	private Button backButton;
	private ImageButton userInforButton;

	private user_Information information;
	private inforControl mControl;
	private mainFactory mFactory;
	private boolean isLogin = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_do_login);

		initView();
		doGetIntent();
		initFunction();
	}

	private void initView() {
		// TODO Auto-generated method stub
		historyListView = (ListView) this.findViewById(R.id.infor_bookListView);
		backButton = (Button) this.findViewById(R.id.infor_back);
		userInforButton = (ImageButton) this.findViewById(R.id.infor_user);
	}

	private void initFunction() {
		backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				doLoginActivity.this.finish();
			}
		});

		userInforButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (isLogin) {
					mControl.doCheckUserInformation(information);
				}
			}
		});
	}

	private void doGetIntent() {
		Intent intent = getIntent();
		if (intent.getFlags() == 1) {
			String result = intent.getStringExtra("result");
			information = AnylasisTool.userInformationAnyliasis(this, result);

			mControl = new inforControl(this);
			mControl.executeGetBookHistory(historyListView);
			isLogin = true;
		}

		if (intent.getFlags() == 2) {
			isLogin = false;
		}
	}
}
