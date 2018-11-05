package com.dexters.Service;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import com.sun.net.ssl.HttpsURLConnection;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

@SuppressWarnings("deprecation")
public class OAuthRequest {
	protected static HttpsURLConnection connection;
	public OAuthConsumer Authentication() throws IOException {
	//	Properties properties = getProperties();
		String consumerKeyStr = "KF23fCZUTELtiEQKoYjUrNOBY";
		String consumerSecretStr ="BBtNZ9jqa1iScHOVEwTs9YqkiLp9M2FAJvdDVFcOO7m0TyArzc";
		String accessTokenStr = "327193571-SyrV4tXWpDlxFglsLFcv8hxZgrSq8gswjUTkFuWW";
		String accessTokenSecretStr = "wIxSic3aQqxx8KujFFuwfl5k618MJe5PlKsaxDY83PlCH";
		OAuthConsumer oAuthConsumer = new CommonsHttpOAuthConsumer(consumerKeyStr, consumerSecretStr);
		oAuthConsumer.setTokenWithSecret(accessTokenStr, accessTokenSecretStr);
		return oAuthConsumer;
	}
	/*@Author
	Sowndhariya Nandarajkumar*/
	
	@SuppressWarnings({ "resource" })
	protected HttpResponse executeHttpPost(String apiUrl) throws OAuthMessageSignerException,
			OAuthExpectationFailedException, OAuthCommunicationException, IOException {
		HttpPost request = new HttpPost(apiUrl);
		Authentication().sign(request);
		HttpClient client = new DefaultHttpClient();
		HttpResponse response = client.execute(request);
		return response;
	}
    /*@Author
	Sowndhariya Nandarajkumar*/
	@SuppressWarnings({ "unused", "deprecation" })
	public HttpResponse executeHttpGet(String apiUrl) throws OAuthMessageSignerException,
			OAuthExpectationFailedException, OAuthCommunicationException, IOException {
		HttpGet request = new HttpGet(apiUrl);
		Authentication().sign(request);
		@SuppressWarnings("resource")
		HttpClient client = new DefaultHttpClient();
		HttpResponse response = client.execute(request);
		return response;
	}

}
