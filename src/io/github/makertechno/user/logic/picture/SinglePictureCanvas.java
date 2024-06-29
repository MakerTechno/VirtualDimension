package io.github.makertechno.user.logic.picture;

import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class SinglePictureCanvas extends FunctionalCanvas {
    private final ISourceImage image;
    public SinglePictureCanvas(ISourceImage image, Color bg) throws IOException {
        super(bg, new CornerAngle(false,false,false,false));
        this.image = image;
    }
    @Override
    public void paint(@NotNull Graphics g) {
        g.drawImage(image.image(),image.x(),image.y(),image.w(),image.h(),this);
        super.paint(g);
    }
}
