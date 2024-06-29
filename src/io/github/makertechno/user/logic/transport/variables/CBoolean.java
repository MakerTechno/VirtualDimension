package io.github.makertechno.user.logic.transport.variables;

import io.github.makertechno.user.gui.colors.DefaultColorPacks;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class CBoolean implements IBaseElement<Boolean>{
    private Boolean bool;
    public CBoolean(Boolean b){
        this.bool = b;
    }
    public CBoolean(@NotNull Object o){
        this.bool = Boolean.parseBoolean(o.toString());
    }
    @Override
    public Boolean get() {
        return bool;
    }
    @Override
    public void set(Boolean bool) {
        this.bool = bool;
    }
    @Override
    public Color defaultColor() {
        return DefaultColorPacks.BOOLEAN;
    }
    @Override
    public Class<? extends IBaseElement<Boolean>> getUClass() {
        return CBoolean.class;
    }
}
