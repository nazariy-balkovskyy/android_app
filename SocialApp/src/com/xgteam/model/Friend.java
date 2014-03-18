package com.xgteam.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Friend {
	private String accessToken;
	public Friend(){
		this.accessToken=User.accessToken;
	}
	public List<FriendItem> get() throws Exception{
		JSONObject jObject = Request
				.forge("http://mob.xgenteam.com/friends/get.json?access_token="
						+ this.accessToken);
		try {
			// String errorCode = jObject.getString("error_code");
			if (!jObject.isNull("error_code")) {
				String errorMessage = jObject.getString("message");
				throw new Exception(errorMessage);
			} else {
				List<FriendItem> friends=new ArrayList<FriendItem>();
				JSONArray jArray = jObject.getJSONArray("friends");
				int jArraySize=jArray.length();
				for(int i=0;i<jArraySize;i++)
				{
					JSONObject element = (JSONObject) jArray.get(i);
					FriendItem fItem=new FriendItem();
					fItem.setFirstName(element.getString("first_name"));
					fItem.setLastName(element.getString("last_name"));
					int onlineState=element.getInt("online_state");
					if(onlineState==1) fItem.setOnline(true);
					else fItem.setOnline(false);
					fItem.setUserId(element.getInt("id_user"));
					friends.add(fItem);
				}
				return friends;
			}
		} catch (JSONException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}
