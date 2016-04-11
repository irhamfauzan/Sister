
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Irhamfauzan
 */
public class SendEmailDemo {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        try {
            System.out.println("Connecting . . . . ");
            String host = "127.0.0.1";
            int port = 25;
            try (Socket sock = new Socket(host, port)) {
                System.out.println("Connected");
                
                BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream(), "UTFS"));
                BufferedReader rd = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                String line;

                //Menunggu Respon
                System.out.println("Respon");
                line = rd.readLine();
                System.out.println(line);

                //kirim hello
                System.out.println("Kirim Hello");
                wr.write("Hello Jarkom\r\n");
                wr.flush();
                System.out.println("Respon");
                line = rd.readLine();
                System.out.println(line);

                //kirim RCPT To
                System.out.println("Kirim RCPT To");
                wr.write("RCPT TO : <user28@jarkom.com>\r\n");
                wr.flush();
                System.out.println("Respon");
                line = rd.readLine();
                System.out.println(line);

                //kirim Data
                System.out.println("Kirim Data");
                wr.write("Data\r\n");
                wr.flush();
                System.out.println("Respon");
                line = rd.readLine();
                System.out.println(line);

                System.out.println("Kirim isi Email");
                wr.write("From : User 1<user1@jarkom.com>\r\n");
                wr.write("To: User 2<user2@jarkom.com>\r\n");
                wr.write("Subject : ini Subject email\r\n");
                wr.write("\r\n");
                wr.flush();
                System.out.println("Respon: ");
                line = rd.readLine();
                System.out.println(line);

                //kirim quit
                System.out.println("Kirim Quit");
                wr.write("Quit\r\n");
                wr.flush();
                System.out.println("Respon: ");
                line = rd.readLine();
                System.out.println(line);

                wr.close();
                wr.close();
            }
            System.out.println("Disconnected");
        } catch (UnknownHostException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        } catch (IOException x) {
            System.err.println(x.getMessage());
            System.exit(1);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
