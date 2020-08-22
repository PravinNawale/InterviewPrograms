package company.tracelink;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPotentialDomains {

    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader(new File("input.txt")))) {
            Pattern pa = Pattern.compile("http[s]?:\\/\\/(ww[w2]\\.)?(([a-zA-Z0-9\\-]+\\.)+([a-zA-Z\\-])+)");
            TreeSet<String> set = new TreeSet<>();
            String currentLine = reader.readLine();
            while (currentLine != null) {
                Matcher ma = pa.matcher(currentLine);
                while (ma.find()) set.add(ma.group(2));
                currentLine = reader.readLine();
            }
            for (String str : set) {
                System.out.print((str != set.last()) ? str + ";" : str);
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
