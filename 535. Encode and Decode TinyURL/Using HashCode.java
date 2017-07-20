public class Codec {
    Map<Integer, String> map = new HashMap<>();
    public String encode(String longUrl) {
        map.put(longUrl.hashCode(), longUrl);
        return "https://tinyurl.com/" + longUrl.hashCode();
    }
    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("https://tinyurl.com/", "")));
    }
}