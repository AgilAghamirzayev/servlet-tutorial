package lesson2.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BiFunc{

    public static void main(String[] args) {

        List<String> list1 = Arrays.asList("a","b","c");
        List<Integer> list2 = Arrays.asList(1,2,3);

        mapped().forEach(System.out::println);
        System.out.println(reduce());
        System.out.println();
        biFun(list1,list2).forEach(System.out::println);
        System.out.println();
        listCombiner(list1,list2,(a,b)->a+b).forEach(System.out::println);

    }

    private static List<String> mapped(){
        return Stream.of("hello","world")
                .map(word -> word + "!")
                .collect(Collectors.toList());
    }

    private static String reduce(){
      //  return Stream.of("hello","world").
      //          reduce("",(a,b)->b+"-"+a);

        return Stream.of("hello","world").
                //reduce("",this::combineWithoutTrailingDash)
                //reduce("", BiFunc::combineWithoutTrailingDash);
                  reduce("",(a,b)->combineWithoutTrailingDash(a,b));

    }

    private static String combineWithoutTrailingDash(String a, String b){
        if (a.isEmpty()) return b;
        return b + "-" + a;
    }

    private static List<String> biFun(List<String> list1, List<Integer> list2){
        List<String> result = new ArrayList<>();

        for (int i = 0; i < list1.size(); i++) {
            result.add(list1.get(i) + list2.get(i));
        }

        return result;
    }

    private static <T, U, R> List<R> listCombiner(List<T> list1, List<U> list2, BiFunction<T,U,R> combiner){
        List<R> result = new ArrayList<>();

        for (int i = 0; i < list1.size(); i++) {
            result.add(combiner.apply(list1.get(i),list2.get(i)));
        }

        return result;
    }


}
