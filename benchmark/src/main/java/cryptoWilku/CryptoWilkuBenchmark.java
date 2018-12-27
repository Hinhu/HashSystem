package cryptoWilku;

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.*;

public class CryptoWilkuBenchmark {

    @State(Scope.Thread)
    public static class MyState{
        public String shortPassword = "Hasło";
        //public String longPassword = "BaaardzoDługieHasło_i_BaaaaaardzoTrudneDoZłamania1234567890";

        public String shortString = "Króciutki tajny tekst do zaszyfrowania";
    }

    @Benchmark
    public String encryptionBenchmark(MyState state){
        return CryptoWilku.applyCrypto(state.shortString, state.shortPassword);
    }

    public static void main(String[] args) throws Exception {
        Main.main(args);
    }
}
