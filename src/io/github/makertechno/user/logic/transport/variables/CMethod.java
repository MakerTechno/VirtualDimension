package io.github.makertechno.user.logic.transport.variables;

import io.github.makertechno.user.gui.colors.DefaultColorPacks;
import io.github.makertechno.user.sys.console.PatternHandler;

import java.awt.*;

public abstract class CMethod<T extends PatternHandler<?>> implements IBaseElement<T>{
    T functionHandler;
    public CMethod(T handler){
        this.functionHandler = handler;
    }
    @Override
    public T get() {
        return functionHandler;
    }

    @Override
    public void set(T t) {
        this.functionHandler = t;
    }

    @Override
    public Color defaultColor() {
        return DefaultColorPacks.METHOD;
    }
}
