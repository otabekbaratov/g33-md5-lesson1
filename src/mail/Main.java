package mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws MessagingException, MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.ssl.enable","true");

//        Authenticator authenticator =
//        new PasswordAuthentication("otabekbaratov111@gmail.com","kpoe ohsp aqgl rzph".toCharArray());
        Authenticator authenticator = new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        "otabekbaratov111@gmail.com",
                        "kpoeohspaqglrzph"
                );

            }
        };
        Session session =  Session.getInstance(properties, authenticator);
        MimeMessage message =new MimeMessage(session);
        message.setFrom(new InternetAddress("otabekbaratov111@gmail.com"));
        message.setRecipient(Message.RecipientType.TO,new InternetAddress("akrombeksodiqov66@gmail.com"));
        message.setSubject("Testing 0f sending mail");
        message.setText("hello \n you just crashed our server with code.\n See you");
        Transport.send(message);

    }

}