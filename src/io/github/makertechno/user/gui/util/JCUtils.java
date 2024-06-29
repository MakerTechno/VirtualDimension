package io.github.makertechno.user.gui.util;

import io.github.makertechno.user.gui.colors.ConsoleColorPack;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class JCUtils {
    public static @NotNull Rectangle getAvailableArea(GraphicsConfiguration configuration){
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(configuration);
        return new Rectangle(
                screenInsets.left,screenInsets.top,
                screenSize.width-screenInsets.left-screenInsets.right,
                screenSize.height-screenInsets.top-screenInsets.bottom
        );
    }

    public static void applyColors(JTextPane pane, ConsoleColorPack pack){

    }
}
