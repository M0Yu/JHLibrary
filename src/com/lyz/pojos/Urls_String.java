package com.lyz.pojos;

public class Urls_String {
	// 登录页面的验证码网址
	public static final String CAPTCHA_URL = "http://opac.lib.jhun.edu.cn:8080/reader/captcha.php";

	// 请求登录的网址
	public static final String LOGIN_URL = "http://opac.lib.jhun.edu.cn:8080/reader/redr_verify.php";

	// 借阅书记的历史记录网址（post: para_string="all"）
	public static final String Book_History_URL = "http://opac.lib.jhun.edu.cn:8080/reader/book_hist.php";

}
