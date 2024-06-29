package io.github.makertechno.user.gui.colors;

import org.jetbrains.annotations.NotNull;

import java.awt.*;

public final class DefaultColorPacks {
    public static final Color
            STRING = new Color(58, 132, 69),
            INTEGER = new Color(108, 231, 255),
            DOUBLE = INTEGER,
            BOOLEAN = new Color(213, 102, 12),
            METHOD = new Color(255, 158, 251),
            ERROR = new Color(231, 29, 29),
            USERNAME = new Color(34, 158, 255),
            WORKGROUP = new Color(125, 255, 77),
            AVI = new Color(172, 7, 201),
            BACKGROUND = Color.BLACK,
            POINTER = Color.WHITE;

    private DefaultColorPacks(){}
    public static @NotNull ConsoleColorPack getDefault(){
        FontColorPack font = FontColorPack.create(STRING, INTEGER, DOUBLE, BOOLEAN, METHOD, ERROR, USERNAME, WORKGROUP, AVI);
        return ConsoleColorPack.create(BACKGROUND, font, POINTER);
    }
}
