package com.agri.mis.config;

import reactor.core.publisher.Flux;

public class ReactiveTest {

    public static void main(String[] args) {
        Flux<Integer> ints = Flux.range(1, 4)
                .map(i -> {
                    if (i <= 3) return i;
                    throw new RuntimeException("Got to 4");
                });

        ints.subscribe(i -> System.out.println(i),
                error -> System.err.println("Error: " + error));
    }
}
