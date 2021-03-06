package RSApack;

import hashsystem.RSApack.*;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.concurrent.TimeUnit;


public class RSABenchmark {

    @State(Scope.Thread)
    public static class MyState{

        public long longPrimeNumber1=15659999;
        public long longPrimeNumber2=15660023;

        public PublicKey shortPublicKey=new PublicKey(437,343);

        public PublicKey longPublicKey=new PublicKey(62473207,43856211);;

        public PrivateKey shortPrivateKey=new PrivateKey(437,127);;

        public PrivateKey longPrivateKey=new PrivateKey(62473207,51055691);;

        public String shortText="Lorem ipsum";

        public String longText="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at lacus nunc. Phasellus lobortis ipsum vitae pharetra pretium. Fusce sed consectetur libero, sit amet bibendum nisl. Cras efficitur vel lectus non egestas. Praesent dapibus, nisl id imperdiet consequat, nibh elit iaculis lacus, condimentum blandit libero arcu eget enim. Nam id placerat ligula. Nulla mattis tortor vel dolor ullamcorper, id rutrum purus feugiat. Quisque tempor lobortis eros ac ultrices. Vestibulum auctor porta diam nec luctus.";

        public String shortTextEncryptedWithShortKey="342 168 114 196 33 127 238 359 115 326 33";

        public String longTextEncryptedWithShortKey="342 168 114 196 33 127 238 359 115 326 33 127 271 168 279 168 114 127 115 238 116 127 21 33 196 116 272 127 365 168 186 115 196 365 116 196 116 326 114 127 21 271 238 359 238 115 365 238 186 293 127 196 279 238 116 46 127 70 326 115 365 196 127 21 116 127 279 21 365 326 115 127 186 326 186 365 46 127 270 351 21 115 196 279 279 326 115 127 279 168 174 168 114 116 238 115 127 238 359 115 326 33 127 308 238 116 21 196 127 359 351 21 114 196 116 114 21 127 359 114 196 116 238 326 33 46 127 70 326 115 365 196 127 115 196 271 127 365 168 186 115 196 365 116 196 116 326 114 127 279 238 174 196 114 168 272 127 115 238 116 127 21 33 196 116 127 174 238 174 196 186 271 326 33 127 186 238 115 279 46 127 295 114 21 115 127 196 406 406 238 365 238 116 326 114 127 308 196 279 127 279 196 365 116 326 115 127 186 168 186 127 196 293 196 115 116 21 115 46 127 270 114 21 196 115 196 186 116 127 271 21 359 238 174 326 115 272 127 186 238 115 279 127 238 271 127 238 33 359 196 114 271 238 196 116 127 365 168 186 115 196 341 326 21 116 272 127 186 238 174 351 127 196 279 238 116 127 238 21 365 326 279 238 115 127 279 21 365 326 115 272 127 365 168 186 271 238 33 196 186 116 326 33 127 174 279 21 186 271 238 116 127 279 238 174 196 114 168 127 21 114 365 326 127 196 293 196 116 127 196 186 238 33 46 127 173 21 33 127 238 271 127 359 279 21 365 196 114 21 116 127 279 238 293 326 279 21 46 127 173 326 279 279 21 127 33 21 116 116 238 115 127 116 168 114 116 168 114 127 308 196 279 127 271 168 279 168 114 127 326 279 279 21 33 365 168 114 359 196 114 272 127 238 271 127 114 326 116 114 326 33 127 359 326 114 326 115 127 406 196 326 293 238 21 116 46 127 328 326 238 115 341 326 196 127 116 196 33 359 168 114 127 279 168 174 168 114 116 238 115 127 196 114 168 115 127 21 365 127 326 279 116 114 238 365 196 115 46 127 10 196 115 116 238 174 326 279 326 33 127 21 326 365 116 168 114 127 359 168 114 116 21 127 271 238 21 33 127 186 196 365 127 279 326 365 116 326 115 46";

        public String shortTextEncryptedWithLongKey="60483242 43988014 3130871 5531695 20440319 39134277 56597738 19458533 32330367 42567391 20440319";

