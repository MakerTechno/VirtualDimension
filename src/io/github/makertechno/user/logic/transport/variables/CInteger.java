package io.github.makertechno.user.logic.transport.variables;

import io.github.makertechno.user.gui.colors.DefaultColorPacks;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class CInteger implements IBaseElement<Integer>{
    private Integer integer;
    public CInteger(Integer i){
        this.integer = i;
    }
    public CInteger(@NotNull Object o){
        this.integer = Integer.getInteger(o.toString());
    }

    @Override
    public Integer get() {
        return integer;
    }

    @Override
    public void set(Integer integer) {
        this.integer = integer;
    }

    @Override
    public Color defaultColor() {
        return DefaultColorPacks.INTEGER;
    }

    @Override
    public Class<? extends IBaseElement<Integer>> getUClass() {
        return CInteger.class;
    }
}
