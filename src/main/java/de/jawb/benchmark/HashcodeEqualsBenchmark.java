package de.jawb.benchmark;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import de.jawb.model.PersonRegular;
import de.jawb.model.PersonWithBuilder;
import de.jawb.model.PersonWithReflection;

@Fork(value = 3)
@Warmup(iterations = 4, time = 200, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
public class HashcodeEqualsBenchmark {

    private static final List<PersonRegular>        regular    = PersonLoader.loadAs(PersonRegular.class);
    private static final List<PersonWithReflection> reflection = PersonLoader.loadAs(PersonWithReflection.class);
    private static final List<PersonWithBuilder>    builder    = PersonLoader.loadAs(PersonWithBuilder.class);

    private long runEquals(List<?> list) {
        long i = 0;
        for (Object a : list) {
            for (Object b : list) {
                if (a.equals(b)) {
                    ++i;
                }
            }
        }
        return i;
    }

    private long runHashCode(List<?> list) {
        long i = 0;
        for (Object a : list) {
            i += a.hashCode();
        }
        return i;
    }

    @Benchmark
    public void testEquals_Regular(Blackhole bh) throws Exception {
        bh.consume(runEquals(regular));
    }

    @Benchmark
    public void testHashcode_Regular(Blackhole bh) throws Exception {
        bh.consume(runHashCode(regular));
    }

    @Benchmark
    public void testEquals_Reflection(Blackhole bh) throws Exception {
        bh.consume(runEquals(reflection));
    }

    @Benchmark
    public void testHashcode_Reflection(Blackhole bh) throws Exception {
        bh.consume(runHashCode(reflection));
    }

    @Benchmark
    public void testEquals_Builder(Blackhole bh) throws Exception {
        bh.consume(runEquals(builder));
    }

    @Benchmark
    public void testHashcode_Builder(Blackhole bh) throws Exception {
        bh.consume(runHashCode(builder));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder() //
                .include(HashcodeEqualsBenchmark.class.getSimpleName())
                .build();

        Runner runner = new Runner(opt);
        Collection<RunResult> results = runner.run();
    }

}
