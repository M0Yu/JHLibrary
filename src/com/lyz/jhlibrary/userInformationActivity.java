package com.lyz.jhlibrary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class userInformationActivity extends Activity {

	private TextView userNameView;
	private TextView certNumView;
	private TextView maxlendingNumView;
	private TextView identityTypeView;
	private TextView sexView;
	private TextView debtView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_userinfor);

		initView();
		doGetIntent();
	}

	private void initView() {
		// TODO Auto-generated method stub
		userNameView = (TextView) this.findViewById(R.id.user_NameView);
		certNumView = (TextView) this.findViewById(R.id.user_CertView);
		maxlendingNumView = (TextView) this
				.findViewById(R.id.user_maxlendingView);
		identityTypeView = (TextView) this.findViewById(R.id.user_IdentityView);
		sexView = (TextView) this.findViewById(R.id.user_SexView);
		debtView = (TextView) this.findViewById(R.id.user_DebtView);
	}

	private void doGetIntent() {
		Intent intent = getIntent();
		if (intent.getFlags() == 3) {
			userNameView.setText(intent.getStringExtra("userName"));
			certNumView.setText(intent.getStringExtra("certNum"));
			maxlendingNumView.setText(intent.getStringExtra("maxlendingNum"));
			identityTypeView.setText(intent.getStringExtra("identityType"));
			sexView.setText(intent.getStringExtra("sex"));
			debtView.setText(intent.getStringExtra("debt"));
		} else {
			this.finish();
		}
	}
}
