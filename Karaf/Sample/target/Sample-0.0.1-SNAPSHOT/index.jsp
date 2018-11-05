<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.List"%>
 <%@ taglib uri="http://www.springframework.org/tags"  prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.dexters.Controller.BaseController"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<title>TweetAPI</title>
<!-- 	@Author
	Sowndhariya Nandarajkumar -->
<style>
header {
    background-color: #CC3366 ;
    padding: 10px;
    text-align: left;
   color: white;
}
hr {
	border: none;
	height: 1px;
	color: #780;
	background-color: #333;
}

table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 98%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 5px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
</head>
<body>
<div><c:out value="${key}"/></div>
<table>
  <tr>
    <th>Twitter API</th>
    <th>Enter</th>
    <th>Submit</th>
  </tr>
  <form id="StatusId">

  <tr>
    <td><a href="#" class="fa fa-twitter">https://api.twitter.com/1.1/favorites/list.json</a></td>
    <td><input class="form-control input-sm" id="ex1" name="Statusname" placeholder="Enter your twitter account name" type="text"></td>
    <td><button type="submit" value="Submit" class="btn btn-primary" onclick="GetfavoriteList()">Submit</button></td>
  </tr>
   
   <tr>
    <td><a href="#" class="fa fa-twitter">https://api.twitter.com/1.1/friends/list.json</a></td>
    <td><input class="form-control input-sm" id="ex2" name ="followersList" placeholder="Enter your twitter account name" type="text"></td>
    <td><button type="button" class="btn btn-primary" onclick="GetfollowersList()">Submit</button></td>
  </tr>
 
  <tr>
    <td><a href="#" class="fa fa-twitter">https://api.twitter.com/1.1/followers/list.json</a></td>
    <td><input class="form-control input-sm" id="ex3" name="followingList" placeholder="Enter your twitter account name" type="text"></td>
    <td><button type="button" class="btn btn-primary" onclick="GetfollowingList()">Submit</button></td>
  </tr>
  <tr>
    <td><a href="#" class="fa fa-twitter">https://api.twitter.com/1.1/friends/ids.json</a></td>
    <td><input class="form-control input-sm" id="ex4" name="friendsIds" placeholder="Enter your twitter account name" type="text"></td>
    <td><button type="button" class="btn btn-primary" onclick="GetfriendsIds()">Submit</button></td>
  </tr>
  <tr>
    <td><a href="#" class="fa fa-twitter">https://api.twitter.com/1.1/followers/ids.json</a></td>
    <td><input class="form-control input-sm" id="ex5" placeholder="Enter your twitter account name" type="text"></td>
    <td><button type="button" class="btn btn-primary" onclick="GetffollowerssIds()">Submit</button></td>
  </tr>
  <tr>
    <td><a href="#" class="fa fa-twitter">https://api.twitter.com/1.1/trends/available.json</a></td>
    <td><input class="form-control input-sm" id="ex6"  placeholder="No need to enter values" disabled  type="text"></td>
    <td><button type="button" class="btn btn-primary" onclick="GetTrendPlace()">Submit</button></td>
  </tr>
    <tr>
    <td><a href="#" class="fa fa-twitter">https://api.twitter.com/1.1/blocks/list.json</a></td>
    <td><input class="form-control input-sm" id="ex7" placeholder="Enter your twitter account name" type="text"></td>
    <td><button type="button" class="btn btn-primary" onclick="GetBlockList()">Submit</button></td>
  </tr>
    <tr>
    <td><a href="#" class="fa fa-twitter">https://api.twitter.com/1.1/users/suggestions.json</a></td>
    <td><input class="form-control input-sm" id="ex8" placeholder="Enter your twitter account name" type="text"></td>
    <td><button type="button" class="btn btn-primary" onclick="GetUserSuggestion()">Submit</button></td>
  </tr>
   </form>
   
   
</table>


</body>


<script type="text/javascript">

function GetfavoriteList(){
	var favoriteList=$("#ex1").val();
	//alert("valuuuee --->>"+Status)
    Twturl="GetfavoriteList.htm?name="+favoriteList;
	   $.post(Twturl, $("#StatusId").serialize(), function(data) {
		 alert("Sucuss")
		}, 'json');
	   alert("200 ok")
	   
	   
}


function GetfollowersList(){
	var followersList=$("#ex2").val();
	Twturl="GetfollowersList.htm?name="+followersList;
	   $.post(Twturl, $("#StatusId").serialize(), function(data) {
		 alert("Sucuss")
		}, 'json');
	   alert("200 ok")
	
}


function GetfollowingList(){
	var followingList=$("#ex3").val();
	Twturl="GetfollowingList.htm?name="+followingList;
	   $.post(Twturl, $("#StatusId").serialize(), function(data) {
		 
		}, 'json');
	   alert("200 ok")
	
}

function GetfriendsIds(){
	var friendsIds=$("#ex4").val();
	Twturl="GetfriendsIds.htm?name="+friendsIds;
	   $.post(Twturl, $("#StatusId").serialize(), function(data) {
		 }, 'json');
	   alert("200 ok")
	  
	   }


function GetffollowerssIds(){
	
	var followerssIds=$("#ex5").val();
	Twturl="GetfollowersIds.htm?name="+followerssIds;
	   $.post(Twturl, $("#StatusId").serialize(), function(data) {
		 alert("Sucuss")
		}, 'json');
	   alert("200 ok")
	
}


function GetTrendPlace(){
	Twturl="GetTrendPlace.htm?";
	   $.post(Twturl, $("#StatusId").serialize(), function(data) {
		 alert("Sucuss")
		}, 'json');
	   alert("200 ok")
}

function GetBlockList(){
	var BlockList=$("#ex7").val();
	Twturl="GetBlockList.htm?name="+BlockList;
	   $.post(Twturl, $("#StatusId").serialize(), function(data) {
		 alert("Sucuss")
		}, 'json');
	   alert("200 ok")
	
}


function GetUserSuggestion(){
	var UserSuggestion=$("#ex8").val();
	Twturl="GetUserSuggestion?name="+UserSuggestion;
	   $.post(Twturl, $("#StatusId").serialize(), function(data) {
		 alert("Sucuss")
		}, 'json');
	   alert("200 ok")
	
}


</script>
</html>