package io.github.makertechno.user.logic.picture;

import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

/**项目适配的Canvas标准类，提前完成了部分需求性功能。*/
public abstract class FunctionalCanvas extends Canvas {
    /*静态常量设置*/
    /**默认的角落格式，四个角均不作管理。*/
    public static final CornerAngle DEFAULT_CORNER = new CornerAngle(false,false,false,false);
    /**默认角落颜色为黑色*/
    public static final Color DEFAULT_CORNER_COLOR = Color.BLACK;

    /*基本变量设置*/
    /**圆角半径。*/
    protected int r = 0;
    /**角落颜色，这用于绘制圆角。*/
    protected Color cornerColor;
    /**四角管理状态。*/
    protected CornerAngle angle;

    /**项目适配的Canvas标准类，提前完成了部分需求性功能。*/
    public FunctionalCanvas(){
        this(DEFAULT_CORNER_COLOR,DEFAULT_CORNER);
    }
    /**项目适配的Canvas标准类，提前完成了部分需求性功能。
     * @param cornerColor 见{@link FunctionalCanvas#cornerColor}*/
    public FunctionalCanvas(Color cornerColor){
        this(cornerColor, DEFAULT_CORNER);
    }
    /**项目适配的Canvas标准类，提前完成了部分需求性功能。
     * @param angle 见{@link FunctionalCanvas#angle}*/
    public FunctionalCanvas(CornerAngle angle){
        this(DEFAULT_CORNER_COLOR, angle);
    }
    /**项目适配的Canvas标准类，提前完成了部分需求性功能。
     * @param cornerColor 见{@link FunctionalCanvas#cornerColor}
     * @param angle 见{@link FunctionalCanvas#angle}*/
    public FunctionalCanvas(Color cornerColor, CornerAngle angle){
        this.cornerColor = cornerColor;
        this.angle = angle;
    }
    /**取消了继承，默认的添加了圆角的绘制。图片的绘制应该在下一层实现。*/
    public void paint(Graphics graphics){
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(cornerColor);
        Area area = toComplementary(new Rectangle(0,0,getWidth(),getHeight()), new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),r,r));
        angle.hide(area);
        graphics2D.fill(area);
    }
    /**设置圆角遮挡的操作，这会导致重新绘制。*/
    public void setRoundCorner(boolean leftUp, boolean rightUp, boolean leftDown, boolean rightDown){
        this.angle = new CornerAngle(leftUp, rightUp, leftDown, rightDown);
        repaint();
    }
    /**设置背景颜色的操作，这会导致重新绘制。*/
    public void setCornerColor(Color bg){
        this.cornerColor = bg;
        repaint();
    }
    /**设置圆角半径的操作，这会导致重新绘制。*/
    public void toRound(int r){
        this.r = r;
        repaint();
    }
    /**准备圆角绘制区域的操作。*/
    private @NotNull Area toComplementary(Shape shapeU, Shape def){
        Area area = new Area(shapeU);
        area.subtract(new Area(def));
        return area;
    }
}
