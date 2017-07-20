import java.util.HashMap;
import java.util.Random;

public class Codec {
    String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ";
    HashMap<String, String> map = new HashMap<>();
    Random r = new Random();
    String key = getRand();

    private String getRand() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(alphabet.charAt(r.nextInt(62)));
        }
        return sb.toString();
    }

    public String encode(String longUrl) {
        while (map.containsKey(key)) {
            key = getRand();
        }
        map.put(key, longUrl);
        return "https://tinyurl.com/" + key;
    }
    
    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("https://tinyurl.com/", ""));
    }
    
    
}