package io.github.makertechno.user.logic.transport.variables;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ObservableValue<T> {
    private T value;
    private final PropertyChangeSupport support;

    public ObservableValue(T initialValue) {
        this.value = initialValue;
        this.support = new PropertyChangeSupport(this);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        T oldValue = this.value;
        this.value = value;
        this.support.firePropertyChange("value", oldValue, value);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.support.removePropertyChangeListener(listener);
    }
}
