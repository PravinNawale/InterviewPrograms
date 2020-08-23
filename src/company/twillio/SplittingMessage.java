package company.twillio;

import java.util.ArrayList;
import java.util.List;

/*
    Program: https://leetcode.com/discuss/interview-question/394697/Twilio-or-OA-2019
*/
public class SplittingMessage {
    public static void main(String[] args) {
        final List<String> list = segments("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis partu sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore ver rup. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa.");
        System.out.println(list.toString());
    }

    public static List<String> segments(final String message){
        final List<String> messageSegments = new ArrayList<>();
        if (message.length() < 160) {
            messageSegments.add(message);
            return messageSegments;
        }

        int maxLen = 154;
        int startIndex = 0, endIndex = startIndex + maxLen;
        while (endIndex < message.length()) {
            if (message.charAt(endIndex) != ' ') {
                while (endIndex >= startIndex && message.charAt(endIndex) != ' ' && message.charAt(endIndex + 1) != ' ') {
                    endIndex--;
                }
            }
            messageSegments.add(message.substring(startIndex, endIndex+ 1));
            startIndex = endIndex + 1;
            endIndex = startIndex + maxLen;
        }
        messageSegments.add(message.substring(startIndex));

        for (int index = 0; index < messageSegments.size(); index++) {
            messageSegments.set(index, messageSegments.get(index)+"(" + (index + 1) + "/" + (messageSegments.size()) + ")");
        }
        return messageSegments;
    }
}
