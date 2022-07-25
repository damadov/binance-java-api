package binance;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import data.ServerTimeResponse;
import tools.appConfig;
import tools.requestTool;

@WebServlet(
    name = "GetBinanceServerTime",
    urlPatterns = {"/binance/servertime"}
)
public class GetBinanceServerTime extends HttpServlet {

  /**
	 * 
	 */
	private static final long serialVersionUID = 2935678092603930147L;

@Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
	  
	  Gson gson = new GsonBuilder().create();

	 
	 try 
	 {

		 String res =  requestTool.callBinanceAPI(appConfig.binanceUrl+"/api/v3/time", appConfig.binanceSpotKey, appConfig.binanceSpotSecret);
		 ServerTimeResponse resp = gson.fromJson(res, ServerTimeResponse.class);
		  
		 Date currentDate = new Date (resp.serverTime);
		 SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		 String date = dateFormat.format(currentDate);
	  
	    response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().print(date);
	 }
	 catch(Exception ex) {
		 
	 }

  }
  
  
}