import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Scanner;

public class Countries {

private static Scanner scanner;

public static void main(String[] args) throws IOException, JSONException {

System.out.println("Please enter country name or exit");
scanner = new Scanner(System.in);
String input = scanner.next();
getData(input);}

private static void getData(String input) throws IOException
{OkHttpClient client = new OkHttpClient();
Request request = new Request.Builder().url("https://restcountries.com" + input).build();
Response response = client.newCall(request).execute();
String jsonData = response.body().string();
if(response.code() == 404)
{System.out.println("No country...");
chooseAgain();}

JSONArray mainJsonArray = new JSONArray(jsonData);
JSONObject mainJsonObject = (JSONObject) mainJsonArray.get(0);
String region = mainJsonObject.getString("region");
JSONArray codes = mainJsonObject.getJSONArray("codes");
JSONArray borders = mainJsonObject.getJSONArray("borders");
JSONObject currencies = (JSONObject) mainJsonObject.getJSONArray("currencies").get(0);
String sign = (String) currencies.get("sign");
System.out.println(region +" "+ codes + " " + borders +" "+ sign);
chooseAgain();}

private static void chooseAgain() throws IOException
{System.out.println("Please enter country name or exit");
String input = scanner.next();
if(!input.equals("exit")){getData(input);}
else{System.exit(0);}}

}
