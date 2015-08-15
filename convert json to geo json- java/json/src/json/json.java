package json;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.io.PrintWriter;
import java.util.*;

import json.*;

import org.json.*;

public class json 
{
	static ArrayList<String> bus_id = new ArrayList();
	static String bus_json="var pointData = {\"type\":\"FeatureCollection\",\"features\":[";
	//static String bus_json_breakfast="var pointData_breakfast = {\"type\":\"FeatureCollection\",\"features\":[";
	//static String bus_json_lunch="var pointData_lunch = {\"type\":\"FeatureCollection\",\"features\":[";
	//static String bus_json_latenight="var pointData_latenight = {\"type\":\"FeatureCollection\",\"features\":[";
	//static String bus_json_dinner="var pointData_dinner = {\"type\":\"FeatureCollection\",\"features\":[";
	//static String bus_json_dessert="var pointData_dessert = {\"type\":\"FeatureCollection\",\"features\":[";
	//static String bus_json_other="var pointData_other = {\"type\":\"FeatureCollection\",\"features\":[";
	static String business = "";
	public static void main(String args[]) throws IOException, JSONException
	{
		
		String bus_file = "C:/Users/Rohan Jawali/Desktop/DV_Final_Project/Final Project/yelp_dataset_challenge_academic_dataset/yelp_dataset_challenge_academic_dataset/Data_Set/New/businessProc.txt";
		System.out.println("1");
		

		business = getString(bus_file, business);
		System.out.println("Done reading business");
		JSONArray jsonarr = new JSONArray(business);
		System.out.println("Done converting to JSON");
	
		System.out.println("Entering");
	    for(int i = 0; i < jsonarr.length(); i++)
	    {
	    	JSONObject jsonobj = jsonarr.getJSONObject(i);
	    	String addr = jsonobj.getString("full_address");
	    	char addr_char[] = addr.toCharArray();
	    	char add[] = new char [addr_char.length];
	    	String breakfast ="false" , dinner ="false", lunch="false", brunch="false", latenight="false", dessert="false";
	    	String thai = "false", american = "false", mexican= "false", japanese = "false", chinese = "false", greek = "false", italian = "false", Indian = "false", french = "false"; 
	    	int count = 0;
	    	for(int i1=0; i1< addr_char.length; i1++) 
	    	{
	    		if(addr_char[i1] != '\n')
	    		{
	    			add[count++] = addr_char[i1];
	    		}
	    		else
	    		{
	    			
	    		}
	    	}
	    	
	    	if (count > 0)
	    	{
	    	for (int i1= count; i1<addr_char.length; i1++)
	    		add[i1] = ' ';
	    	}
	    	addr = String.valueOf(add);
	        addr = addr.replace("\n", "").replace("\r", "");
	    	if(jsonobj.getJSONObject("attributes").toString().contains("\"dessert\":true"))
	    	{
	    		dessert = "true";
	    		//bus_json_dessert += "{\"type\":\"Feature\",\"properties\":{\"busid\":\""+jsonobj.getString("business_id")+"\", \"name\":\""+jsonobj.getString("name")+"\", \"address\":\""+ addr+"\", \"stars\":"+ jsonobj.getInt("stars")+"},\"geometry\":{\"type\":\"Point\",\"coordinates\":["+jsonobj.getDouble("longitude")+","+jsonobj.getDouble("latitude")+"]}},\n";
	    	}
	    	if(jsonobj.getJSONObject("attributes").toString().contains("\"brunch\":true"))
	    	{
	    		brunch = "true";
	    		//bus_json_brunch += "{\"type\":\"Feature\",\"properties\":{\"busid\":\""+jsonobj.getString("business_id")+"\", \"name\":\""+jsonobj.getString("name")+"\", \"address\":\""+ addr+"\", \"stars\":"+ jsonobj.getInt("stars")+"},\"geometry\":{\"type\":\"Point\",\"coordinates\":["+jsonobj.getDouble("longitude")+","+jsonobj.getDouble("latitude")+"]}},\n";
	    	}
	    	if(jsonobj.getJSONObject("attributes").toString().contains("\"lunch\":true"))
	    	{
	    		lunch = "true";
	    		//bus_json_lunch += "{\"type\":\"Feature\",\"properties\":{\"busid\":\""+jsonobj.getString("business_id")+"\", \"name\":\""+jsonobj.getString("name")+"\", \"address\":\""+ addr+"\", \"stars\":"+ jsonobj.getInt("stars")+"},\"geometry\":{\"type\":\"Point\",\"coordinates\":["+jsonobj.getDouble("longitude")+","+jsonobj.getDouble("latitude")+"]}},\n";
	    	}
	    	if(jsonobj.getJSONObject("attributes").toString().contains("\"breakfast\":true"))
	    	{
	    		breakfast = "true";
	    		//bus_json_breakfast += "{\"type\":\"Feature\",\"properties\":{\"busid\":\""+jsonobj.getString("business_id")+"\", \"name\":\""+jsonobj.getString("name")+"\", \"address\":\""+ addr+"\", \"stars\":"+ jsonobj.getInt("stars")+"},\"geometry\":{\"type\":\"Point\",\"coordinates\":["+jsonobj.getDouble("longitude")+","+jsonobj.getDouble("latitude")+"]}},\n";
	    	}
	    	if(jsonobj.getJSONObject("attributes").toString().contains("\"latenight\":true"))
	    	{
	    		latenight = "true";
	    		//bus_json_latenight += "{\"type\":\"Feature\",\"properties\":{\"busid\":\""+jsonobj.getString("business_id")+"\", \"name\":\""+jsonobj.getString("name")+"\", \"address\":\""+ addr+"\", \"stars\":"+ jsonobj.getInt("stars")+"},\"geometry\":{\"type\":\"Point\",\"coordinates\":["+jsonobj.getDouble("longitude")+","+jsonobj.getDouble("latitude")+"]}},\n";
	    	}
	    	if(jsonobj.getJSONObject("attributes").toString().contains("\"dinner\":true"))
	    	{
	    		dinner = "true";
	    		//bus_json_dinner += "{\"type\":\"Feature\",\"properties\":{\"busid\":\""+jsonobj.getString("business_id")+"\", \"name\":\""+jsonobj.getString("name")+"\", \"address\":\""+ addr+"\", \"stars\":"+ jsonobj.getInt("stars")+"},\"geometry\":{\"type\":\"Point\",\"coordinates\":["+jsonobj.getDouble("longitude")+","+jsonobj.getDouble("latitude")+"]}},\n";
	    	}
	    	if(jsonobj.getJSONArray("categories").toString().contains("\"Thai\""))
	    	{
	    		System.out.print("Hello");
	    		thai = "true";
	    		//bus_json_dinner += "{\"type\":\"Feature\",\"properties\":{\"busid\":\""+jsonobj.getString("business_id")+"\", \"name\":\""+jsonobj.getString("name")+"\", \"address\":\""+ addr+"\", \"stars\":"+ jsonobj.getInt("stars")+"},\"geometry\":{\"type\":\"Point\",\"coordinates\":["+jsonobj.getDouble("longitude")+","+jsonobj.getDouble("latitude")+"]}},\n";
	    	}
	    	if(jsonobj.getJSONArray("categories").toString().contains("\"American\""))
	    	{
	    		american = "true";
	    		//bus_json_dinner += "{\"type\":\"Feature\",\"properties\":{\"busid\":\""+jsonobj.getString("business_id")+"\", \"name\":\""+jsonobj.getString("name")+"\", \"address\":\""+ addr+"\", \"stars\":"+ jsonobj.getInt("stars")+"},\"geometry\":{\"type\":\"Point\",\"coordinates\":["+jsonobj.getDouble("longitude")+","+jsonobj.getDouble("latitude")+"]}},\n";
	    	}
	    	if(jsonobj.getJSONArray("categories").toString().contains("\"Mexican\""))
	    	{
	    		mexican = "true";
	    		//bus_json_dinner += "{\"type\":\"Feature\",\"properties\":{\"busid\":\""+jsonobj.getString("business_id")+"\", \"name\":\""+jsonobj.getString("name")+"\", \"address\":\""+ addr+"\", \"stars\":"+ jsonobj.getInt("stars")+"},\"geometry\":{\"type\":\"Point\",\"coordinates\":["+jsonobj.getDouble("longitude")+","+jsonobj.getDouble("latitude")+"]}},\n";
	    	}
	    	if(jsonobj.getJSONArray("categories").toString().contains("\"Japanese\""))
	    	{
	    		japanese = "true";
	    		//bus_json_dinner += "{\"type\":\"Feature\",\"properties\":{\"busid\":\""+jsonobj.getString("business_id")+"\", \"name\":\""+jsonobj.getString("name")+"\", \"address\":\""+ addr+"\", \"stars\":"+ jsonobj.getInt("stars")+"},\"geometry\":{\"type\":\"Point\",\"coordinates\":["+jsonobj.getDouble("longitude")+","+jsonobj.getDouble("latitude")+"]}},\n";
	    	}
	    	if(jsonobj.getJSONArray("categories").toString().contains("\"Chinese\""))
	    	{
	    		chinese = "true";
	    		//bus_json_dinner += "{\"type\":\"Feature\",\"properties\":{\"busid\":\""+jsonobj.getString("business_id")+"\", \"name\":\""+jsonobj.getString("name")+"\", \"address\":\""+ addr+"\", \"stars\":"+ jsonobj.getInt("stars")+"},\"geometry\":{\"type\":\"Point\",\"coordinates\":["+jsonobj.getDouble("longitude")+","+jsonobj.getDouble("latitude")+"]}},\n";
	    	}
	    	if(jsonobj.getJSONArray("categories").toString().contains("\"Greek\""))
	    	{
	    		greek = "true";
	    		//bus_json_dinner += "{\"type\":\"Feature\",\"properties\":{\"busid\":\""+jsonobj.getString("business_id")+"\", \"name\":\""+jsonobj.getString("name")+"\", \"address\":\""+ addr+"\", \"stars\":"+ jsonobj.getInt("stars")+"},\"geometry\":{\"type\":\"Point\",\"coordinates\":["+jsonobj.getDouble("longitude")+","+jsonobj.getDouble("latitude")+"]}},\n";
	    	}
	    	if(jsonobj.getJSONArray("categories").toString().contains("\"Italian\""))
	    	{
	    		italian = "true";
	    		//bus_json_dinner += "{\"type\":\"Feature\",\"properties\":{\"busid\":\""+jsonobj.getString("business_id")+"\", \"name\":\""+jsonobj.getString("name")+"\", \"address\":\""+ addr+"\", \"stars\":"+ jsonobj.getInt("stars")+"},\"geometry\":{\"type\":\"Point\",\"coordinates\":["+jsonobj.getDouble("longitude")+","+jsonobj.getDouble("latitude")+"]}},\n";
	    	}
	    	if(jsonobj.getJSONArray("categories").toString().contains("\"Indian\""))
	    	{
	    		Indian = "true";
	    		//bus_json_dinner += "{\"type\":\"Feature\",\"properties\":{\"busid\":\""+jsonobj.getString("business_id")+"\", \"name\":\""+jsonobj.getString("name")+"\", \"address\":\""+ addr+"\", \"stars\":"+ jsonobj.getInt("stars")+"},\"geometry\":{\"type\":\"Point\",\"coordinates\":["+jsonobj.getDouble("longitude")+","+jsonobj.getDouble("latitude")+"]}},\n";
	    	}
	    	if(jsonobj.getJSONArray("categories").toString().contains("\"French\""))
	    	{
	    		french = "true";
	    		//bus_json_dinner += "{\"type\":\"Feature\",\"properties\":{\"busid\":\""+jsonobj.getString("business_id")+"\", \"name\":\""+jsonobj.getString("name")+"\", \"address\":\""+ addr+"\", \"stars\":"+ jsonobj.getInt("stars")+"},\"geometry\":{\"type\":\"Point\",\"coordinates\":["+jsonobj.getDouble("longitude")+","+jsonobj.getDouble("latitude")+"]}},\n";
	    	}
	    	
	    	//else
	    		//bus_json_other += "{\"type\":\"Feature\",\"properties\":{\"busid\":\""+jsonobj.getString("business_id")+"\", \"name\":\""+jsonobj.getString("name")+"\", \"address\":\""+ addr+"\", \"stars\":"+ jsonobj.getInt("stars")+"},\"geometry\":{\"type\":\"Point\",\"coordinates\":["+jsonobj.getDouble("longitude")+","+jsonobj.getDouble("latitude")+"]}},\n";
	    	//System.out.println(jsonobj.getJSONObject("attributes"));
	    	bus_json += "{\"type\":\"Feature\",\"properties\":{\"busid\":\""+jsonobj.getString("business_id")+"\", \"name\":\""+jsonobj.getString("name")+"\", \"address\":\""+ addr+"\", \"stars\":"+ jsonobj.getInt("stars")+",\"breakfast\":"+breakfast+",\"brunch\":"+brunch+",\"lunch\":"+lunch+",\"dinner\":"+dinner+",\"latenight\":"+latenight+",\"dessert\":"+dessert+",\"Thai\":"+thai+",\"American\":"+american+",\"Mexican\":"+mexican+",\"Japanese\":"+japanese+",\"Chinese\":"+chinese+",\"Greek\":"+greek+",\"Italian\":"+italian+",\"Indian\":"+Indian+",\"French\":"+french+"},\"geometry\":{\"type\":\"Point\",\"coordinates\":["+jsonobj.getDouble("longitude")+","+jsonobj.getDouble("latitude")+"]}},\n";
		}
	    
	   
	    PrintWriter out = new PrintWriter("C:/Users/Rohan Jawali/Desktop/DV_Final_Project/Final Project/yelp_dataset_challenge_academic_dataset/yelp_dataset_challenge_academic_dataset/business_json.txt");
	    //out.println(bus_json_brunch+"]};");
	    //out.println(bus_json_breakfast+"]};");
	    //out.println(bus_json_dessert+"]};");
	    //out.println(bus_json_dinner+"]};");
	    //out.println(bus_json_latenight+"]};");
	    //out.println(bus_json_lunch+"]};");
	    out.println(bus_json+"]};");
	    out.close();
	    
	    System.out.println("Done with business");
	    
	    
		
	}
	
	public static String getString(String file, String init) throws IOException
	{
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       init += line;
		    }
		    
    return init;
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
		return init;
	}
	
	public static String getString2(String file, String init) throws IOException
	{
		//int counters =0;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	//System.out.println(counters++);
		       init += line+",";
		    }
		    
		    char bus_arr[] = init.toCharArray();
		    bus_arr[init.length()-1] = ']';

		    init = String.valueOf(bus_arr);
		    //System.out.println(init);
		    return init;
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
		return init;
	}
}
