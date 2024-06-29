package io.github.makertechno.user.logic.transport.variables;

import java.awt.*;

public interface IBaseElement<T> {
    T get();
    void set(T t);
    Color defaultColor();
    Class<? extends IBaseElement<T>> getUClass();
}
