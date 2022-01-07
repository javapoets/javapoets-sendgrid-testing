package javapoets.sendgrid; 

import java.io.IOException;
import io.github.cdimascio.dotenv.Dotenv;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.objects.*;
import com.sendgrid.helpers.mail.Mail;

public class SendgridSimpleExampleWithMailHelper {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    
    public static void main(String[] args) throws IOException {
        try {

            Dotenv dotenv = Dotenv.load();
            String sendgridApiKey = dotenv.get("SENDGRID_API_KEY");
            log.debug("sendgridApiKey = " + sendgridApiKey);

            log.debug("args[0] = " + args[0]);  // To: email
            log.debug("args[1] = " + args[1]);  // From: email

            Email from = new Email(args[1]);
            String subject = "[" + SendgridExampleWithMailHelper.class.getSimpleName() + "] Sending with Twilio SendGrid is Fun";
            Email to = new Email(args[0]);
            Content content = new Content("text/plain", "and easy to do anywhere, especially with Java");
            Mail mail = new Mail(from, subject, to, content);

            SendGrid sendGrid = new SendGrid(sendgridApiKey);
            Request request = new Request();
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
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