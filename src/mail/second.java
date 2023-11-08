package mail;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class second {
    public static void main(String[] args) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        "otabekodilogli@gmail.com",
                        "kpoeohspaqglrzph"
                );
            }

            ;
        };
        Session session = Session.getInstance(props, authenticator);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("otabekodilogli@gmail.com"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("otabekbaratov111@gmail.com"));
        message.setSubject("Testing of sending mail");
        message.setText("Dear Developer, \n You just crashed our server with code. \n Please revert back all you trash code.");
        Transport.send(message);
    }
}