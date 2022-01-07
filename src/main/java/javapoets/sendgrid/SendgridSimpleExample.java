package javapoets.sendgrid; 

import java.io.IOException;
import io.github.cdimascio.dotenv.Dotenv;
import com.sendgrid.*;

public class SendgridSimpleExample {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    
    public static void main(String[] args) throws IOException {
        try {

            Dotenv dotenv = Dotenv.load();
            String sendgridApiKey = dotenv.get("SENDGRID_API_KEY");
            log.debug("sendgridApiKey = " + sendgridApiKey);

            log.debug("args[0] = " + args[0]);  // To: email
            log.debug("args[1] = " + args[1]);  // From: email

            SendGrid sendGrid = new SendGrid(sendgridApiKey);
            Request request = new Request();
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(new StringBuilder().append("{")
                .append("\"personalizations\":[{")
                    .append("\"to\":[{\"email\":\"").append(args[0]).append("\"}]")
                    .append(",\"subject\":\"Sending with Twilio SendGrid is Fun\"}]")
                .append(",\"from\":{\"email\":\"").append(args[1]).append("\"}")
                .append(",\"content\":[{\"type\":\"text/plain\",\"value\": \"and easy to do anywhere, especially in Java\"}]}")
                .append("}").toString());
            Response response = sendGrid.api(request);
            log.debug("response.getStatusCode() = " + response.getStatusCode());
            log.debug("response.getBody() = " + response.getBody());
            log.debug("response.getHeaders() = " + response.getHeaders());
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}