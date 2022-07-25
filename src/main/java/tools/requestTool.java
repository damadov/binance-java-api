package tools;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.*;

import com.google.common.hash.Hashing;



public class requestTool {

	public static String reqStr = "";
	public static String resStr = "";
	private static String reqCookie = "";
	private static String resCookie = "";
	

	

	
	
	public static HttpServletResponse setCORS(HttpServletResponse response,Boolean isSet) {
		try {
			

			if(appConfig.isProduction) {
				response.setHeader("Access-Control-Allow-Origin", "*");
			    response.setHeader("Access-Control-Allow-Credentials", "true");
			    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE,PUT,PATCH");
			    response.setHeader("Access-Control-Max-Age", "3600");
			    response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me, Authorization-Key,wallet,app-language,chain-id");
			    response.setHeader("Access-Control-Expose-Headers", "Authorization-Key,wallet,app-language,chain-id");
			}
			else if(isSet) {
				response.setHeader("Access-Control-Allow-Origin", "*");
			    response.setHeader("Access-Control-Allow-Credentials", "true");
			    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE,PUT,PATCH");
			    response.setHeader("Access-Control-Max-Age", "3600");
			    response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me, Authorization-Key,wallet,app-language,chain-id");
			    response.setHeader("Access-Control-Expose-Headers", "Authorization-Key,wallet,app-language,chain-id");
			    
			}else {
				response.setHeader("Access-Control-Allow-Origin", "*");
			    response.setHeader("Access-Control-Allow-Credentials", "true");
			    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE,PUT,PATCH");
			    response.setHeader("Access-Control-Max-Age", "3600");
			    response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me, Authorization-Key,wallet,app-language,chain-id");
			    response.setHeader("Access-Control-Expose-Headers", "Authorization-Key,wallet,app-language,chain-id");
			}
				
			return response;
		}catch(Exception ex){
			return response;
		}
		
		
	}
	
	public static String callGCloudFunction(String method,String endpoint,String json_req) {
		try {


			URL url = new URL(endpoint);
			

			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setConnectTimeout(appConfig.mid_timeout*1000);
			connection.setReadTimeout(appConfig.mid_timeout*1000);
			connection.setRequestProperty("User-Agent", "Mozilla");
			connection.setRequestMethod(method);
			connection.setRequestProperty("Cache-Control", "no-cache");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Type", "application/json; utf-8");
			connection.setDoOutput(true);
			

			tools.console.println(json_req);
			OutputStream os = connection.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");    
			osw.write(json_req);
			osw.flush();
			osw.close();
			os.close();  
			connection.connect();
			
		

			String result;
			BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
			ByteArrayOutputStream buf = new ByteArrayOutputStream();
			int result2 = bis.read();
			while(result2 != -1) {
			    buf.write((byte) result2);
			    result2 = bis.read();
			}
			result = buf.toString();
			System.out.println(result);
			
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String curlBinanceAPI(String endpoint,String apiKey,String apiSecret) {
		
		String res = "";
		String command = "curl -H \"X-MBX-APIKEY: "+apiKey+"\" -X POST 'https://api.binance.com/api/v3/account' -d ''\n"
				+ "";
		ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));

				
		return res;
				
				
	}
	
