package company.ubs;

public class FindSequenceSum {
    public static void main(String[] args) {
        long result=0;
        int i=5,j=9,k=6;
        for(long start=i;start<=j;start++){
            result=result+start;
        }
        System.out.println("Value is:"+result);
        for(long end=j-1;end>=k;end--){
            result=result+end;
        }
        System.out.println("Value is"+result);
    }
}
