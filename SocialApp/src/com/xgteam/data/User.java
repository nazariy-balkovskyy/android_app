package com.xgteam.data;


import com.xgteam.utils.DownloadImageTask;

import android.widget.ImageView;

public class User {
	private int idUser;
	public void setUserId(int id){
		this.idUser=id;
	}
	public int getUserId(){
		return this.idUser;
	}
	public void getUserPicture(ImageView imageBox){
		switch(this.idUser){
			case 1:{
				new DownloadImageTask(imageBox).execute("https://pp.vk.me/c320531/v320531750/2570/0PFIvRp2aho.jpg");
				break;
			}
			case 2:{
				new DownloadImageTask(imageBox).execute("https://pp.vk.me/c419430/v419430658/1486/BL9LQjr2XxY.jpg");
				break;
			}
			default:{
				new DownloadImageTask(imageBox).execute("https://www.lihueitsai.org/wp-content/uploads/2012/08/unknown-member.gif");
				break;
			}
		}
	}
	public String getUserName(){
		switch(this.idUser){
			case 1:{
				return "Andrew Dubytsky";
			}
			case 2:{
				return "Nazar Balkovsky";
			}
			default:{
				return "Guest";
			}
		}
	}
}
