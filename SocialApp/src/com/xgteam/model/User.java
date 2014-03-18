package com.xgteam.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class User {
	public static String accessToken;
	private int id;
	private String firstName;
	private String lastName;
	private boolean onlineState;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public boolean getOnlineState() {
		return this.onlineState;
	}
	public String getPicture(){
		return "https://pp.vk.me/c320531/v320531750/2570/0PFIvRp2aho.jpg";
	}
	public boolean signin(String login, String password) throws Exception {
		JSONObject jObject = Request
				.forge("http://mob.xgenteam.com/users/login.json?login="
						+ login + "&password=" + password);
		try {
			// String errorCode = jObject.getString("error_code");
			if (!jObject.isNull("error_code")) {
				String errorMessage = jObject.getString("message");
				throw new Exception(errorMessage);
			} else {
				User.accessToken = jObject.getString("access_token");
				User user = this.get();
				this.id = user.id;
				this.firstName = user.firstName;
				this.lastName = user.lastName;
				this.onlineState = user.onlineState;
				return true;
			}
		} catch (JSONException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public boolean register(String login, String password, String firstName,
			String lastName) throws Exception {
		JSONObject jObject = Request
				.forge("http://mob.xgenteam.com/users/register.json?login="
						+ login + "&password=" + password + "&first_name="
						+ firstName + "&lastName=" + lastName);
		try {
			// String errorCode = jObject.getString("error_code");
			String errorMessage = jObject.getString("message");
			throw new Exception(errorMessage);
		} catch (JSONException e) {
			return true;
		}
	}

	public List<User> get(List<Integer> uids) throws Exception {
		int uidsSize = uids.size();
		String uidsStr = "users=";
		for (int i = 0; i < uidsSize; i++) {
			uidsStr += uids.get(i);
			if (i < uidsSize - 1) {
				uidsStr += ",";
			}
		}
		JSONObject jObject = Request
				.forge("http://mob.xgenteam.com/users/get.json?" + uidsStr
						+ "&access_token=" + User.accessToken);
		try {
			// String errorCode = jObject.getString("error_code");
			if (!jObject.isNull("error_code")) {
				String errorMessage = jObject.getString("message");
				throw new Exception(errorMessage);
			} else {
				List<User> users = new ArrayList<User>();
				JSONArray jArray = jObject.getJSONArray("users");
				int jArraySize = jArray.length();
				for (int i = 0; i < jArraySize; i++) {
					JSONObject element = (JSONObject) jArray.get(i);
					User user = new User();
					user.id = element.getInt("id_user");
					user.firstName = element.getString("first_name");
					user.lastName = element.getString("last_name");
					user.onlineState = element.getInt("online_state") > 0 ? true
							: false;
					users.add(user);
				}
				return users;
			}
		} catch (JSONException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public User get() throws Exception {
		JSONObject jObject = Request
				.forge("http://mob.xgenteam.com/users/get.json?access_token="
						+ User.accessToken);
		try {
			// String errorCode = jObject.getString("error_code");
			if (!jObject.isNull("error_code")) {
				String errorMessage = jObject.getString("message");
				throw new Exception(errorMessage);
			} else {
				JSONArray jArray = jObject.getJSONArray("users");
				JSONObject element = (JSONObject) jArray.get(0);
				User user = new User();
				user.id = element.getInt("id_user");
				user.firstName = element.getString("first_name");
				user.lastName = element.getString("last_name");
				user.onlineState = element.getInt("online_state") > 0 ? true
						: false;
				return user;
			}
		} catch (JSONException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}