	 public static String callBinanceAPINew(String endpoint,String apiKey,String apiSecret) {
			try {
				
				 long timestamp = System.currentTimeMillis();
				  tools.console.println(Long.toString(timestamp));
				  LocalDateTime localtime = validation.epochToLocalDateTime(timestamp, appConfig.postgreTimeZone);
				  tools.console.println(localtime.toLocalDate().toString() +" "+ localtime.toLocalTime().toString());
				  
				  
				  String valueToDigest = ""; //Long.toString(millis);
			        byte[] key = appConfig.binanceSpotSecret.getBytes();

			      String  signature = Hashing.hmacSha256(key)
			                .newHasher()    
			                .putString(valueToDigest, Charset.defaultCharset())
			                .hash()
			                .toString();    

			    URL url = new URL(endpoint);
				
				Map<String, String> parameters = new HashMap<>();
				parameters.put("timestamp", Long.toString(timestamp));
				parameters.put("signature", signature);
				
				
				HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

				connection.setConnectTimeout(appConfig.mid_timeout*1000);
				connection.setReadTimeout(appConfig.mid_timeout*1000);
				
				connection.setRequestMethod("GET");
				connection.setRequestProperty("X-MBX-APIKEY", apiKey);
				connection.setRequestProperty("Accept", "*/*");
				//connection.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
				connection.setRequestProperty("Content-Type", "application/json");
//				connection.setDoInput(false);
				connection.setDoOutput(true);
				DataOutputStream out = new DataOutputStream(connection.getOutputStream());
				out.writeBytes(getParamsString(parameters));
				out.flush();
				out.close();
				
				connection.connect();
				
				int responseCode = connection.getResponseCode();
				System.out.println("GET Response Code :: " + responseCode);

				Reader reader = null;
			      if ("gzip".equals(connection.getContentEncoding())) {
			         reader = new InputStreamReader(new GZIPInputStream(connection.getInputStream()));
			      }
			      else {
			         reader = new InputStreamReader(connection.getInputStream());
			      }
			      
				  if (responseCode == HttpsURLConnection.HTTP_OK) { // success
					BufferedReader in = new BufferedReader(reader);
					String inputLine;
					StringBuffer response = new StringBuffer();

					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();

					// print result
					tools.console.println(response.toString());
					return response.toString();
				} else {
					tools.console.println("GET request not worked");
					tools.console.println(endpoint);
					return null;
				}

			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

		
	 public static String callBinanceAPI(String endpoint,String apiKey,String apiSecret) {
			try {
				// Your API Key and secret
				//String apiKey = appConfig.hotelbedsKey;
				//String Secret = appConfig.hotelbedsSecret;
				// Signature is generated by SHA256 (Api-Key + Secret +
				// Timestamp (in seconds))
				String signature = org.apache.commons.codec.digest.DigestUtils
						.sha256Hex(apiKey + apiSecret + System.currentTimeMillis() / 1000);


				URL url = new URL(endpoint);
				
				

				HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
				connection.setConnectTimeout(appConfig.mid_timeout*1000);
				connection.setReadTimeout(appConfig.mid_timeout*1000);
				
				connection.setRequestMethod("GET");
				//connection.setRequestProperty("User-Agent", "Mozilla/5.0");
				connection.setRequestProperty("X-MBX-APIKEY", apiKey);
				connection.setRequestProperty("X-Signature", signature);
				connection.setRequestProperty("Api-key", apiKey);
				connection.setRequestProperty("Accept", "*/*");
				connection.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
				connection.setRequestProperty("Content-Type", "application/json");

				int responseCode = connection.getResponseCode();
				System.out.println("GET Response Code :: " + responseCode);
				Reader reader = null;
			      if ("gzip".equals(connection.getContentEncoding())) {
			         reader = new InputStreamReader(new GZIPInputStream(connection.getInputStream()));
			      }
			      else {
			         reader = new InputStreamReader(connection.getInputStream());
			      }
			      
				if (responseCode == HttpsURLConnection.HTTP_OK) { // success
					BufferedReader in = new BufferedReader(reader);
					String inputLine;
					StringBuffer response = new StringBuffer();

					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();

					// print result
					tools.console.println(response.toString());
					return response.toString();
				} else {
					tools.console.println("GET request not worked");
					tools.console.println(endpoint);
					return null;
				}

			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	
public static String getLanguage(HttpServletRequest request) {
		
		String lang = appConfig.defaultLang;
		
		try {
			
			if(request.getHeader("app-language")!=null && !request.getHeader("app-language").toString().equals("null") && !request.getHeader("app-language").toString().equals("")) {
				tools.console.println("Found lang header:"+request.getHeader("app-language").toString().toLowerCase());
				lang = request.getHeader("app-language").toString().toLowerCase();
			}
			else
				lang = appConfig.defaultLang;
		
		return lang;
		}catch(Exception ex) {
			return "en";
		}
		
	}


	
	
	
	 
	
	
	
	
	public static String getIP(HttpServletRequest request) {
		 String ipAddress = request.getHeader("X-FORWARDED-FOR");  
	       if (ipAddress == null) {  
	         ipAddress = request.getRemoteAddr();  
	       }
		
		return ipAddress;
	}
	public static String getInfo(HttpServletRequest request) {
		try {
			return request.getHeader("user-agent")+"\n"+request.getHeader("from");
		}catch(Exception ex) {
			return "";
			
		}
	}
	
	
	public static String getJSON(HttpServletRequest request) {
		String json_req = "";

		try {
		if(request.getParameter("myData")!=null) {
			  json_req = request.getParameter("myData");
 
		  }
		else if(request.getParameter("newData")!=null) {
			json_req = request.getParameter("newData");
			tools.console.println("Requets parameter updated:"+json_req);
		}
		else if(request.getParameter("key")!=null) {
			json_req = request.getParameter("key");
			tools.console.println("Requets parameter updated:"+json_req);
		}
		else {

			  BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
			  String read = br.readLine();

		  		while( read != null )
		  		{
		  			json_req = json_req + read ;
		  			read = br.readLine();
		  		}

		  }
		}catch(Exception ex) {
			tools.console.println("PArsing Request Error"+ex.getMessage());
		}
		
		return json_req;
	}
	
	    public static String getParamsString(Map<String, String> params) 
	      throws UnsupportedEncodingException{
	        StringBuilder result = new StringBuilder();

	        for (Map.Entry<String, String> entry : params.entrySet()) {
	          result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
	          result.append("=");
	          result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
	          result.append("&");
	        }

	        String resultString = result.toString();
	        return resultString.length() > 0
	          ? resultString.substring(0, resultString.length() - 1)
	          : resultString;
	    }

	
	    public static String inputStreamToString(InputStream inputStream) {
	        final int bufferSize = 8 * 1024;
	        byte[] buffer = new byte[bufferSize];
	        final StringBuilder builder = new StringBuilder();
	        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, bufferSize)) {
	            while (bufferedInputStream.read(buffer) != -1) {
	                builder.append(new String(buffer));
	            }
	        } catch (IOException ex) {
	           tools.console.println(ex.getMessage());
	        }
	        return builder.toString();
	    }

	    private static String bytesToHex(byte[] hash) {
	        StringBuilder hexString = new StringBuilder(2 * hash.length);
	        for (int i = 0; i < hash.length; i++) {
	            String hex = Integer.toHexString(0xff & hash[i]);
	            if(hex.length() == 1) {
	                hexString.append('0');
	            }
	            hexString.append(hex);
	        }
	        return hexString.toString();
	    }
	    
}
