/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;



public class SmsSenderApi implements SmsApi{

    /**
     *
     * @param number
     * @param message
     * @return 
     * @throws Exception
     */
    @Override
    public boolean send(String number, String message) throws Exception{
        

    // This URL is used for sending messages
    String myURI = "https://api.bulksms.com/v1/messages";
    StringBuilder result = null;
    
    // change these values to match your own account
//    String myUsername = "yashgarg03";
//    String myPassword = "Yash@123";
    String myUsername = "amanraza";
    String myPassword = "Aman@123";

    
    number = "91"+number;
    String myData = "{to: \'"+number+"\', body: \""+message+"\"}";
   
    //myData = "{to: \"7415617724\", encoding: \"UNICODE\", body: \"muje khasi hai mera ilaj kar ba do\"}";
    // if your message does not contain unicode, the "encoding" is not required:
    // String myData = "{to: \"1111111\", body: \"Hello Mr. Smith!\"}";

    // build the request based on the supplied settings
    URL url = new URL(myURI);
    HttpURLConnection request = (HttpURLConnection) url.openConnection();
    request.setDoOutput(true);

    // supply the credentials
    String authStr = myUsername + ":" + myPassword;
    String authEncoded = Base64.getEncoder().encodeToString(authStr.getBytes());
    request.setRequestProperty("Authorization", "Basic " + authEncoded);

    // we want to use HTTP POST
    request.setRequestMethod("POST");
    request.setRequestProperty( "Content-Type", "application/json");

    // write the data to the request
    OutputStreamWriter out = new OutputStreamWriter(request.getOutputStream());
    out.write(myData);
    out.close();

    // try ... catch to handle errors nicely
    try {
      // make the call to the API
      result = new StringBuilder();
      InputStream response = request.getInputStream();
      BufferedReader in = new BufferedReader(new InputStreamReader(response));
      String replyText;
      while ((replyText = in.readLine()) != null) {
        System.out.println(replyText);
        result.append(replyText);
      }
      in.close();
    } catch (IOException ex) {
        result = new StringBuilder();
      System.out.println("An error occurred:" + ex.getMessage());
      BufferedReader in = new BufferedReader(new InputStreamReader(request.getErrorStream()));
      // print the detail that comes with the error
      String replyText;
      while ((replyText = in.readLine()) != null) {
        System.out.println(replyText);
        result.append(replyText);
      }
      in.close();
    }
    request.disconnect();
    return result.toString().contains("SENT");
    }  
}
