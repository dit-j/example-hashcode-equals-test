package de.jawb.benchmark;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;

import de.jawb.model.Person;
import de.jawb.model.PersonReflection;

@Fork(value = 3)
@Warmup(iterations = 4, time = 2, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class ParserBenchmark {

    private static final List<Person>           regular    = PersonLoader.loadAs(Person.class);
    private static final List<PersonReflection> reflection = PersonLoader.loadAs(PersonReflection.class);

    // verhindere compiler optimierung...
    public static long                          sum        = 0;

    @Benchmark
    public void testEquals_Reflection() throws Exception {
        long i = 0;
        for (PersonReflection a : reflection) {
            for (PersonReflection b : reflection) {
                if (a.equals(b)) {
                    ++i;
                }
            }
        }
        sum += i;
    }

    @Benchmark
    public void testHashcode_Reflection() throws Exception {
        long i = 0;
        for (PersonReflection a : reflection) {
            i += a.hashCode();
        }
        sum += i;
    }

    @Benchmark
    public void testEquals_Regular() throws Exception {
        long i = 0;
        for (Person a : regular) {
            for (Person b : regular) {
                if (a.equals(b)) {
                    ++i;
                }
            }
        }
        sum += i;
    }

    @Benchmark
    public void testHashcode_Regular() throws Exception {
        long i = 0;
        for (Person a : regular) {
            i += a.hashCode();
        }
        sum += i;
    }

}