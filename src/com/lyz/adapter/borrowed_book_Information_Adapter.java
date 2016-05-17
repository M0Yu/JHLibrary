package com.lyz.adapter;

import java.util.List;

import com.lyz.jhlibrary.R;
import com.lyz.pojos.user_borrowed_book_Information;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

@SuppressLint("InflateParams")
public class borrowed_book_Information_Adapter extends BaseAdapter {

	private Context mContext;
	private List<user_borrowed_book_Information> mData;

	public borrowed_book_Information_Adapter(Context context,
			List<user_borrowed_book_Information> data) {
		// TODO Auto-generated constructor stub
		this.mContext = context;
		this.mData = data;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mData.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mData.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		viewHolder mHolder;
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.cell_borrowed_book_information, null, false);
			mHolder = new viewHolder();

			mHolder.codeView = (TextView) convertView
					.findViewById(R.id.infor_codeView);
			mHolder.bookNameView = (TextView) convertView
					.findViewById(R.id.infor_bookNameView);
			mHolder.borrowedDateView = (TextView) convertView
					.findViewById(R.id.infor_borrowedDateView);
			mHolder.returnedDateView = (TextView) convertView
					.findViewById(R.id.infor_returnedDateView);

			convertView.setTag(mHolder);
		} else {
			mHolder = (viewHolder) convertView.getTag();
		}

		mHolder.codeView.setText(mData.get(position).getCode());
		mHolder.bookNameView.setText(mData.get(position).getBookName());
		mHolder.borrowedDateView.setText(mData.get(position).getBorrowedDate());
		mHolder.returnedDateView.setText(mData.get(position).getReturnedDate());

		return convertView;
	}

	private class viewHolder {
		private TextView codeView;
		private TextView bookNameView;
		private TextView borrowedDateView;
		private TextView returnedDateView;
	}
}
