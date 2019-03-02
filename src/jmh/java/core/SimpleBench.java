package core;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;

public class SimpleBench {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void bench(){

        for (int i = 0; i < 1000; i++) {
            System.out.println(Math.pow(2, 4));
        }

    }

}
