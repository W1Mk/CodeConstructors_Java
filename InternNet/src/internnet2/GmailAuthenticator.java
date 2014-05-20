/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package internnet2;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author laurens
 */
public class GmailAuthenticator extends Authenticator {
    String user;
     String pw;
     public GmailAuthenticator (String username, String password)
     {
        super();
        this.user = username;
        this.pw = password;
     }
    @Override
    public PasswordAuthentication getPasswordAuthentication()
    {
       return new PasswordAuthentication(user, pw);
    }
}
