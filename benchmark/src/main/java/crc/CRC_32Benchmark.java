package crc;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

public class CRC_32Benchmark {

    /* DATA FOR BENCHMARKS */
    @State(Scope.Thread)
    public static class MyState{

        CRC_32 crc = new CRC_32();
        // Short text for redundancy check
        public String shortText = "Lorem Ipsum";

        // Long text for redundancy check
        public String longText = "Time flies, knells call, life passes, so hear my prayer. \n" +
                "Birth is nothing but death begun, so hear my prayer.\n" +
                "Death is speechless, so hear my speech.\n" +
                "This is Jake, who served his ka and his tet. Say true.\n" +
                "May the forgiving glance of S’mana heal his heart. Say please.\n" +
                "May the arms of Gan raise him from the darkness of this earth. Say please.\n" +
                "Surround him, Gan , with light.\n" +
                "Fill him, Chloe, with strength.\n" +
                "If he is thirsty, give him water in the clearing.\n" +
                "If he is hungry, give him food in the clearing.\n" +
                "May his life on this earth and the pain of his passing become as a dream to his waking soul, and let his eyes fall upon every lovely sight; let him find the friends that were lost to him, and let every one whose name he calls call his in return.\n" +
                "This is Jake, who lived well, loved his own, and died as ka would have it.\n" +
                "Each man owes a death. This is Jake. Give him peace.";

        // Repetitive text for redundancy check
        public String repetitiveText = "abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc";

        // One char text for redudnancy check
        public String oneChar = "a";
    }


    /* BENCHMARKS */
    @Benchmark
    public String applyCRCForShortText(MyState state){
        state.crc.reset();
        state.crc.update(state.shortText.getBytes());
        return state.crc.CRChashCode();
    }

    @Benchmark
    public String applyCRCForLongText(MyState state){
        state.crc.reset();
        state.crc.update(state.longText.getBytes());
        return state.crc.CRChashCode();
    }

    @Benchmark
    public String applyCRCForRepetitiveText(MyState state){
        state.crc.reset();
        state.crc.update(state.repetitiveText.getBytes());
        return state.crc.CRChashCode();
    }

    @Benchmark
    public String applyCRCForOneChar(MyState state){
        state.crc.reset();
        state.crc.update(state.oneChar.getBytes());
        return state.crc.CRChashCode();
    }

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(CryptoWilkuBenchmark.class.getSimpleName())
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