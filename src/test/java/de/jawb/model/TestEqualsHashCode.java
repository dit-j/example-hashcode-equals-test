package de.jawb.model;
import org.junit.Test;

import de.jawb.model.Person;
import de.jawb.model.PersonReflection;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TestEqualsHashCode {

    @Test
    public void testEqualsAndHashCode_Regular() {
        EqualsVerifier.forClass(Person.class)
        .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
        .withRedefinedSuperclass()
        .verify();
    }

    @Test
    public void testEqualsAndHashCode_Reflection() {
        EqualsVerifier.forClass(PersonReflection.class)
        .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
        .withRedefinedSuperclass()
        .verify();
    }
    
}
