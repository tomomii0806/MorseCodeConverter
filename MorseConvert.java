
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.io.PrintWriter;

public class MorseConvert implements Converter {

	
	
	private String file;

	private String letter;
	private String morse;
	private HashMap<String, String> letterToCode = new HashMap<>();
	private HashMap<String, String> codeToLetter = new HashMap<>();

	public MorseConvert(String file) throws IOException {
		super();
		
		File f = new File(file);
		Scanner scanner = new Scanner(f);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			
		
		String fields[] = line.split(" ");
		letterToCode.put(fields[0], fields[1]);
		codeToLetter.put(fields[0], fields[1]);
		}
		letterToCode.put(" ", " ");
		codeToLetter.put(" ", " ");
	}
	

	@Override
	public void printKeyValuePairs() {
		// TODO Auto-generated method stub
		for (String name : codeToLetter.keySet()) {
			String key = name.toString();
			String value = codeToLetter.get(name).toString();
			System.out.println(key + " " + value);
		}

	}

	@Override
	public String encode(String textToEncode)  {
		// TODO Auto-generated method stub
		String key = "";
		StringBuilder sb = new StringBuilder();
		String text[] = textToEncode.split(" ");
		
		for (int i = 0; i < text.length; i++) {  
		
		for (Object s : codeToLetter.keySet())
		{
			key = s.toString();
			String value = codeToLetter.get(s).toString();
			
			if (value.equals(text[i])) {
				
				sb.append(key);
				
				
			}
		}
		}
		
		return sb.toString();
		
	}

	@Override
	public String decode(String textToDecode) {
		// TODO Auto-generated method stub
		
		
		String value = "";
		
		for (Object s : letterToCode.keySet())
		{
			String key = s.toString();
			value = letterToCode.get(s).toString();
			
			if (key.equals(textToDecode)) {
					
				
				System.out.println(value);
				return value + " ";
			}
		}
		return value;
	}

	@Override
	public boolean decodeSaveToFile(String decode, String filename) throws IOException  {
		// TODO Auto-generated method stub
		
		try (PrintWriter out = new PrintWriter(filename)) {
		    out.println(decode);
		}
		
		return true;
	}

	@Override
	public boolean encodeSaveToFile(String encode, String filename) throws IOException {
		// TODO Auto-generated method stub
		
		
		try (PrintWriter out = new PrintWriter(filename)) {
		    out.println(encode);
		}
		return true;
	}

	
}
