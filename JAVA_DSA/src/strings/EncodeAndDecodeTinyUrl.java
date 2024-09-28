package strings;

import java.util.*;

public class EncodeAndDecodeTinyUrl {

    HashMap<String, String> codeDb = new HashMap<>();
    HashMap<String, String> urlDb = new HashMap<>();
    final String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (urlDb.containsKey(longUrl)) {
            return urlDb.get(longUrl);
        }
        String encoded = code(longUrl);
        while (codeDb.containsKey(encoded)) {
            encoded = code(longUrl);
        }
        urlDb.put(longUrl, encoded);
        codeDb.put(encoded, longUrl);
        return encoded;
    }

    private String code(String longUrl) {
        char[] ans = new char[6];
        for (int i = 0; i < 6; i++) {
            ans[i] = chars.charAt((int) (Math.random() * 62));
        }
        return "http://succDicc.com/" + String.valueOf(ans);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return codeDb.get(shortUrl);
    }

}
