
import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		
			
			
		   MorseConvert mc = new MorseConvert("MorseCodeTable.txt");
			
		    String workingDir = System.getProperty("user.dir") + "/";
		  
		    mc.printKeyValuePairs();
		    //mc.decode("a");
		    //mc.encode(".-");
		    
		    String fileName = "Quote2.txt";
		    String copyfileName = "Quote2Copy.txt";
		    String saveFileName = "Quote2Morse.txt";
		   	StringBuilder sb = new StringBuilder();
		   	
		   	File f = new File(saveFileName);
			Scanner scanner = new Scanner(f);
			while (scanner.hasNextLine()) {
				String lines = scanner.nextLine();
			String text[] = lines.split(" ");
			
			for (int i = 0; i < text.length; i++)  
			{
				mc.encode(text[i]);
				
			}
			}
			
		    try (BufferedReader br = new BufferedReader(new FileReader(workingDir + fileName))) {
				String line = "";
				
				while ((line = br.readLine()) != null) {
					
					String[] text = line.split("");
					
					for (String i: text){
						
					    System.out.println(i.toLowerCase());
					    sb.append(mc.decode(i.toLowerCase()));
					   
					}
					
					
					
				}
				 System.out.println(sb);
				
			}catch (FileNotFoundException e) {
				 System.out.print(workingDir + fileName + " File Not found");
				
			} 
			catch (IOException e) {
				e.printStackTrace();
				
			}
		    
		    mc.encodeSaveToFile(sb.toString(), workingDir + saveFileName);
		    String encodeCopy = mc.encode(sb.toString());
		    System.out.println(encodeCopy);
		    mc.decodeSaveToFile(encodeCopy, workingDir + copyfileName);
			
	}

}
