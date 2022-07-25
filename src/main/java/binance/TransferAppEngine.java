package binance;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;
import java.util.*;
import java.time.Instant;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.commons.codec.binary.Hex;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import binance.BinanceSignature;
import data.OrderRequest;
import data.PSCResponse;
import data.TransferRequest;
import binance.Binance;
import tools.HMAC;
import tools.appConfig;
import tools.requestTool;
import tools.validation;

@WebServlet(
    name = "TransferAppEngine",
    urlPatterns = {"/binance/transfer"}
)
public class TransferAppEngine extends HttpServlet {



/**
	 * 
	 */
	private static final long serialVersionUID = -5783497320424526089L;

@Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {

		
		Gson gson = new GsonBuilder().create();

		
		try {
	

			 HttpSession session = request.getSession();
			  String ipAddress = requestTool.getIP(request);
			  String reqInfo = requestTool.getInfo(request);
			  String json_req = requestTool.getJSON(request);
			  response = requestTool.setCORS(response,true);
			  
			  TransferRequest transfer = gson.fromJson(json_req, TransferRequest.class);
			  
			  String transferResp = BinanceActions.withdraw(transfer);
			  
			 
			  if(transferResp != null) {

					
			    	response.setStatus(HttpServletResponse.SC_OK);
			    	response.setContentType("application/json");
				    response.setCharacterEncoding("UTF-8");
				    response.getWriter().print(transferResp);
			  }else {
				 	response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
					response.setContentType("application/json");
				    response.setCharacterEncoding("UTF-8");
			  }
		    
		}catch(Exception ex) {
			
		}

  }
  

  
}