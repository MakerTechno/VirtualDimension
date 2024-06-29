package io.github.makertechno.user.logic.transport.variables;

import io.github.makertechno.user.gui.colors.DefaultColorPacks;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class CString implements IBaseElement<String>{
    private String string;
    public CString(String s){
        this.string = s;
    }
    public CString(@NotNull Object o){
        this.string = o.toString();
    }
    @Override
    public String get() {
        return string;
    }
    @Override
    public void set(String s) {
        this.string = s;
    }
    @Override
    public Color defaultColor() {
        return DefaultColorPacks.STRING;
    }

    @Override
    public Class<? extends IBaseElement<String>> getUClass() {
        return CString.class;
    }
}
