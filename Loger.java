import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
 
public class Loger {
	final static Logger logger = LogManager.getLogger(Log.class);
 
   private static Socket socket   = null;
   private static ServerSocket server   = null;
   private static DataInputStream in       =  null;

   public static void server(int port)
    {
        // starts server and waits for a connection
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted");

            // takes input from the client socket
            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));

            String line = "";

            // reads message from client until "Over" is sent
            
            try
            {
                line = in.readLine();
                System.out.println("'' " + line + " ''");

            }
            catch(IOException i)
            {
                System.out.println(i);
                return;
            }

            logger.error(line);

            System.out.println("Closing connection");

            // close connection
            socket.close();
            in.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    

   public static void main(String... args) {
      System.out.println();
      System.out.println();

      System.setProperty("com.sun.jndi.object.trustURLCodebase", "true");

      logger.error(args.length > 0 ? args[0] : "[no data provided to log]");

      System.out.println();
      System.out.println();
      //server(5000);
   }
}
