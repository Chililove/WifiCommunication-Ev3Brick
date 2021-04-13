import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class client {
	
	public static void main(String[] args) {
		
		try (
			
			Socket s = new Socket("192.168.0.17", 5000);
			
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			
			Scanner sc = new Scanner(System.in);
				
			)
		
		{
			
			System.out.println("Connection to abc ....");
			
			boolean done = false;
			while(!done) {
				
				System.out.println("Send message: ");
				String message = sc.nextLine();
				
				dos.writeUTF(message);
				dos.flush();
				
				String ev3Message = dis.readUTF();
				System.out.println("abc says: " + ev3Message);
				
				if(message.equalsIgnoreCase("quit"))
{
					
					done = true;
				}
			}
			System.out.println("Client terminating");
				
			}
		catch (IOException e) {
			
			System.out.println("mistake");
		
			}
			
		}
	}


