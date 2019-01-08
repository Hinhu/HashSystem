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
import java.util.concurrent.TimeUnit;


public class SHA_512_Benchmark {

    /* DATA FOR BENCHMARKS */
    @State(Scope.Thread)
    public static class MyState{

        public SHA_512 sha;

        {
            try {
                sha = new SHA_512();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        // 40-chars-long text to encrypt
        public String shortString = "Lorem ipsum dolor sit amet orci aliquam.";

        // 1050-chars-long text to encrypt
        public String longString = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi maximus sapien non vehicula accumsan. Aenean sed gravida eros. Maecenas imperdiet, eros ut iaculis ornare, risus mauris eleifend eros, eu rhoncus sem metus id sem. Pellentesque egestas mauris ipsum, faucibus tempus erat mattis eget. Aenean a tellus vitae arcu suscipit sollicitudin. Nam vehicula mi vitae commodo varius. Duis aliquet orci ut massa consequat mattis. Fusce vel augue facilisis diam ornare vulputate. Pellentesque vel semper ipsum. Sed efficitur turpis ac hendrerit viverra. Duis sollicitudin pretium maximus.\n" +
                "\n" +
                "Vivamus hendrerit porttitor ligula quis placerat. Donec scelerisque interdum risus, nec suscipit mi tincidunt eget. Aliquam non facilisis mauris. Fusce ullamcorper, orci nec cursus egestas, arcu purus malesuada nunc, sit amet mattis libero nibh imperdiet neque. Mauris a mattis leo. Etiam eu nunc in massa sagittis pulvinar. Pellentesque id elementum neque. Nulla hendrerit ultricies enim, at rhoncus neque cursus at. Ut eu aliquet lectus. Nulla a ex mollis metus.";

    }


    /* BENCHMARKS */
    @Benchmark
    public String generateSHA_512LongText(MyState state){ return state.sha.generateSHA_512(state.longString); }

    @Benchmark
    public String generateSHA_512ShortText(MyState state){ return state.sha.generateSHA_512(state.shortString); }


    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(SHA_512_Benchmark.class.getSimpleName())
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

