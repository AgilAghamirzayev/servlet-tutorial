package lesson2.practice;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BiFuncTest {

    @Test
    void mapped() {
        List<String> mapped = Stream.of("hello", "world")
                .map(word -> word+"!")
                .collect(Collectors.toList());

        assertEquals(mapped.toString(),"[hello!, world!]");
    }

    @Test
    void reduce(){

    }

}