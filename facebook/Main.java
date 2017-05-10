package facebook;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.restfb.FacebookClient;

import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;
import facebook4j.Post;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.RSVPStatus;

public class Main {
	private static final Logger logger = LogManager.getLogger(Main.class);
	private static final String CONFIG_DIR = "config";
	private static final String CONFIG_FILE = "facebook.properties";
	private static final String APP_VERSION = "v1.0";
	
	static String accessToken = "EAAOQH1flf1cBAGufZBq6xENQjYK11we1oXbZA1fWd7xCoH3ZCfWcZAQra5bzZC8cBXcv5ZAZBqZACGxNyFcoo5RTqUKo9W7vPwE7ZBa0N2zdhzSvaCjTrR58aDH2evjdJaKeF9wovrXKPwhdIqDERtZAhO8iYMmJG8ACoIaZC56xJQCbdDcfOOJMVSUUR8cmSZAaWdoZD";
    static String appID = "1002889223176023";
    static String appSecret = "bd66801e7a57990f084537b2e97d394f";
    
	public static void main(String[] args) throws FacebookException {
		
	logger.info("inicializando app");
	Facebook facebook = new FacebookFactory().getInstance();
	facebook.setOAuthAppId(appID, appSecret);
    facebook.setOAuthAccessToken(new AccessToken(accessToken,null));	
	facebook.postStatusMessage("Hello World from Facebook4J2.");

}
}


