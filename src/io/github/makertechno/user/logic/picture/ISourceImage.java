package io.github.makertechno.user.logic.picture;

import io.github.makertechno.user.sources.SOURCE;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**内部使用的图片标准，自动封装了来着{@link ImgProcessor}的多种功能。
 * @param image 图片。*/
public record ISourceImage(BufferedImage image, int x, int y, int w, int h) {
    /**从默认的路径加载图片，图片应该存在于{@link io.github.makertechno.user.sources.imgs}*/
    public static URL fromLocal(String fileName){
        return SOURCE.class.getResource("imgs/" + fileName);
    }
    public static BufferedImage get(String name) throws IOException {
        return ImageIO.read(fromLocal(name));
    }
    public @NotNull ISourceImage toMaxRange(int maxWidth, int maxHeight){
        Dimension d = ImgProcessor.maximumCapacity(new Dimension(image.getWidth(),image.getHeight()), maxWidth, maxHeight);
        return new ISourceImage(image, x, y, d.width, d.height);
    }
    public @NotNull ISourceImage toOneSideMax(int maxWidth, int maxHeight){
        Dimension d = ImgProcessor.maximumExpansion(new Dimension(image.getWidth(), image.getHeight()), new Dimension(maxWidth, maxHeight));
        return new ISourceImage(image,x , y, d.width, d.height);
    }
    public @NotNull ISourceImage toOneSideMax(@NotNull Dimension maxRange){
        return toOneSideMax(maxRange.width, maxRange.height);
    }
    @Contract("_, _ -> new")
    public @NotNull ISourceImage toCenter(int width, int height){
        return new ISourceImage(image,(width-w)/2, (height-h)/2, w, h);
    }
    @Contract("_ -> new")
    public @NotNull ISourceImage toCenter(@NotNull Dimension surroundSize){
        return toCenter(surroundSize.width, surroundSize.height);
    }
}