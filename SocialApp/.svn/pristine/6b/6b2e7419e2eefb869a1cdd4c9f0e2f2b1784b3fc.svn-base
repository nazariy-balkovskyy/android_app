package com.xgteam.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Group {
	private String accessToken;
	public Group(){
		this.accessToken=User.accessToken;
	}
	public List<GroupItem> get() throws Exception{
		JSONObject jObject = Request
				.forge("http://mob.xgenteam.com/groups/get.json?access_token="
						+ this.accessToken);
		try {
			// String errorCode = jObject.getString("error_code");
			if (!jObject.isNull("error_code")) {
				String errorMessage = jObject.getString("message");
				throw new Exception(errorMessage);
			} else {
				List<GroupItem> groups=new ArrayList<GroupItem>();
				JSONArray jArray = jObject.getJSONArray("groups");
				int jArraySize=jArray.length();
				for(int i=0;i<jArraySize;i++)
				{
					JSONObject element = (JSONObject) jArray.get(i);
					GroupItem gItem=new GroupItem();
					gItem.setGroupId(element.getInt("id_group"));
					gItem.setName(element.getString("name"));
					User user=new User();
					int uid=element.getInt("id_user");
					List<Integer> uids=new ArrayList<Integer>();
					uids.add(uid);
					user=user.get(uids).get(0);
					gItem.setOwner(user);
					
					groups.add(gItem);
				}
				return groups;
			}
		} catch (JSONException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}
