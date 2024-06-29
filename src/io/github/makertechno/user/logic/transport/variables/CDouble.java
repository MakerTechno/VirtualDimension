package io.github.makertechno.user.logic.transport.variables;

import io.github.makertechno.user.gui.colors.DefaultColorPacks;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class CDouble implements IBaseElement<Double>{
    private Double aDouble;
    public CDouble(Double d){
        this.aDouble = d;
    }
    public CDouble(@NotNull Object o){
        try {
            this.aDouble = Double.parseDouble(o.toString());
        } catch (NumberFormatException e) {
            this.aDouble = Integer.getInteger(o.toString()).doubleValue();
        } catch (NullPointerException e) {
            this.aDouble = null;
        }
    }
    @Override
    public Double get() {
        return null;
    }

    @Override
    public void set(Double aDouble) {
        this.aDouble = aDouble;
    }

    @Override
    public Color defaultColor() {
        return DefaultColorPacks.DOUBLE;
    }

    @Override
    public Class<? extends IBaseElement<Double>> getUClass() {
        return CDouble.class;
    }
}
