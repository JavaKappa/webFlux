package com.learnreactive.fluxmono;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class FluxAndMonoTest {

    @Test
    public void fluxTest() {
        Flux<String> springTypes = Flux.just("Spring", "SpringBoot", "Reactive Spring")
//            .concatWith(Flux.error(new RuntimeException("something go wrong")))
            .concatWith(Flux.just("After error"))
            .log();

        springTypes
            .subscribe(
                System.out::println,
                x -> System.err.println(x + " error consumer works!"),
                () -> System.out.println(System.lineSeparator() + "That's complete")
            );
    }
}
