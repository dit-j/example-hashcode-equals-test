package de.jawb.model;
import org.junit.Test;

import de.jawb.model.PersonRegular;
import de.jawb.model.PersonWithReflection;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TestEqualsHashCode {

    @Test
    public void testEqualsAndHashCode_Regular() {
        EqualsVerifier.forClass(PersonRegular.class)
        .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
        .withRedefinedSuperclass()
        .verify();
    }

    @Test
    public void testEqualsAndHashCode_Reflection() {
        EqualsVerifier.forClass(PersonWithReflection.class)
        .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
        .withRedefinedSuperclass()
        .verify();
    }

    @Test
    public void testEqualsAndHashCode_Builder() {
        EqualsVerifier.forClass(PersonWithBuilder.class)
        .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
        .withRedefinedSuperclass()
        .verify();
    }
    
}
