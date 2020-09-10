package company.nixa;

import java.util.HashMap;
import java.util.Iterator;

/*
    https://leetcode.com/discuss/interview-question/378237/Twitter-or-OA-2019-or-Authentication-Tokens
 */
public class AuthenticationTokens {
    public static void main(String[] args) {
        int exp = 4;
        int[][] arr = new int[][]{{0,1,2},{0,2,2},{1,2,5},{1,2,7}};
        System.out.println(numberOfTokens(exp,arr));
    }

    public static int numberOfTokens(int expiryLimit, int commands[][]) {
        HashMap<Integer, Integer> set = new HashMap<>();
        for (int[] token: commands) {
            if (token[0] == 1) {
                if (set.containsKey(token[1])) {
                    set.put(token[1], token[2]+expiryLimit);
                }
            }
            else set.put(token[1], token[2]+expiryLimit);
            Iterator<Integer> iterator = set.keySet().iterator();
            while(iterator.hasNext()) {
                int id = iterator.next();
                if (token[2] > set.get(id)) {
                    iterator.remove();
                }
            }
        }
        return set.size();
    }
}
