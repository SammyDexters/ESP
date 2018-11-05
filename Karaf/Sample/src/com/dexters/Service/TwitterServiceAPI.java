package com.dexters.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

public class TwitterServiceAPI {
	
	OAuthRequest authRequest=new OAuthRequest();
	
	/*@Author
	Sowndhariya Nandarajkumar*/
	public HashMap<String, Object> GetfollowersList(String value) {
		List<String> ResponseList = new ArrayList<String>();
		HashMap<String, Object> viewResult = new HashMap<>();
		try {
			String twetURL ="https://api.twitter.com/1.1/friends/list.json";
			twetURL = twetURL + "?screen_name=" + value; 
			String displayText = null;
			HttpResponse httprep = authRequest.executeHttpGet(twetURL);
			if (200 == httprep.getStatusLine().getStatusCode()) {
				System.out.println("200 OK");
				JSONObject obj = new JSONObject(EntityUtils.toString(httprep.getEntity()));
				JSONArray ar = (JSONArray) obj.get("users");
				for (int i = 0; i < ar.length() && i < 10; i++) {
					JSONObject object = (JSONObject) ar.get(i);
					displayText = (String) object.get("name");
					viewResult.put("Succuss", displayText);
					System.out.println("-------------->>> "+viewResult.toString());
					}
				
			} else {
				viewResult.put("UnSuccussful", "Error!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewResult;
	}
	
	
	public List<String> GetfollowingList(String value) {
		String output="";
		List<String> ResponseList = new ArrayList<String>();
		try {
		String twetURL ="https://api.twitter.com/1.1/followers/list.json";
			twetURL = twetURL + "?screen_name=" + value; 
			String displayText=null;
			HttpResponse httprep = authRequest.executeHttpGet(twetURL);
			if (200 == httprep.getStatusLine().getStatusCode()) {
				System.out.println("200 OK");
				JSONObject obj = new JSONObject(EntityUtils.toString(httprep.getEntity()));
				JSONArray ar = (JSONArray) obj.get("users");
				for (int i = 0; i < ar.length() && i < 10; i++) {
					JSONObject object = (JSONObject) ar.get(i);
					 displayText = (String) object.get("name");
					 ResponseList.add(displayText);
						System.out.println("-------------->>> "+ResponseList.toString());
					}
				
			} else {
				ResponseList.add(" Unsuccessful");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseList;
	}
	
	
public List<Integer> GetfriendsIds(String value) {
		
		List<Integer> ResponseList = new ArrayList<Integer>();
		try {
		String twetURL ="https://api.twitter.com/1.1/friends/ids.json";
			twetURL = twetURL + "?screen_name=" + value; 

			HttpResponse httprep = authRequest.executeHttpGet(twetURL);
			if (200 == httprep.getStatusLine().getStatusCode()) {
				System.out.println("200 OK");
				JSONObject obj = new JSONObject(EntityUtils.toString(httprep.getEntity()));
				JSONArray ar = (JSONArray) obj.get("ids");
				for (int i = 0; i < ar.length() && i < 10; i++) {
					int object1=ar.getInt(i);
					System.out.println(object1);
					/*JSONObject object = (JSONObject) ar.get(i);
					String displayText = (String) object.get("ids");*/
					ResponseList.add(object1);
					System.out.println("-------------->>> "+ResponseList.toString());
				}
			} else {
				ResponseList.add(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseList;
		
	}

public List<Integer> GetffollowerssIds(String value) {
	
	List<Integer> ResponseList = new ArrayList<Integer>();
	try {
	/*	Properties properties = getProperties();*/
		String twetURL ="https://api.twitter.com/1.1/followers/ids.json";
		twetURL = twetURL + "?screen_name=" + value; 

		HttpResponse httprep = authRequest.executeHttpGet(twetURL);
		if (200 == httprep.getStatusLine().getStatusCode()) {
			System.out.println("200 OK");
			JSONObject obj = new JSONObject(EntityUtils.toString(httprep.getEntity()));
			JSONArray ar = (JSONArray) obj.get("ids");
			for (int i = 0; i < ar.length() && i < 10; i++) {
				int object1=ar.getInt(i);
				System.out.println(object1);
				/*JSONObject object = (JSONObject) ar.get(i);
				String displayText = (String) object.get("ids");*/
				ResponseList.add(object1);
				System.out.println("-------------->>> "+ResponseList.toString());
			}
		} else {
			ResponseList.add(0);
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	return ResponseList;
	
}


public List<String> GetTrendPlace() {
	List<String> List = new ArrayList<String>();
	try {
		System.out.println("Heloooo");
		String twetURL = "https://api.twitter.com/1.1/trends/available.json";

		HttpResponse httprep = authRequest.executeHttpGet(twetURL);

		if (200 == httprep.getStatusLine().getStatusCode()) {
			System.out.println("Heloooo0000");
			JSONArray ar = new JSONArray(EntityUtils.toString(httprep.getEntity()));
			for (int i = 0; i < ar.length() && i < 10; i++) {
				JSONObject object = (JSONObject) ar.get(i);
				String displayText = (String) object.get("url")+":"+(String) object.get("country");
				List.add(displayText);
			}
			System.out.println("--------------------->>>"+List);
		}else{
			List.add("Unsusscuful");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return List;
}


public List<String> GetBlockList(String value) {
	List<String> List = new ArrayList<String>();
	try {
		System.out.println("Heloooo");
		String twetURL = "https://api.twitter.com/1.1/blocks/list.json";
		twetURL = twetURL + "?screen_name=" + value;
		HttpResponse httprep =authRequest.executeHttpGet(twetURL);

		if (200 == httprep.getStatusLine().getStatusCode()) {
			System.out.println("Heloooo0000");
			JSONObject obj = new JSONObject(EntityUtils.toString(httprep.getEntity()));
			JSONArray ar = (JSONArray) obj.get("users");
			for (int i = 0; i < ar.length() && i < 10; i++) {
				JSONObject object = (JSONObject) ar.get(i);
				String displayText = (String) object.get("name");
				List.add(displayText);
				//System.out.println("-------------->>> "+List.toString());
			}
			System.out.println("--------------------->>>"+List);
		}else{
			List.add("Unsusscuful");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return List;
}


public List<String> GetUserSuggestion(String value) {
	List<String> List = new ArrayList<String>();
	try {
		System.out.println("Heloooo");
		String twetURL = "https://api.twitter.com/1.1/users/suggestions.json";
		twetURL = twetURL + "?screen_name=" + value;
		HttpResponse httprep =authRequest.executeHttpGet(twetURL);

		if (200 == httprep.getStatusLine().getStatusCode()) {
			JSONArray ar = new JSONArray(EntityUtils.toString(httprep.getEntity()));
			for (int i = 0; i < ar.length() && i < 10; i++) {
				JSONObject object = (JSONObject) ar.get(i);
				String displayText = (String) object.get("name");
				List.add(displayText);
			}
			System.out.println("--------------------->>>"+List);
		}else{
			List.add("Unsusscuful");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return List;
}

public List<String> GetfavoriteList(String value) {
	List<String> List = new ArrayList<String>();
	try {
		System.out.println("Heloooo");
		String twetURL = "https://api.twitter.com/1.1/favorites/list.json";
		twetURL = twetURL + "?screen_name=" + value;
		HttpResponse httprep =authRequest.executeHttpGet(twetURL);

		if (200 == httprep.getStatusLine().getStatusCode()) {
			JSONArray ar = new JSONArray(EntityUtils.toString(httprep.getEntity()));
			for (int i = 0; i < ar.length() && i < 10; i++) {
				JSONObject object = (JSONObject) ar.get(i);
				String displayText = (String) object.get("text");
				List.add(displayText);
			}
			System.out.println("--------------------->>>"+List);
		}else{
			List.add("Unsusscuful");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return List;
}


public static void main(String arg[]){
	TwitterServiceAPI api=new TwitterServiceAPI();
	api.GetfollowersList("SoundAmtha");
}

}
