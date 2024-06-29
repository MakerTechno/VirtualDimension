package io.github.makertechno.user.logic.picture;

import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.geom.Area;

/**该类负责记录四角状态并负责消除角落的逻辑处理*/
public record CornerAngle(boolean lu, boolean ru, boolean ld, boolean rd) {
    /**左上角*/
    private static final Rectangle LU = new Rectangle();
    /**右上角*/
    private static final Rectangle RU = new Rectangle();
    /**左下角*/
    private static final Rectangle LD = new Rectangle();
    /**右下角*/
    private static final Rectangle RD = new Rectangle();
    /**按记录信息消除角落，注意消除是按照1/4的区域删除的，所以请勿预先加入其他信息。
     * @param area 仅包含圆角绘制位置的区域。*/
    public void hide(Area area){
        localDefine(area);
        if (!lu) area.subtract(new Area(LU));
        if (!ru) area.subtract(new Area(RU));
        if (!ld) area.subtract(new Area(LD));
        if (!rd) area.subtract(new Area(RD));
    }
    /**对本地信息初始化，每次都会产生对应area大小的四个1/4块。
     * @param area 见{@link CornerAngle#hide(Area)}*/
    private void localDefine(@NotNull Area area){
        Point point = area.getBounds().getLocation();
        Dimension size = area.getBounds().getSize();

        if (!lu) {
            LU.setLocation(point.x - 1, point.y - 1);
            LU.setSize(size.width / 2, size.height / 2);
        }
        if (!ru) {
            RU.setLocation(point.x + size.width / 2, point.y - 1);
            RU.setSize(size.width / 2 + 1, size.height / 2);
        }
        if (!ld) {
            LD.setLocation(point.x - 1, point.y + size.height / 2);
            LD.setSize(size.width / 2, size.height / 2 + 1);
        }
        if (!rd) {
            RD.setLocation(point.x + size.width / 2, point.y + size.height / 2);
            RD.setSize(size.width / 2 + 1, size.height / 2 + 1);
        }
    }
}