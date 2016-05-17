package com.lyz.manager;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.content.Context;

import com.lyz.pojos.user_Information;
import com.lyz.pojos.user_borrowed_book_Information;

public class AnylasisTool {

	/* ======================获取用户信息的操作 begin======================= */
	public static user_Information userInformationAnyliasis(Context mContext,
			String content) {
		user_Information information = new user_Information();

		Document doc = Jsoup.parse(content);
		Element div = doc.getElementById("mylib_info");
		Elements tds = div.getElementsByTag("td");
		for (Element e : tds) {
			if (e.text().contains("姓名：")) {
				String userName = e.text().substring(3);
				information.setUserName(userName);
			}
			if (e.text().contains("证件号：")) {
				String certNum = e.text().substring(4);
				information.setCertNum(certNum);
				;
			}
			if (e.text().contains("最大可借图书：")) {
				String maxlendingNum = e.text().substring(7);
				information.setMaxlendingNum(maxlendingNum);
			}
			if (e.text().contains("读者类型：")) {
				String identityType = e.text().substring(5);
				information.setIdentityType(identityType);
			}
			if (e.text().contains("欠款金额：")) {
				String debt = e.text().substring(5);
				information.setDebt(debt);
			}
			if (e.text().contains("性别：")) {
				String sex = e.text().substring(3);
				information.setSex(sex);
			}
		}
		return information;
	}

	/* ======================获取用户信息的操作 end======================= */

	public static ArrayList<user_borrowed_book_Information> borrowedBookInformation(
			String content) {
		ArrayList<user_borrowed_book_Information> list = new ArrayList<user_borrowed_book_Information>();

		Document doc = Jsoup.parse(content);
		Elements tr = doc.select("tr");

		user_borrowed_book_Information book_Information = null;
		for (int i = 1; i < tr.size(); i++) {

			book_Information = new user_borrowed_book_Information();
			Elements td = tr.get(i).select("td");

			String code = td.get(1).text();
			book_Information.setCode(code);

			String bookName = td.get(2).text();
			book_Information.setBookName(bookName);

			String borrowedDate = td.get(4).text();
			book_Information.setBorrowedDate(borrowedDate);

			String returnedDate = td.get(5).text();
			book_Information.setReturnedDate(returnedDate);

			list.add(book_Information);
		}

		return list;
	}
}
