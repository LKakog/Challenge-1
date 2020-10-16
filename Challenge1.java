import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.net.URL;
import java.util.Scanner;

public class Challenge1{
	private static Scanner input = new Scanner(System.in);

	public static void GetEmail(String UserName){
		InputStream response;
		try{
			URL webpageURL = new URL("https://www.ecs.soton.ac.uk/people/"+ UserName);
			response = webpageURL.openStream();
			Scanner scanner = new Scanner(response);
			String responseBody = scanner.useDelimiter("\\A").next();
			System.out.println(responseBody.substring(responseBody.indexOf("<title>") + 7, responseBody.indexOf("</title>")));
        }
        catch (Exception e){
            System.out.println("Error occurred, user name not found");
        }
    }

	public static void main(String Args[]){
		String userName = input.next();
		GetEmail(userName);
	}
}