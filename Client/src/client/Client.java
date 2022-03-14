package client;

import forms.SignInForm;
import java.net.*;
import java.io.*;

public class Client extends Stream {

    public static void main(String[] args) throws IOException, InterruptedException {
        InetAddress address = InetAddress.getByName(null);
        socket = new Socket(address, 8020);

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

        SignInForm signingIn = new SignInForm();
        signingIn.setVisible(true);
        signingIn.setLocationRelativeTo(null);
    }
}
