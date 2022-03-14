import java.util.*;
import java.util.stream.Collectors;

public class WordCount {

    public static void wordCount(){
        String test  = "java redis mysql redis redis java";
        String[] array = test.split(" ");
        Map<String,Integer> map = new HashMap<>();
        for (String s: array) {
            map.put(s,map.getOrDefault(s,0)+1);
        }
        List<Map.Entry<String,Integer>> list = map.entrySet().stream()
                .sorted((entry2,entry1)->entry1.getValue().compareTo(entry2.getValue())).collect(Collectors.toList());
        for (Map.Entry<String,Integer> entry:
             list) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

    public static void main(String[] args) {
        wordCount();
    }
}
