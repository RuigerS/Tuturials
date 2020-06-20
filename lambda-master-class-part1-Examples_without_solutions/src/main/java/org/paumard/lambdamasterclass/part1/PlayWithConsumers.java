package org.paumard.lambdamasterclass.part1;

import java.util.function.Consumer;

public class PlayWithConsumers {
    public static void main(String[] args) {
        // as a  Lambda
        //Consumer<String> consumer= (String t)->{ System.out.println(t); };
        // as a method reference
        Consumer<String> consumer= System.out::println;

        consumer.accept("Hello");
    }
}
