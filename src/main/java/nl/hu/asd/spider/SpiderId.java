package nl.hu.asd.spider;

import nl.hu.asd.ValueObject;

import java.util.Objects;

public class SpiderId extends ValueObject {
    private String id;

    public SpiderId(String id) {
        this.setId(id);
    }

    private void setId(String id) {
        // additional checks
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
}
