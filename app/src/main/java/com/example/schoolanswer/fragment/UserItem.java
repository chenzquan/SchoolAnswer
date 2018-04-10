package com.example.schoolanswer.fragment;

public class UserItem {

	private boolean isShowTopDivider;
	private int leftImg;
	private String subhead;


	public UserItem(boolean isShowTopDivider, int leftImg, String subhead, String caption) {
		this.isShowTopDivider = isShowTopDivider;
		this.leftImg = leftImg;
		this.subhead = subhead;

	}


	public boolean isShowTopDivider() {
		return isShowTopDivider;
	}

	public void setShowTopDivider(boolean isShowTopDivider) {
		this.isShowTopDivider = isShowTopDivider;
	}

	public int getLeftImg() {
		return leftImg;
	}

	public void setLeftImg(int leftImg) {
		this.leftImg = leftImg;
	}

	public String getSubhead() {
		return subhead;
	}

	public void setSubhead(String subhead) {
		this.subhead = subhead;
	}



}
