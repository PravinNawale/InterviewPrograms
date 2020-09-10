package SampleTestPrograms;

import java.util.*;

public class WebSitePagination {
    public static void main(String[] args) {
        List<String> item1 = Arrays.asList(new String[]{"p1", "1", "2"});
        List<String> item2 = Arrays.asList(new String[]{"p2", "2", "1"});
        List<List<String>> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        List<String> result = webSitePagination(items, 0, 0, 1, 0);
        System.out.println("Output:=>" + result);
    }

    public static List<String> webSitePagination(List<List<String>> items, int sortParameter, int sortOrder, int itemsPerPage, int pageNumber) {
        HashMap<Integer, List<String>> mapList = new HashMap<>();
        TreeSet<Items> itemsList = new TreeSet<>(new Comparator<Items>() {
            @Override
            public int compare(Items o1, Items o2) {
                switch (sortParameter) {
                    case 0:
                        return sortOrder == 0 ? o1.name.hashCode() - o2.name.hashCode() : o2.name.hashCode() - o1.name.hashCode();
                    case 1:
                        return sortOrder == 0 ? o1.relevance.hashCode() - o2.relevance.hashCode() : o2.relevance.hashCode() - o1.relevance.hashCode();
                    case 2:
                        return sortOrder == 0 ? o1.price.hashCode() - o2.price.hashCode() : o2.price.hashCode() - o1.price.hashCode();
                }
                return 0;
            }
        });
        items.forEach(record -> {
            Items item = new Items(record.get(0), record.get(1), record.get(2));
            itemsList.add(item);
        });

        int pageNumberCount = 0;
        Iterator<Items> iterator = itemsList.iterator();
        while (iterator.hasNext()) {
            List<String> tempList = new ArrayList<>();
            for (int i = 0; i < itemsPerPage; i++) {
                if(iterator.hasNext()) {
                    tempList.add(iterator.next().name);
                }
            }
            mapList.put(pageNumberCount, tempList);
            pageNumberCount++;
        }
        return mapList.get(pageNumber);
    }
}

class Items {
    String name;
    String relevance;
    String price;

    public Items(String name, String relevance, String price) {
        this.name = name;
        this.relevance = relevance;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelevance() {
        return relevance;
    }

    public void setRelevance(String relevance) {
        this.relevance = relevance;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Items items = (Items) o;
        return Objects.equals(name, items.name) &&
                Objects.equals(relevance, items.relevance) &&
                Objects.equals(price, items.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, relevance, price);
    }

    @Override
    public String toString() {
        return "Items{" +
                "name='" + name + '\'' +
                ", relevance='" + relevance + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}