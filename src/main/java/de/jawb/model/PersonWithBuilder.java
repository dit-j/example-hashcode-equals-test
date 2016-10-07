package de.jawb.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public final class PersonWithBuilder extends AbstractPerson {

    @Override
    public int hashCode() {
        HashCodeBuilder b = new HashCodeBuilder();
        b.append(this.id);
        b.append(this.name);
        b.append(this.age);
        b.append(this.comment);
        return b.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PersonWithBuilder)) {
            return false;
        }

        PersonWithBuilder o = (PersonWithBuilder)obj;
        EqualsBuilder b = new EqualsBuilder();
        b.append(this.id, o.id);
        b.append(this.name, o.name);
        b.append(this.age, o.age);
        b.append(this.comment, o.comment);

        return b.isEquals();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
