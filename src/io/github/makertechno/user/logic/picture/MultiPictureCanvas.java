package io.github.makertechno.user.logic.picture;

import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class MultiPictureCanvas extends FunctionalCanvas {
    private final ISourceImage[] images;
    public MultiPictureCanvas(ISourceImage[] images, Color bg) {
        super(bg);
        this.images = images;
        setBackground(bg);
    }
    @Override
    public void paint(@NotNull Graphics g) {
        for (ISourceImage image : images) {
            g.drawImage(image.image(), image.x(), image.y(), image.w(), image.h(), this);
        }
        super.paint(g);
    }
}
