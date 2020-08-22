/*
package company.visa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class GetMovieTitles {
	public static void main(String[] args) {
		getMovieTitles("spiderman");
	}

	public static String[] getMovieTitles(String substr) {
		String response;
		int startPage = 1;
		int totalPages = Integer.MAX_VALUE;
		List<String> titles = new ArrayList<>();
		while (startPage <= totalPages) {
			try {
				URL obj = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr + "&page=" + startPage);
				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				con.setRequestMethod("GET");
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				while ((response = in.readLine()) != null) {
					JsonObject convertedObject = new Gson().fromJson(response, JsonObject.class);
					System.out.println("convertedObject:=>"+convertedObject);
					totalPages = convertedObject.get("total_pages").getAsInt();
					JsonArray data = convertedObject.getAsJsonArray("data");
					for (int i = 0; i < data.size(); i++) {
						String title = data.get(i).getAsJsonObject().get("Title").getAsString();
						titles.add(title);
					}
				}
				in.close();
				startPage++;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		Collections.sort(titles);
		return titles.toArray(new String[0]);
	}
}
*/
