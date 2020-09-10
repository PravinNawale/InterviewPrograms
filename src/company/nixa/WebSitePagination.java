package company.nixa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WebSitePagination {

    public static void main(String[] args) {
        //fetchItemsToDisplay()
    }

    public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder, int itemsPerPage, int pageNumber) {
        //System.out.println(sortParameter+ " "+ sortOrder +" "+ itemsPerPage + " "+ pageNumber);
        if(sortOrder == 0){
            Collections.sort(items,new Comparator<List<String>>(){
                @Override
                public int compare(List<String> s1, List<String> s2){
                    return s1.get(sortParameter).compareTo(s2.get(sortParameter));
                }
            });
        }else if(sortOrder == 1){
            Collections.sort(items,new Comparator<List<String>>(){
                @Override
                public int compare(List<String> s1, List<String> s2){
                    return s2.get(sortParameter).compareTo(s1.get(sortParameter));
                }
            });
        }
        //System.out.println(items.toString());
        List<String> result = new ArrayList<>();
        int startIndex = 0;
        int endIndex = itemsPerPage ;
        if(pageNumber > 0){
            startIndex =  pageNumber * itemsPerPage;
            endIndex = startIndex + itemsPerPage;
        }
        //System.out.println(items.size() +" "+startIndex + " "+endIndex);
        if(startIndex < items.size()){
            for(int index = startIndex ; index<endIndex && index<items.size(); index++) {
                result.add(items.get(index).get(0));
            }
        }
        //System.out.println(result.toString());
        return result;
    }
}
