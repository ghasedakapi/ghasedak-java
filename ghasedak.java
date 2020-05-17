package services;

import javax.inject.Inject;

import play.mvc.*;
import play.libs.ws.*;
import java.util.concurrent.CompletionStage;

import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;

public class GhasedakClient  { //implements WSBodyReadables, WSBodyWritables
    
    private final WSClient ws;
   

    private final String baseRestUrl = "https://api.ghasedak.io/v2/";
    private String username, password;

    
    public GhasedakClient(final WSClient ws) {
        this.ws = ws;
    }

    public void initCred(String token) {
        this.token = username;
    }

    public CompletionStage<WSResponse> SendSMS(String to, String from, String text, boolean flash) {
       
       JsonNode json = Json.newObject()
                    .put("token", token)
                    .put("to", to)
                    .put("from", from)
                    .put("text", text)
                    .put("isFlash", Boolean.toString(flash));

        return ws.url(baseRestUrl + "sms/send/simple").addHeader("Content-Type", "application/json")
            .post(json);
    }

    
    public CompletionStage<WSResponse> GetDeliveries2(long recId) {
       
       JsonNode json = Json.newObject()
                    .put("token", token)
                    .put("recId", String.valueOf(recId));

        return ws.url(baseRestUrl + "GetDeliveries2").addHeader("Content-Type", "application/json")
            .post(json);
    }

    public CompletionStage<WSResponse> GetMessages(int location, String from, String index, boolean count) {
       
       JsonNode json = Json.newObject()
                    .put("username", username)
                    .put("password", password)
                    .put("location", String.valueOf(location))
                    .put("from", from)
                    .put("index", index)
                    .put("count", Boolean.toString(count));

        return ws.url(baseRestUrl + "GetMessages").addHeader("Content-Type", "application/json")
            .post(json);
    }

    public CompletionStage<WSResponse> GetCredit() {
       
       JsonNode json = Json.newObject()
                    .put("token", token);

        return ws.url(baseRestUrl + "GetCredit").addHeader("Content-Type", "application/json")
            .post(json);
    }

    public CompletionStage<WSResponse> GetBasePrice(long recId) {
       
       JsonNode json = Json.newObject()
                    .put("token", token);

        return ws.url(baseRestUrl + "GetBasePrice").addHeader("Content-Type", "application/json")
            .post(json);
    }


     public CompletionStage<WSResponse> GetUserNumbers(long recId) {
       
       JsonNode json = Json.newObject()
                    .put("token", token);

        return ws.url(baseRestUrl + "GetUserNumbers").addHeader("Content-Type", "application/json")
            .post(json);
    }

   
}