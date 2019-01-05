package hash;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.security.NoSuchAlgorithmException;


public class MD5_Benchmark {

    /* DATA FOR BENCHMARKS */
    @State(Scope.Thread)
    public static class MyState{

        public hash.MD5 md5;

        {
            try {
                md5 = new MD5();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        // 40-chars-long text to encrypt
        public String shortString = "#Króciutki tajny tekst do zaszyfrowania#";

        // 1050-chars-long text to encrypt
        public String longString = "AAAAAAAAAAAAAAAAAAAAAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPQQQQRRSSTTTTUUUVVVXXXYYYYZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ";

    }


    /* BENCHMARKS */
    @Benchmark
    public String applyMD5LongText(MyState state){
        return state.md5.generateMD5(state.longString);
    }

    @Benchmark
    public String applyMD5ShortText(MyState state){
        return state.md5.generateMD5(state.shortString);
    }


    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(MD5_Benchmark.class.getSimpleName())
                .forks(1)
                .mode(Mode.All)
                .measurementIterations(10)
                .measurementTime(TimeValue.milliseconds(150))
                .warmupIterations(10)
                .warmupTime(TimeValue.milliseconds(150))
                .build();

        new Runner(opt).run();
    }
}

