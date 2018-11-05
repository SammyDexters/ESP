package com.dexters.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dexters.Service.OAuthRequest;
import com.dexters.Service.TwitterServiceAPI;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

/*@author Sowndhariya Nandarajkumar*/

@Controller
public class BaseController {
	
	TwitterServiceAPI twitterserviceAPI =new TwitterServiceAPI();
	OAuthRequest authRequest=new OAuthRequest();
	

@RequestMapping(value = "/TweetStatus.htm" ,method = RequestMethod.POST,headers = "Accept=*/*")
public ModelAndView emailGatewayMethod(
		@RequestBody(required = false) MultiValueMap<String, Object> formData,
		@RequestParam(value = "Status", required = true) String Status, HttpServletRequest request) {
	HashMap<String, Object> viewResult = new HashMap<>();
	System.out.println(Status);
	twitterserviceAPI.GetfollowersList(Status);
	
	return new ModelAndView("index", viewResult);

}

@SuppressWarnings("unchecked")
@RequestMapping(value = "/GetfollowersList.htm" ,method = RequestMethod.POST,headers = "Accept=*/*")
public ModelAndView GetfollowersList(
		@RequestBody(required = false) MultiValueMap<String, Object> formData,
		@RequestParam(value = "name", required = true) String name, HttpServletRequest request) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, IOException, ParseException, JSONException {
	HashMap<String, Object> viewResult = new HashMap<>();
	viewResult.put("Hai", twitterserviceAPI.GetfollowersList(name));
	return new ModelAndView("index", viewResult);

}

@RequestMapping(value = "/GetfollowingList.htm" ,method = RequestMethod.POST,headers = "Accept=*/*")
public ModelAndView GetfollowingList(
		@RequestBody(required = false) MultiValueMap<String, Object> formData,
		@RequestParam(value = "name", required = true) String name, HttpServletRequest request) {
	HashMap<String, Object> viewResult = new HashMap<>();
	System.out.println(twitterserviceAPI.GetfollowingList(name).get(0));
    viewResult.put("Hai", twitterserviceAPI.GetfollowingList(name).get(0));
	return new ModelAndView("index", viewResult);

}


@RequestMapping(value = "/GetfriendsIds.htm" ,method = RequestMethod.POST,headers = "Accept=*/*")
public ModelAndView GetfriendsIds(
		@RequestBody(required = false) MultiValueMap<String, Object> formData,
		@RequestParam(value = "name", required = true) String name, HttpServletRequest request) {
	HashMap<String, Object> viewResult = new HashMap<>();
	System.out.println(name);
	twitterserviceAPI.GetfriendsIds(name);
	viewResult.put("friendsIds",twitterserviceAPI.GetfriendsIds(name).get(0));
	//viewResult.put("key","value");
	return new ModelAndView("index",viewResult);

}



@RequestMapping(value = "/GetfavoriteList.htm" ,method = RequestMethod.POST,headers = "Accept=*/*")
public ModelAndView GetfavoriteList(
		@RequestBody(required = false) MultiValueMap<String, Object> formData,
		@RequestParam(value = "name", required = true) String name, HttpServletRequest request) {
	HashMap<String, Object> viewResult = new HashMap<>();
	System.out.println(name);
	twitterserviceAPI.GetfavoriteList(name);
	viewResult.put("favoriteList",twitterserviceAPI.GetfavoriteList(name).get(0));
	return new ModelAndView("index", viewResult);

}

@RequestMapping(value = "/GetfollowersIds.htm" ,method = RequestMethod.POST,headers = "Accept=*/*")
public ModelAndView GetfollowersIds(
		@RequestBody(required = false) MultiValueMap<String, Object> formData,
		@RequestParam(value = "name", required = true) String name, HttpServletRequest request) {
	HashMap<String, Object> viewResult = new HashMap<>();
	System.out.println(name);
	twitterserviceAPI.GetffollowerssIds(name);
	viewResult.put("followersIds",twitterserviceAPI.GetfavoriteList(name).get(0));
	return new ModelAndView("index", viewResult);

}


@RequestMapping(value = "/GetTrendPlace.htm" ,method = RequestMethod.POST,headers = "Accept=*/*")
public ModelAndView GetTrendPlace(
		@RequestBody(required = false) MultiValueMap<String, Object> formData,
		@RequestParam(value = "Status", required = false) String Status, HttpServletRequest request) {
	HashMap<String, Object> viewResult = new HashMap<>();
	//System.out.println(Status);
	twitterserviceAPI.GetTrendPlace();
	viewResult.put("TrendPlace",twitterserviceAPI.GetTrendPlace().get(0));
	return new ModelAndView("index", viewResult);

}


@RequestMapping(value = "/GetBlockList.htm" ,method = RequestMethod.POST,headers = "Accept=*/*")
public ModelAndView GetBlockList(
		@RequestBody(required = false) MultiValueMap<String, Object> formData,
		@RequestParam(value = "name", required = false) String name, HttpServletRequest request) {
	HashMap<String, Object> viewResult = new HashMap<>();
	//System.out.println(Status);
	twitterserviceAPI.GetBlockList(name);
	viewResult.put("TrendPlace",twitterserviceAPI.GetBlockList(name).get(0));
	return new ModelAndView("index", viewResult);

}


@RequestMapping(value = "/GetUserSuggestion.htm" ,method = RequestMethod.POST,headers = "Accept=*/*")
public ModelAndView GetUserSuggestion(
		@RequestBody(required = false) MultiValueMap<String, Object> formData,
		@RequestParam(value = "name", required = false) String name, HttpServletRequest request) {
	HashMap<String, Object> viewResult = new HashMap<>();
	//System.out.println(Status);
	twitterserviceAPI.GetUserSuggestion(name);
	viewResult.put("UserSuggestion",twitterserviceAPI.GetUserSuggestion(name).get(0));
	return new ModelAndView("index", viewResult);

}


}
