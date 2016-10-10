# example-hashcode-equals-test

In diesem Beispielprojekt werden verschiedene Möglichkeiten die equals- und hashcode-Methoden zu überschreiben getestet.

1. Regular - Generierung mit IDE (Eclipse)
2. Reflection - Verwendung von HashCodeBuilder und Equalsbuilder aus Apache Commons 3
3. Builder - Verwendung von HashCodeBuilder und Equalsbuilder aus Apache Commons 3

### Ziel
###### Rausfinden, wie stark sich die verschiedenen Methoden softwaretechnisch aber auch in der Ausführungsgeschwindigkeit unterscheiden


```
Benchmark                                         Mode  Cnt       Score        Error  Units
HashcodeEqualsBenchmark.testEquals_Builder       thrpt    9     822,564 ±     13,113  ops/s
HashcodeEqualsBenchmark.testEquals_Reflection    thrpt    9      24,915 ±      1,510  ops/s
HashcodeEqualsBenchmark.testEquals_Regular       thrpt    9    7105,938 ±    195,020  ops/s
HashcodeEqualsBenchmark.testHashcode_Builder     thrpt    9  500183,093 ±  51891,751  ops/s
HashcodeEqualsBenchmark.testHashcode_Reflection  thrpt    9    5792,312 ±   1331,617  ops/s
HashcodeEqualsBenchmark.testHashcode_Regular     thrpt    9  474690,482 ± 124155,350  ops/s
```
