package Algorithm;

import com.dwt.Base64Codec;
import java.security.SignatureException;
import java.util.Random;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HMAC {

    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
    static int keyData = 0;

    public static String calculateCode(String data, String key)
            throws java.security.SignatureException {
        String result, results;
        try {

            byte[] keyBytes = key.getBytes();
            SecretKeySpec signingKey = new SecretKeySpec(keyBytes,HMAC_SHA1_ALGORITHM);
            
            
            
             System.out.println("keyBytes="+keyBytes);
              
            System.out.println("signingKey"+signingKey);
            Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
            mac.init(signingKey);

            byte[] rawHmac = mac.doFinal(data.getBytes());
 System.out.println("rawHmac="+rawHmac);
            
            result = Base64Codec.encode(new String(rawHmac));
             System.out.println("result"+result);
          
            Random rand7 = new Random();
            keyData = 10 + rand7.nextInt(9);
            System.out.println("key = " + key);
            String keyss = "" + keyData;
            System.out.println("keyss"+keyss);
          
            results = result + keyss;

        } catch (Exception e) {
            throw new SignatureException("Failed to generate HMAC : "
                    + e.getMessage());
        }
        return results;
    }
}