package cryptoWilku;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.concurrent.TimeUnit;

public class CryptoWilkuBenchmark {

    /* DATA FOR BENCHMARKS */
    @State(Scope.Thread)
    public static class MyState{
        
        // 5-chars-long password
        public String shortPassword = "Hasło";

        // 60-chars-long password
        public String longPassword = "BaaardzoDługieHasło_i_BaaaaaardzoTrudneDoZłamania1234567890=";

        // 40-chars-long text to encrypt
        public String shortString = "#Króciutki tajny tekst do zaszyfrowania#";

        // 1050-chars-long text to encrypt
        public String longString = "AAAAAAAAAAAAAAAAAAAAAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPQQQQRRSSTTTTUUUVVVXXXYYYYZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ";
    }


    /* BENCHMARKS */
    @Benchmark
    public String applyCryptoLongTextShortPassword(MyState state){
        return CryptoWilku.applyCrypto(state.longString, state.shortPassword);
    }

    @Benchmark
    public String applyCryptoLongTextLongPassword(MyState state){
        return CryptoWilku.applyCrypto(state.longString, state.longPassword);
    }

    @Benchmark
    public String applyCryptoShortTextShortPassword(MyState state){
        return CryptoWilku.applyCrypto(state.shortString, state.shortPassword);
    }

    @Benchmark
    public String applyCryptoShortTextLongPassword(MyState state){
        return CryptoWilku.applyCrypto(state.shortString, state.longPassword);
    }

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(CryptoWilkuBenchmark.class.getSimpleName())
                .forks(1)
                .mode(Mode.All)
                .timeUnit(TimeUnit.MILLISECONDS)
                .measurementIterations(10)
                .measurementTime(TimeValue.milliseconds(150))
                .warmupIterations(10)
                .warmupTime(TimeValue.milliseconds(150))
                .build();

        new Runner(opt).run();
    }
}
