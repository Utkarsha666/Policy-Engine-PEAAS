
import java.util.Random;

public class KeyGenerator {

    int key = 0;
    int key1 = 0;
    int key2 = 0;
    int key3 = 0;

    public String KeyGenerator() {

        Random rand = new Random();
        Random rand1 = new Random();
        key = 10000000 + rand.nextInt(9999999);
        System.out.println("key = " + key);
        key1 = 10000000 + rand1.nextInt(9999999);
        System.out.println("key = " + key);
        key2 = 10000000 + rand1.nextInt(9999999);
        System.out.println("key = " + key);
        key3 = 10000000 + rand1.nextInt(9999999);
        System.out.println("key = " + key);

        String keyValue = "" + key + key1 + key2 + key3;
        System.out.println("keys = " + keyValue);
        return keyValue;
    }

    public String Generator() {

        Random rand = new Random();
        key = 10000000 + rand.nextInt(9999999);
        System.out.println("key = " + key);
        String keys = "" + key;

        return keys;
    }
}

