package facebook;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
	private static final String LOG_FILE = "logs/facebook.log";
	
	static String accessToken = "EAACEdEose0cBANUmjJLEZCEeBqKvegWeH1ZAUIt38fZAFnjTw3xAgqpbIZCptl4EMMSNZCdwCkUTTwfZAZAkfLv2FQ3OpU9SiemevFBJhgTI4Ao5nLcsDzV0US5psRZB5n4q6LW0WN7ZBS4CrkebLvr0MvUR9O8UrMv4BJoUWNqiSh64BWdZCGmrO4XltYMd17bh0ZD";
	static String appID = "1002889223176023";
	static String appSecret = "bd66801e7a57990f084537b2e97d394f";
    
	public static void main(String[] args) throws FacebookException {
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
	
    Scanner scanner = new Scanner(System.in);
	logger.info("inicializando app");
	Facebook facebook = new FacebookFactory().getInstance();
	facebook.setOAuthAppId(appID, appSecret);
    facebook.setOAuthAccessToken(new AccessToken(accessToken,null));	
    facebook.setOAuthPermissions("read_stream, user_likes, user_posts");

    while(true){
    System.out.format("Simple Facebook client %s\n\n", APP_VERSION);
	System.out.println("Opciones: ");
	System.out.println("(0) Mostrar Newsfeed");
	System.out.println("(1) Mostrar Muro");
	System.out.println("(2) Publicar Estado");
	System.out.println("(3) Modificar Parámetros");
	System.out.println("(4) Mostrar Log");
	System.out.println("(5) Mostrar Parámetros Actuales");
	System.out.println("(6) Salir");
	System.out.println("\nPor favor ingrese una opcion: ");
	int seleccion;
	seleccion = scanner.nextInt();
	scanner.nextLine();
	
	switch(seleccion){
	
	case 0://Mostrar NewsFeed
		logger.info("Elección Mostrar NewsFeed.");
		System.out.println("Mostrando NewsFeed...");
		ResponseList<Post> feed = facebook.getFeed();
		for(int i=0;i<feed.size();i++){
		    System.out.println("------------------------------------------------------------");
		    if(feed.get(i).getCaption()!=null)System.out.println("Caption: " + feed.get(i).getCaption());
		    if(feed.get(i).getDescription()!=null)System.out.println("Description" + feed.get(i).getDescription());
		    if(feed.get(i).getStory()!=null)System.out.println("Story: " + feed.get(i).getStory());
		    if(feed.get(i).getName()!=null)System.out.println("Name: " + feed.get(i).getName());
		    if(feed.get(i).getMessage()!=null)System.out.println("Message: " + feed.get(i).getMessage());
		    if(feed.get(i).getCreatedTime()!=null)System.out.println("Created Time: " + feed.get(i).getCreatedTime());
		    if(feed.get(i).getPicture()!=null)System.out.println("Picture: " + feed.get(i).getPicture());
		    if(feed.get(i).getFullPicture()!=null)System.out.println("Picture: " + feed.get(i).getFullPicture());
		    if(feed.get(i).getPermalinkUrl()!=null)System.out.println("PermaLink: " + feed.get(i).getPermalinkUrl());
		    if(feed.get(i).getLink()!=null)System.out.println("Link: " + feed.get(i).getLink());
		    System.out.println("------------------------------------------------------------");
		}
		logger.info("Se desplegó el newsfeed.");
		break;
	case 1://Mostrar Muro
		logger.info("Elección Mostrar Muro.");
		System.out.println("Mostrando Muro...");
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
		logger.info("Se despliegó el muro.");
		break;
	case 2://Publicar Estado o link
		logger.info("Elección Publicar Estado o Link");
		System.out.println("Desea publicar un estado o un link?");
		System.out.println("Opciones: ");
		System.out.println("(0) Estado");
		System.out.println("(1) Link");
		int seleccion2;
		seleccion2 = scanner.nextInt();
		scanner.nextLine();
		switch(seleccion2){
		case 0://Publicar Estado
			logger.info("Elección Publicar Estado.");
			System.out.println("En qué estas pensando?");
			String estado = scanner.nextLine();
			System.out.println("Publicando...");
			facebook.postStatusMessage(estado);
			System.out.println("Publicación subida correctamente.");
			logger.info("Publicación Subida");
			break;
		case 1://Publicar Link
			logger.info("Elección Publicar Link");
			System.out.println("Escribe la URL: ");
			String url = scanner.nextLine();
			System.out.println("Leyenda: ");
			String leyend = scanner.nextLine();
			//http://facebook4j.org
			//A Java library for the Facebook Graph API
			System.out.println("Publicando...");
			try {
				facebook.postLink(new URL(url), leyend);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			System.out.println("Publicación subida correctamente.");
			logger.info("Link Publicado");
			break;
			default:logger.error("Opcion invalida");
			logger.info("Opción Inválida");
				break;
		}
		break;
	case 3://Modificar Parámetros
		logger.info("Elección modificación de parámetros");
		System.out.println("Qué parámetro desea modificar?");
		System.out.println("Opciones: ");
		System.out.println("(0) Access Token");
		System.out.println("(1) App ID & App Secret");
		int seleccion3;
		seleccion3 = scanner.nextInt();
		scanner.nextLine();
		switch(seleccion3){
		case 0://Modificar Access Token
			logger.info("Elección Modificar Access Token");
			System.out.println("Nuevo Access Token: ");
			String token = scanner.nextLine();
			System.out.println("Modificando Parámetro...");
			facebook.setOAuthAccessToken(new AccessToken(token,null));
			System.out.println("Parámetro modificado correctamente.");
			break;
		case 1://Modificar AppID & AppSecret
			logger.info("Elección Modificar AppID & AppSecret");
			System.out.println("Nuevo AppID: ");
			String appId = scanner.nextLine();
			System.out.println("Nuevo AppSecret: ");
			String appSec = scanner.nextLine();
			System.out.println("Modificando Parámetros...");
			facebook.setOAuthAppId(appID, appSecret);
			System.out.println("Parámetros modificados correctamente.");
			break;
			default:
				logger.info("Opción Invalida");
				logger.error("Opcion Invalida");
				break;
		}
		break;
	case 4://Mostrar Log
		logger.info("Elección Mostrar Log");
		System.out.println("Mostrando Log.");
		try (BufferedReader br = new BufferedReader(new FileReader("logs/facebook.log"))) {
			   String line = null;
			   while ((line = br.readLine()) != null) {
			       System.out.println(line);
			   }
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;
	case 5://Mostrar Parámetros Actuales
		logger.info("Elección Mostrar Parámetros Actuales");
        System.out.println("Access Token: " + facebook.getOAuthAccessToken().getToken());
        break;
	case 6://Salir
		logger.info("Salir del programa.");
		System.out.println("Adiós!.");
		System.exit(0);
		break;
	default:
		logger.error("Opcion invalida");
		logger.info("Opción Inválida");
		break;
	}
		
		
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
	/*ResponseList<Post> wall = facebook.getPosts();
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
	} */
	
	
	//Mostrar Feed
	/*ResponseList<Post> feed = facebook.getFeed();
	for(int i=0;i<feed.size();i++){
	    System.out.println("------------------------------------------------------------");
	    if(feed.get(i).getCaption()!=null)System.out.println("Caption: " + feed.get(i).getCaption());
	    if(feed.get(i).getDescription()!=null)System.out.println("Description" + feed.get(i).getDescription());
	    if(feed.get(i).getStory()!=null)System.out.println("Story: " + feed.get(i).getStory());
	    if(feed.get(i).getName()!=null)System.out.println("Name: " + feed.get(i).getName());
	    if(feed.get(i).getMessage()!=null)System.out.println("Message: " + feed.get(i).getMessage());
	    if(feed.get(i).getCreatedTime()!=null)System.out.println("Created Time: " + feed.get(i).getCreatedTime());
	    if(feed.get(i).getPicture()!=null)System.out.println("Picture: " + feed.get(i).getPicture());
	    if(feed.get(i).getFullPicture()!=null)System.out.println("Picture: " + feed.get(i).getFullPicture());
	    if(feed.get(i).getPermalinkUrl()!=null)System.out.println("PermaLink: " + feed.get(i).getPermalinkUrl());
	    if(feed.get(i).getLink()!=null)System.out.println("Link: " + feed.get(i).getLink());
	    System.out.println("------------------------------------------------------------");
	}*/
	//feed.forEach(System.out::println);
    }
	

}
}


