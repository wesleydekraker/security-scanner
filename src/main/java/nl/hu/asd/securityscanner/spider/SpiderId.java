package nl.hu.asd.securityscanner.spider;

import nl.hu.asd.securityscanner.ValueObject;

import java.util.Objects;

public class SpiderId extends ValueObject {
    private String id;

    public SpiderId(String id) {
        this.setId(id);
    }

    private void setId(String id) {
        if (id.length() != 36) {
            throw new IllegalArgumentException("SpiderId must be 36 characters long.");
        }
        
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpiderId spiderId = (SpiderId) o;
        return Objects.equals(id, spiderId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id;
    }
}
