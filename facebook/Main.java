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
	
	static String accessToken = "EAAOQH1flf1cBAE40JCZBC1PSovsqUce7KTyrRfWFozKJnHrIYH2ZB1PsZCZCDAoA3vJbUW8tg0gk2PAUm6FHbmAD721VAAUu2HeSyGWEk0ZCBhLMDn2C4fFPtVCOBToSzT4eqEdRdRxJPmo6s19YU8hKZBaMhjflIWdXlMTIolJ0cFZAGLO8BOZCV9iOeJracP8ZD";
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
	 Modificar Par�metros
	 */
    Scanner scanner = new Scanner(System.in);
	logger.info("inicializando app");
	Facebook facebook = new FacebookFactory().getInstance();
	facebook.setOAuthAppId(appID, appSecret);
    facebook.setOAuthAccessToken(new AccessToken(accessToken,null));	
	//facebook.setOAuthPermissions(CONFIG_FILE);
    facebook.setOAuthPermissions("read_stream, user_likes, user_posts");
    facebook.getPermissions().toString();

    while(true){
    System.out.format("Simple Facebook client %s\n\n", APP_VERSION);
	System.out.println("Opciones: ");
	System.out.println("(0) Mostrar Newsfeed");
	System.out.println("(1) Mostrar Muro");
	System.out.println("(2) Publicar Estado");
	System.out.println("(3) Modificar Par�metros");
	System.out.println("(4) Mostrar Log");
	System.out.println("(5) Salir");
	System.out.println("\nPor favor ingrese una opcion: ");
	int seleccion;
	seleccion = scanner.nextInt();
	scanner.nextLine();
	
	switch(seleccion){
	
	case 0://Mostrar NewsFeed
<<<<<<< HEAD
=======
		logger.info("Elecci�n Mostrar NewsFeed.");
>>>>>>> refs/heads/mostrar_log
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
<<<<<<< HEAD
		break;
	case 1://Mostrar Muro
=======
		logger.info("Se despleg� el newsfeed.");
		break;
	case 1://Mostrar Muro
		logger.info("Elecci�n Mostrar Muro.");
>>>>>>> refs/heads/mostrar_log
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
<<<<<<< HEAD
		break;
	case 2://Publicar Estado o link
=======
		logger.info("Se desplieg� el muro.");
		break;
	case 2://Publicar Estado o link
		logger.info("Elecci�n Publicar Estado o Link");
>>>>>>> refs/heads/mostrar_log
		System.out.println("Desea publicar un estado o un link?");
		System.out.println("Opciones: ");
		System.out.println("(0) Estado");
		System.out.println("(1) Link");
		int seleccion2;
		seleccion2 = scanner.nextInt();
		scanner.nextLine();
		switch(seleccion2){
		case 0://Publicar Estado
<<<<<<< HEAD
=======
			logger.info("Elecci�n Publicar Estado.");
>>>>>>> refs/heads/mostrar_log
			System.out.println("En qu� estas pensando?");
			String estado = scanner.nextLine();
			System.out.println("Publicando...");
			facebook.postStatusMessage(estado);
			System.out.println("Publicaci�n subida correctamente.");
<<<<<<< HEAD
			break;
		case 1://Publicar Link
=======
			logger.info("Publicaci�n Subida");
			break;
		case 1://Publicar Link
			logger.info("Elecci�n Publicar Link");
>>>>>>> refs/heads/mostrar_log
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
			System.out.println("Publicaci�n subida correctamente.");
<<<<<<< HEAD
			break;
			default:logger.error("Opcion invalida");
=======
			logger.info("Link Publicado");
			break;
			default:logger.error("Opcion invalida");
			logger.info("Opci�n Inv�lida");
>>>>>>> refs/heads/mostrar_log
				break;
		}
		break;
	case 3://Modificar Par�metros
<<<<<<< HEAD
		break;
	case 4://Mostrar Log
		break;
	case 5://Salir
		break;
	default:
		logger.error("Opcion invalida");
=======
		logger.info("Elecci�n modificaci�n de par�metros");
	    
		break;
	case 4://Mostrar Log
		logger.info("Elecci�n Mostrar Log");
		break;
	case 5://Salir
		logger.info("Salir del programa.");
		System.out.println("Adi�s!.");
		System.exit(0);
		break;
	default:
		logger.error("Opcion invalida");
		logger.info("Opci�n Inv�lida");
>>>>>>> refs/heads/mostrar_log
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


