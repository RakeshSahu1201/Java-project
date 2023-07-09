/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem.utility;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 *
 * @author spsub
 */
public class OTPSenderApi implements SmsApi{
    
    @Override
    public boolean send(String number, String OTP) throws UnirestException{
        Unirest.setTimeouts(0, 0);
        number = "91"+number;
        String url = "https://2factor.in/API/V1/ae84ffaa-64e5-11ed-9c12-0200cd93602/SMS/"+number+"/"+OTP+"/OTP1";
        HttpResponse<String> response = Unirest.get(url).asString();
        
        //this comparison is case sensative 
        boolean result = response.getBody().contains("Success");
        System.out.println(response.getBody());
        return result;
    }
}
