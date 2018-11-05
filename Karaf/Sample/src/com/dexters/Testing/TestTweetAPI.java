package com.dexters.Testing;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import com.dexters.Service.TwitterServiceAPI;

import junit.framework.Assert;
/*@Author
Sowndhariya Nandarajkumar*/
public class TestTweetAPI {
	TwitterServiceAPI twitterserviceAPI =new TwitterServiceAPI();
	
	@Test
	public void testGetfollowersList() {
		HashMap<String, Object> _testvalue = twitterserviceAPI.GetfollowersList("Test");
		Assert.assertNotNull(_testvalue);
	}
	@Test
	public void testGetfollowingList() {
		List<String> _testvalue = twitterserviceAPI.GetfollowingList("Test");
		Assert.assertNotNull(_testvalue);
	}
	@Test
	public void testGetfriendsIds() {
		List<Integer> _testvalue = twitterserviceAPI.GetfriendsIds("Test");
		Assert.assertNotNull(_testvalue);
	}
	@Test
	public void testGetffollowerssIds() {
		List<Integer> _testvalue = twitterserviceAPI.GetffollowerssIds("Test");
		Assert.assertNotNull(_testvalue);
	}
	@Test
	public void testGetTrendPlace() {
		List<String> _testvalue = twitterserviceAPI.GetTrendPlace();
		Assert.assertNotNull(_testvalue);
	}
	@Test
	public void testGetBlockList() {
		List<String> _testvalue = twitterserviceAPI.GetBlockList("Test");
		Assert.assertNotNull(_testvalue);
	}
	@Test
	public void testGetUserSuggestion() {
		List<String> _testvalue = twitterserviceAPI.GetUserSuggestion("Test");
		Assert.assertNotNull(_testvalue);
	}
	@Test
	public void testGetfavoriteList() {
		List<String> _testvalue = twitterserviceAPI.GetfavoriteList("Test");
		Assert.assertNotNull(_testvalue);
	}
	

}
