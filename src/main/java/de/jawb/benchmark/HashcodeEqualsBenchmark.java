package de.jawb.benchmark;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;

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

    // verhindere compiler optimierung...
    public static long                              sum        = 0;

    private void runEquals(List<?> list) {
        long i = 0;
        for (Object a : list) {
            for (Object b : list) {
                if (a.equals(b)) {
                    ++i;
                }
            }
        }
        sum += i;
    }

    private void runHashCode(List<?> list) {
        long i = 0;
        for (Object a : list) {
            i += a.hashCode();
        }
        sum += i;
    }

    @Benchmark
    public void testEquals_Regular() throws Exception {
        runEquals(regular);
    }

    @Benchmark
    public void testHashcode_Regular() throws Exception {
        runHashCode(regular);
    }

    @Benchmark
    public void testEquals_Reflection() throws Exception {
        runEquals(reflection);
    }

    @Benchmark
    public void testHashcode_Reflection() throws Exception {
        runHashCode(reflection);
    }

    @Benchmark
    public void testEquals_Builder() throws Exception {
        runEquals(builder);
    }

    @Benchmark
    public void testHashcode_Builder() throws Exception {
        runHashCode(builder);
    }

}