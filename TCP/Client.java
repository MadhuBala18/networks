import java.net.*; 
import java.io.*; 
import java.util.*;
public class Client 
{ 
    private Socket socket = null; 
    private DataInputStream input = null; 
    private DataOutputStream out = null; 
    public Client(String address, int port) 
    { 
        try
        { 
            socket = new Socket(address, port); 
            System.out.println("Connected"); 
            input = new DataInputStream(System.in); 
            out = new DataOutputStream(socket.getOutputStream()); 
        } 
        catch(Exception e) 
        { 
            System.out.println(e); 
        } 
        String line = ""; 
        Scanner sc = new Scanner(System.in);
        while (!line.equals("Over")) 
        { 
            try
            { 
                line = sc.next(); 
                out.writeUTF(line); 
            } 
            catch(IOException i) 
            { 
                System.out.println(i); 
            } 
        } 
        try
        { 
            input.close(); 
            out.close(); 
            socket.close(); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
    } 
    public static void main(String args[]) 
    { 
        Client client = new Client("127.0.0.1", 5000); 
    } 
} 



/*

output


client

Connected
Hello
Hey
Hmm
Over

server

Server started
Waiting for a client ...
Client accepted
Hello
Hey
Hmm
Over
Closing connection

*/

