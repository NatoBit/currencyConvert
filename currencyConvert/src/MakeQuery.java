import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MakeQuery {
    public Query makeQuery(String baseCurrency, String targetCurrency){
        String key = ""; // Get your key on https://app.exchangerate-api.com/
        URI dir = URI.create("https://v6.exchangerate-api.com/v6/" + key + "/pair/" + baseCurrency + "/" + targetCurrency);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(dir)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Query.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Error in the query.");
        }
    }
}
