package tools;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class appConfig {

	public static Boolean isLive=false;
	public static Boolean debugOn=false; 
	public static Boolean isProduction=false; 
	 
	  
	public static String xmlContentType = "text/xml;charset=utf-8";
	public static String jsonContentType = "application/json;charset=utf-8";
	public static Boolean isGZIP = true;
	public static String encoding = "UTF-8";
	public static String defaultCurr = "TRY";
	public static String defaultLang = "EN";
	public static String postgreTimeZone = "Europe/Istanbul";
	public static String defaultCountry = "TR";
	
	
	//DEV ... you should set your own credentials to related parameters.
	public static String binanceUrl = "https://api.binance.com";
	public static String binanceSpotKey = "<your_key>";
	public static String binanceSpotSecret = "<your_secret>";
	public static String binanceSpotKeyWD = "<your_key>";
	public static String binanceSpotSecretWD = "<your_secret>";
	
	public static int std_timeout = 60; //in seconds
	public static int mid_timeout = 120; //in seconds
	
	
	
	public static int approve_timelimit = 24; //Hours
	public static SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");  
	public static SimpleDateFormat sdf_=new SimpleDateFormat("yyyy-MM-dd");  
	public static SimpleDateFormat sdf_tr=new SimpleDateFormat("dd.MM.yyyy");  
	public static SimpleDateFormat sdfDetail =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	public static DecimalFormat df = new DecimalFormat("###.##");
	public static String defaultDateFormat = "dd.mm.yyyy";
	


	
}