        public String longTextEncryptedWithLongKey="60483242 43988014 3130871 5531695 20440319 39134277 56597738 19458533 32330367 42567391 20440319 39134277 14974713 43988014 15594595 43988014 3130871 39134277 32330367 56597738 1922196 39134277 6392963 20440319 5531695 1922196 50466700 39134277 59868108 43988014 29078109 32330367 5531695 59868108 1922196 5531695 1922196 42567391 3130871 39134277 6392963 14974713 56597738 19458533 56597738 32330367 59868108 56597738 29078109 24630421 39134277 5531695 15594595 56597738 1922196 38437099 39134277 13755624 42567391 32330367 59868108 5531695 39134277 6392963 1922196 39134277 15594595 6392963 59868108 42567391 32330367 39134277 29078109 42567391 29078109 59868108 38437099 39134277 25050735 35323345 6392963 32330367 5531695 15594595 15594595 42567391 32330367 39134277 15594595 43988014 53617594 43988014 3130871 1922196 56597738 32330367 39134277 56597738 19458533 32330367 42567391 20440319 39134277 27139262 56597738 1922196 6392963 5531695 39134277 19458533 35323345 6392963 3130871 5531695 1922196 3130871 6392963 39134277 19458533 3130871 5531695 1922196 56597738 42567391 20440319 38437099 39134277 13755624 42567391 32330367 59868108 5531695 39134277 32330367 5531695 14974713 39134277 59868108 43988014 29078109 32330367 5531695 59868108 1922196 5531695 1922196 42567391 3130871 39134277 15594595 56597738 53617594 5531695 3130871 43988014 50466700 39134277 32330367 56597738 1922196 39134277 6392963 20440319 5531695 1922196 39134277 53617594 56597738 53617594 5531695 29078109 14974713 42567391 20440319 39134277 29078109 56597738 32330367 15594595 38437099 39134277 44247452 3130871 6392963 32330367 39134277 5531695 37319911 37319911 56597738 59868108 56597738 1922196 42567391 3130871 39134277 27139262 5531695 15594595 39134277 15594595 5531695 59868108 1922196 42567391 32330367 39134277 29078109 43988014 29078109 39134277 5531695 24630421 5531695 32330367 1922196 6392963 32330367 38437099 39134277 25050735 3130871 6392963 5531695 32330367 5531695 29078109 1922196 39134277 14974713 6392963 19458533 56597738 53617594 42567391 32330367 50466700 39134277 29078109 56597738 32330367 15594595 39134277 56597738 14974713 39134277 56597738 20440319 19458533 5531695 3130871 14974713 56597738 5531695 1922196 39134277 59868108 43988014 29078109 32330367 5531695 25130650 42567391 6392963 1922196 50466700 39134277 29078109 56597738 53617594 35323345 39134277 5531695 15594595 56597738 1922196 39134277 56597738 6392963 59868108 42567391 15594595 56597738 32330367 39134277 15594595 6392963 59868108 42567391 32330367 50466700 39134277 59868108 43988014 29078109 14974713 56597738 20440319 5531695 29078109 1922196 42567391 20440319 39134277 53617594 15594595 6392963 29078109 14974713 56597738 1922196 39134277 15594595 56597738 53617594 5531695 3130871 43988014 39134277 6392963 3130871 59868108 42567391 39134277 5531695 24630421 5531695 1922196 39134277 5531695 29078109 56597738 20440319 38437099 39134277 56394955 6392963 20440319 39134277 56597738 14974713 39134277 19458533 15594595 6392963 59868108 5531695 3130871 6392963 1922196 39134277 15594595 56597738 24630421 42567391 15594595 6392963 38437099 39134277 56394955 42567391 15594595 15594595 6392963 39134277 20440319 6392963 1922196 1922196 56597738 32330367 39134277 1922196 43988014 3130871 1922196 43988014 3130871 39134277 27139262 5531695 15594595 39134277 14974713 43988014 15594595 43988014 3130871 39134277 42567391 15594595 15594595 6392963 20440319 59868108 43988014 3130871 19458533 5531695 3130871 50466700 39134277 56597738 14974713 39134277 3130871 42567391 1922196 3130871 42567391 20440319 39134277 19458533 42567391 3130871 42567391 32330367 39134277 37319911 5531695 42567391 24630421 56597738 6392963 1922196 38437099 39134277 34947387 42567391 56597738 32330367 25130650 42567391 5531695 39134277 1922196 5531695 20440319 19458533 43988014 3130871 39134277 15594595 43988014 53617594 43988014 3130871 1922196 56597738 32330367 39134277 5531695 3130871 43988014 32330367 39134277 6392963 59868108 39134277 42567391 15594595 1922196 3130871 56597738 59868108 5531695 32330367 38437099 39134277 55729740 5531695 32330367 1922196 56597738 53617594 42567391 15594595 42567391 20440319 39134277 6392963 42567391 59868108 1922196 43988014 3130871 39134277 19458533 43988014 3130871 1922196 6392963 39134277 14974713 56597738 6392963 20440319 39134277 29078109 5531695 59868108 39134277 15594595 42567391 59868108 1922196 42567391 32330367 38437099";
    }


    @Benchmark
    public Key[] generateLongKeys(MyState state) {
        Key[] keys=null;
        try {
            keys = RSA.generateKeys(state.longPrimeNumber1,state.longPrimeNumber2);
        } catch (NotAPrimeNubmerException e) {
            e.printStackTrace();
        }
        return keys;
    }


    @Benchmark
    public String encodeShortTextWithShortKey(MyState state){
        return RSA.encode(state.shortPublicKey,state.shortText);
    }

    @Benchmark
    public String  encodeShortTextWithLongKey(MyState state){
        return RSA.encode(state.longPublicKey,state.shortText);
    }

    @Benchmark
    public String  encodeLongTextWithShortKey(MyState state){
        return RSA.encode(state.shortPublicKey,state.longText);
    }

    @Benchmark
    public String  encodeLongTextWithLongKey(MyState state){
        return RSA.encode(state.longPublicKey,state.longText);
    }

    @Benchmark
    public String decodeShortTextWithShortKey(MyState state){
        return RSA.decode(state.shortPrivateKey,state.shortTextEncryptedWithShortKey);
    }

    @Benchmark
    public String decodeLongTextWithShortKey(MyState state){
        return RSA.decode(state.shortPrivateKey,state.longTextEncryptedWithShortKey);
    }

    @Benchmark
    public String decodeShortTextWithLongKey(MyState state){
        return RSA.decode(state.longPrivateKey,state.shortTextEncryptedWithLongKey);
    }

    @Benchmark
    public String decodeLongTextWithLongKey(MyState state){
        return RSA.decode(state.longPrivateKey,state.longTextEncryptedWithLongKey);
    }

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(RSABenchmark.class.getSimpleName())
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
