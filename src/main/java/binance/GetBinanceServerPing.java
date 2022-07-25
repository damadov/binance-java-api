package binance;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import tools.appConfig;
import tools.requestTool;

@WebServlet(
    name = "GetBinanceServerPing",
    urlPatterns = {"/binance/ping"}
)
public class GetBinanceServerPing extends HttpServlet {

  /**
	 * 
	 */
	private static final long serialVersionUID = 6425420635473678297L;

@Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
	  

	 
	 try 
	 {

		 String res =  requestTool.callBinanceAPI(appConfig.binanceUrl+"/api/v3/ping", appConfig.binanceSpotKey, appConfig.binanceSpotSecret);
		 tools.console.println(res);
	  
	    response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	    if(response.getStatus() == 200 )
	    	response.getWriter().print("successful");
	    else
	    	response.getWriter().print("Http Status:"+response.getStatus());
	    
	 }
	 catch(Exception ex) {
		 
	 }

  }
  
  
}