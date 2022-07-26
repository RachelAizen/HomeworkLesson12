import com.mysql.cj.xdevapi.JsonArray;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Scanner;

public class CurrencyConvertor {

public static void main(String[] args) throws IOException{
System.out.println("Welcome to currency convertor!");
System.out.println("Please enter an amount of dollars to convert:");
Scanner scanner = new Scanner(System.in);
OkHttpClient client = new OkHttpClient();
Request request =  new Request.Builder().url("https://api.exchangeratesapi.io/latest?base=USD").build();
Response response = client.newCall(request).execute();
String jsonData = response.body().string();
JSONObject mainJsonObject = new JSONObject(jsonData);
JSONObject ratesJsonObject = mainJsonObject.getJSONObject("rates");
System.out.println("Result isL " + (scanner.nextDouble() * ratesJsonObject.getDouble("ILS")));
System.out.println("Thanks for using currency convertor!");}
}
