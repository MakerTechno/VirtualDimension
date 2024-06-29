package io.github.makertechno.user.gui.colors;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public final class FontColorPack {
    /**Basic font settings values.*/
    private final Color stringColor, integerColor, doubleColor, booleanColor, methodColor, errorColor;
    /**User font settings values*/
    private final Color name, workGroup, avi;
    private FontColorPack(Color str, Color integer, Color dbl, Color bool, Color mth, Color err, Color name, Color workGroup, Color avi){
        this.stringColor = str;
        this.integerColor = integer;
        this.doubleColor = dbl;
        this.booleanColor = bool;
        this.methodColor = mth;
        this.errorColor = err;
        this.name = name;
        this.workGroup = workGroup;
        this.avi = avi;
    }
    @Contract("_, _, _, _, _, _, _, _, _ -> new")
    public static @NotNull FontColorPack create(Color str, Color integer, Color dbl, Color bool, Color mth, Color err,  Color name, Color workGroup, Color avi){
        return new FontColorPack(str, integer, dbl, bool, mth, err, name, workGroup, avi);
    }
    public Color getStringColor() {return stringColor;}
    public Color getIntegerColor() {return integerColor;}
    public Color getDoubleColor() {return doubleColor;}
    public Color getBooleanColor() {return booleanColor;}
    public Color getMethodColor() {return methodColor;}
    public Color getErrorColor() {return errorColor;}
    public Color getNameColor() {return name;}
    public Color getWorkGroupColor() {return workGroup;}
    public Color getAviColor() {return avi;}
}
