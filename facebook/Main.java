package facebook;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.NoSuchFileException;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;
import java.util.function.Consumer;

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
	
<<<<<<< HEAD
	static String accessToken = "EAAOQH1flf1cBAGufZBq6xENQjYK11we1oXbZA1fWd7xCoH3ZCfWcZAQra5bzZC8cBXcv5ZAZBqZACGxNyFcoo5RTqUKo9W7vPwE7ZBa0N2zdhzSvaCjTrR58aDH2evjdJaKeF9wovrXKPwhdIqDERtZAhO8iYMmJG8ACoIaZC56xJQCbdDcfOOJMVSUUR8cmSZAaWdoZD";
=======
	static String accessToken = "EAAOQH1flf1cBAE40JCZBC1PSovsqUce7KTyrRfWFozKJnHrIYH2ZB1PsZCZCDAoA3vJbUW8tg0gk2PAUm6FHbmAD721VAAUu2HeSyGWEk0ZCBhLMDn2C4fFPtVCOBToSzT4eqEdRdRxJPmo6s19YU8hKZBaMhjflIWdXlMTIolJ0cFZAGLO8BOZCV9iOeJracP8ZD";
>>>>>>> refs/heads/mostrar_muro
    static String appID = "1002889223176023";
    static String appSecret = "bd66801e7a57990f084537b2e97d394f";
    
	public static void main(String[] args) throws FacebookException {
<<<<<<< HEAD
		
=======
	/*
	 Mostrar Log
	 Mostrar NewsFeed--
	 Guardar Publicaciones en .txt
	 Mostrar Muro--
	 Guardar Publicaciones en .txt
	 Publicar Estado--
	 Publicar Link--
	 Modificar Parámetros
	 */
>>>>>>> refs/heads/mostrar_muro
	logger.info("inicializando app");
	Facebook facebook = new FacebookFactory().getInstance();
	facebook.setOAuthAppId(appID, appSecret);
    facebook.setOAuthAccessToken(new AccessToken(accessToken,null));	
<<<<<<< HEAD
	facebook.postStatusMessage("Hello World from Facebook4J2.");
=======
	//facebook.setOAuthPermissions(CONFIG_FILE);
    facebook.setOAuthPermissions("read_stream, user_likes, user_posts");
    facebook.getPermissions().toString();
    
    

    /*
    //Publicar Estado
    facebook.postStatusMessage("Hello World from Facebook4J2!");
	
    //Publicar Link
	try {
		facebook.postLink(new URL("http://facebook4j.org"), "A Java library for the Facebook Graph API");
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	
	//Mostrar Wall
	ResponseList<Post> wall = facebook.getPosts();
	for(int i=0;i<wall.size();i++){
	    System.out.println("------------------------------------------------------------");
	    if(wall.get(i).getCaption()!=null)System.out.println("Caption: " + wall.get(i).getCaption());
	    if(wall.get(i).getDescription()!=null)System.out.println("Description" + wall.get(i).getDescription());
	    if(wall.get(i).getStory()!=null)System.out.println("Story: " + wall.get(i).getStory());
	    if(wall.get(i).getName()!=null)System.out.println("Name: " + wall.get(i).getName());
	    if(wall.get(i).getMessage()!=null)System.out.println("Message: " + wall.get(i).getMessage());
	    if(wall.get(i).getCreatedTime()!=null)System.out.println("Created Time: " + wall.get(i).getCreatedTime());
	    if(wall.get(i).getPicture()!=null)System.out.println("Picture: " + wall.get(i).getPicture());
	    if(wall.get(i).getFullPicture()!=null)System.out.println("Picture: " + wall.get(i).getFullPicture());
	    if(wall.get(i).getPermalinkUrl()!=null)System.out.println("PermaLink: " + wall.get(i).getPermalinkUrl());
	    if(wall.get(i).getLink()!=null)System.out.println("Link: " + wall.get(i).getLink());
	    System.out.println("------------------------------------------------------------");
	} 
	
	
	//Mostrar Feed
	ResponseList<Post> feed = facebook.getFeed();
	for(int i=0;i<feed.size();i++){
	    System.out.println(feed.get(i));
	} 
	//feed.forEach(System.out::println);
	
    /*If your app requests this permission Facebook will have to review how
     *  your app uses it.
        Limited Use
This permission is granted to apps building a Facebook-branded client on 
platforms where Facebook is not already available. For example, Android and iOS
 apps will not be approved for this permission. In addition, Web, Desktop, in-car
  and TV apps will not be granted this permission.*/
	

>>>>>>> refs/heads/mostrar_muro

}
}


