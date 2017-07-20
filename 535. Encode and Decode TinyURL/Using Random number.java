import java.util.Map;
import java.util.Random;

public class Codec {
    Map<Integer, String> map = new HashMap<>();
    Random r = new Random();
    int key = r.nextInt();

    public String encode(String longUrl) {
        while (map.containsKey(key)) {
            key = r.nextInt();
        }
        map.put(key, longUrl);
        return "https://tinyurl.com/" + key;
    }

    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("https://tinyurl.com/", "")));

    }
}