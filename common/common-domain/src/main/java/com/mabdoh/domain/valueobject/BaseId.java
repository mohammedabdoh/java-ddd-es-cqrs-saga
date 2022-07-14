package com.mabdoh.domain.valueobject;

import java.util.Objects;

public abstract class BaseId<T> {
    private final T value;

    public BaseId(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BaseId)) {
            return false;
        }
        BaseId<?> baseId = (BaseId<?>) o;
        return Objects.equals(value, baseId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
