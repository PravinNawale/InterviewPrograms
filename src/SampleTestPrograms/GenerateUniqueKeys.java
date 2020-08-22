package SampleTestPrograms;

import java.util.UUID;

public class GenerateUniqueKeys {
    public static void main(String[] args) {
        String keyByUUID = generateUniqueKeyUsingUUID();
        System.out.println("keyByUUID:=>" + keyByUUID);
        String keyByBase62 = generateUniqueKeyUsingBase62(999);
        System.out.println("keyByBase62:=>" + keyByBase62);
    }

    public static String generateUniqueKeyUsingUUID() {
        final UUID uuid = UUID.randomUUID();
        System.out.println("uuid:=>" + uuid);
        final long moddedToSixDigits = Math.floorMod(uuid.getLeastSignificantBits() ^ uuid.getMostSignificantBits(), 10000000);
        return String.format("%06d", moddedToSixDigits);
    }

    public static String generateUniqueKeyUsingBase62(int dec) {
        String s = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String hashString = "";
        while(dec > 0) {
            hashString = s.charAt(dec % 62) + hashString;
            dec /= 62;
        }
        return hashString;
    }
}
