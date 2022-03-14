package server;

import java.io.*;
import java.net.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Database.Database;

public class ThreadServer extends Thread {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Database database;

    public ThreadServer(Socket s) throws IOException, ClassNotFoundException {
        socket = s;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

        try {
            database = new Database("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost/депозиты", "root", "Vjhb_Jufq17.02");
            System.out.println("Сервер соединен с базой данных");
        } catch (SQLException e) {
            Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, e);
        }
        start();
    }

    public void run() {
        Integer idOperation;
        ServerActivity obj = new ServerActivity(in, out, database);

        try {
            while (true) {
                String bufString = in.readLine();
                if (bufString.equals("END")) {
                    database.close();
                    System.out.println("Сервер отсоединен от базы данных");
                    break;
                }
                idOperation = Integer.parseInt(bufString);
                obj.getId(idOperation);
            }
            System.out.println("Клиент был отсоединен");
        } catch (IOException e) {
            System.err.println("IO Exception");
        } catch (SQLException e) {
        } finally {
            try {
                socket.close();
            } catch (IOException ex) {
                System.err.println("Socket not closed");
            }
        }
    }
}
