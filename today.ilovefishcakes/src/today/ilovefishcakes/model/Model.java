package today.ilovefishcakes.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchEvent.Modifier;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


public class Model {
	
	private JSONObject objAscii;
	private JSONObject objTexts;
	private String address = "http://62.233.106.70/";
	private String aFolder = "ascii/";
	private String tFolder = "texts/";
	private String texts, ascii;
	private String tempA = "a.tmp";
	private String tempT = "t.tmp";
	
	
	public Model() {
		
		Path fileA = Paths.get(tempA);
		Path fileT = Paths.get(tempT);
	
		URL website;
		
		try {
			website = new URL(address + aFolder + "ascii.json");
			Files.copy(website.openStream(), fileA, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			website = new URL(address + tFolder + "texts.json");
			Files.copy(website.openStream(), fileT, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		try {
			texts = new Scanner(new File(tempT)).useDelimiter("\\Z").next();
			ascii = new Scanner(new File(tempA)).useDelimiter("\\Z").next();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		objAscii = (JSONObject) JSONValue.parse(ascii);
		objTexts = (JSONObject) JSONValue.parse(texts);
		
	}
	
	public String getAscii() {
		
		Random randomGen = new Random();
		String index = "" + randomGen.nextInt(objAscii.size() - 1);
		
		Path fileA = Paths.get(tempA);
	
		URL website;
		
		try {
			website = new URL(address + aFolder + objAscii.get(index));
			Files.copy(website.openStream(), fileA, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
		ascii = new Scanner(new File(tempA)).useDelimiter("\\Z").next();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return ascii;
	}
	
	public String getText(){
		
		Random randomGen = new Random();
		String index = "" + randomGen.nextInt(objTexts.size() -1);
		
		return (String) objTexts.get(index);
	}
	
	public static void main(String[] args) throws IOException {
		
		
		
		Model m = new Model();
		System.out.println("<!DOCTYPE html> \n <html> \n <body>");
		System.out.println(m.getAscii());
		System.out.println("<h2>"+m.getText()+"</h2>");
		System.out.println("</body> \n </html>");
	
	}
	
	

}
