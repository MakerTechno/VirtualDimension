package io.github.makertechno.user.gui.colors;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public final class ConsoleColorPack {
    private final Color background, pointerColor;
    private final FontColorPack fontColorPack;
    private ConsoleColorPack(Color background, FontColorPack fontColorPack, Color pointerColor){
        this.background = background;
        this.fontColorPack = fontColorPack;
        this.pointerColor = pointerColor;
    }
    @Contract("_, _, _ -> new")
    public static @NotNull ConsoleColorPack create(Color background, FontColorPack fontColorPack, Color pointerColor){
        return new ConsoleColorPack(background, fontColorPack, pointerColor);
    }
    public Color getBackground() {return background;}
    public FontColorPack getFontColorPack() {return fontColorPack;}
    public Color getPointerColor() {return pointerColor;}
}
