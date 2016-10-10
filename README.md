## example-hashcode-equals-test

In diesem Beispielprojekt werden verschiedene Möglichkeiten die equals- und hashcode-Methoden zu überschreiben getestet.

1. Regular - Generierung mit IDE (Eclipse)
2. Reflection - Verwendung von HashCodeBuilder und Equalsbuilder aus Apache Commons 3
3. Builder - Verwendung von HashCodeBuilder und Equalsbuilder aus Apache Commons 3

### *Ziel:* Rausfinden, wie stark sich die verschiedenen Methoden softwaretechnisch aber auch in der Ausführungsgeschwindigkeit unterscheiden

### Verwendete Bibliotheken
###### Apache Commons Lang

Aus dieser Apache Bibliothek werden die Klassen ```HashCodeBuilder``` und ```Equalsbuilder``` verwendet. Mit Hilfe dieser Klassen können equals und hashcode-Methoden entweder über Reflection oder Builder erstellt werden:

1. 
```java
@Override
public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
}

@Override
public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
}
```



```xml
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-lang3</artifactId>
	<version>3.4</version>
</dependency>
```


```
Benchmark                                         Mode  Cnt       Score        Error  Units
HashcodeEqualsBenchmark.testEquals_Builder       thrpt    9     822,564 ±     13,113  ops/s
HashcodeEqualsBenchmark.testEquals_Reflection    thrpt    9      24,915 ±      1,510  ops/s
HashcodeEqualsBenchmark.testEquals_Regular       thrpt    9    7105,938 ±    195,020  ops/s
HashcodeEqualsBenchmark.testHashcode_Builder     thrpt    9  500183,093 ±  51891,751  ops/s
HashcodeEqualsBenchmark.testHashcode_Reflection  thrpt    9    5792,312 ±   1331,617  ops/s
HashcodeEqualsBenchmark.testHashcode_Regular     thrpt    9  474690,482 ± 124155,350  ops/s
```
