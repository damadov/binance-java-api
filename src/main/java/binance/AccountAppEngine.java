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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import binance.BinanceSignature;
import data.Balance;
import binance.Binance;
import tools.HMAC;
import tools.appConfig;
import tools.requestTool;
import tools.validation;

@WebServlet(
    name = "AccountAppEngine",
    urlPatterns = {"/binance/account"}
)
public class AccountAppEngine extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
		
		Gson gson = new GsonBuilder().create();

		
		try {

			  Balance balance = BinanceActions.account();
			  
			 	response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    response.getWriter().print(gson.toJson(balance,Balance.class));
			
		}catch(Exception ex) {
			tools.console.println("Error: "+ex.getMessage());
		}

	

  }
}