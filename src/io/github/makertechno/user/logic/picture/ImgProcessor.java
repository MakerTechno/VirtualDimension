package io.github.makertechno.user.logic.picture;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

/**该功能类负责有关图片缩放等功能的管理*/
public class ImgProcessor {
    /**“最大容纳”等比例缩放
     * <p>
     * 将维度等比例调整到刚好能放下的大小。
     * @param dimension 原始维度
     * @param maxWidth 最大宽度
     * @param maxHeight 最大高度
     * @return 缩放后的大小
     */
    @Contract("_, _ ,_ -> new")
    public static @NotNull Dimension maximumCapacity(@NotNull Dimension dimension, double maxWidth, double maxHeight){
        return proportionalScaling(dimension, maxWidth, maxHeight, false);
    }
    /**“最大容纳”等比例缩放
     * <p>
     * 将维度等比例调整到刚好能放下的大小。
     * @param dimension 原始维度
     * @param maxRange 最大容纳维度
     * @return 缩放后的大小
     */
    @Contract("_, _ -> new")
    public static @NotNull Dimension maximumCapacity(@NotNull Dimension dimension, @NotNull Dimension maxRange){
        return maximumCapacity(dimension, maxRange.width, maxRange.height);
    }
    /**“最大扩充”等比例缩放
     * <p>
     * 当维度宽度(width)值大于维度高度(height)值时，使高度值扩展到最大高度值；
     * 当维度高度值值大于维度宽度值值时，使宽度扩展到最大宽度值。
     * @param dimension 原始维度
     * @param maxWidth 最大宽度
     * @param maxHeight 最大高度
     * @return 缩放后的大小
     */
    @Contract(value = "_, _, _ -> new", pure = true)
    public static @NotNull Dimension maximumExpansion(@NotNull Dimension dimension, double maxWidth, double maxHeight){
        return proportionalScaling(dimension, maxWidth, maxHeight, true);
    }
    /**“最大扩充”等比例缩放
     * <p>
     * 当维度宽度(width)值大于维度高度(height)值时，使高度值扩展到最大高度值；
     * 当维度高度值值大于维度宽度值值时，使宽度扩展到最大宽度值。
     * @param dimension 原始维度
     * @param maxRange 最大容纳维度
     * @return 缩放后的大小
     */
    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull Dimension maximumExpansion(@NotNull Dimension dimension, @NotNull Dimension maxRange){
        return maximumExpansion(dimension, maxRange.width, maxRange.height);
    }
    /**等比例缩放
     * <p>
     * 将维度等比例调整，这经常用于图片缩放。
     * @param dimension 原始维度
     * @param maxWidth 最大宽度
     * @param maxHeight 最大高度
     * @param reverse 是否反转，true对应最大扩充，false对应最大容纳。
     * @return 缩放后的大小
     */
    @Contract(value = "_, _, _, _ -> new", pure = true)
    private static @NotNull Dimension proportionalScaling(@NotNull Dimension dimension, double maxWidth, double maxHeight, boolean reverse){
        int originalWidth = dimension.width, originalHeight = dimension.height;
        double scaleFactor;//倍率因子

        if (reverse? originalWidth > originalHeight : originalWidth < originalHeight)
            scaleFactor = maxHeight / originalHeight; // 水平方向缩放因子
        else scaleFactor = maxWidth / originalWidth; // 垂直方向缩放因子

        int newWidth = (int)(scaleFactor * originalWidth); // 新的宽度
        int newHeight = (int)(scaleFactor * originalHeight); // 新的高度

        return new Dimension(newWidth,newHeight);
    }
}
