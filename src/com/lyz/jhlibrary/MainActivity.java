package com.lyz.jhlibrary;

import com.lyz.manager.loginControl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView code_Img;
	private EditText userName_View;
	private EditText passWord_View;
	private EditText valCode_View;
	private Button login_Button;

	private loginControl mControl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		initView();
		initFunction();
		getCapthcaImg();
	}

	private void initView() {
		// TODO Auto-generated method stub
		userName_View = (EditText) this.findViewById(R.id.main_userName);
		passWord_View = (EditText) this.findViewById(R.id.main_passWord);
		valCode_View = (EditText) this.findViewById(R.id.main_valCode);
		code_Img = (ImageView) this.findViewById(R.id.main_codeImg);
		login_Button = (Button) this.findViewById(R.id.main_loginButton);
	}

	private void initFunction() {
		code_Img.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getCapthcaImg();
			}
		});

		login_Button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String userName = userName_View.getText().toString();
				String passWord = passWord_View.getText().toString();
				String captcha = valCode_View.getText().toString();

				getLoginResult(userName, passWord, captcha);
			}
		});
	}

	private void getCapthcaImg() {
		if (mControl == null) {
			mControl = new loginControl(this);
		}
		mControl.executeGetCaptcha(code_Img);
	}

	private void getLoginResult(String userName, String passWord, String captcha) {
		if (mControl == null) {
			mControl = new loginControl(this);
		}
		mControl.executeGetLoginResult(userName, passWord, captcha);
	}
}
