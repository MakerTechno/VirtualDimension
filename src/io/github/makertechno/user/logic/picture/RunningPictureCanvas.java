package io.github.makertechno.user.logic.picture;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class RunningPictureCanvas extends FunctionalCanvas {
    private final Image[] images;
    private Timer timer = new Timer();
    private int count = 0;
    private final int x,y,w,h,t;
    public RunningPictureCanvas(String @NotNull [] images, int x, int y, int width, int height, int roundSpeed, Color bg) throws IOException {
        super(bg, new CornerAngle(false,false,false,false));
        assert roundSpeed>0 && roundSpeed < 1000;
        t = 2000 / roundSpeed;
        this.images = new Image[images.length];
        for (int i = 0; i < images.length; i++){
            this.images[i] = ImageIO.read(ISourceImage.fromLocal(images[i]));
        }
        this.x = x;
        this.y = y;
        this.w = width;
        this.h = height;
        timer.schedule(getTask(),20,t);
    }
    public void stop(){
        if (timer != null)timer.cancel();
        timer = null;
    }
    public boolean start(){
        if (timer != null) return false;
        timer = new Timer();
        timer.schedule(getTask(),20,t);
        return true;
    }
    @Contract(value = " -> new", pure = true)
    private @NotNull TimerTask getTask(){
        return new TimerTask() {
            @Override
            public void run() {
                if (count < images.length) count++;
                else count = 0;
                repaint();
            }
        };
    }
    @Override
    public void paint(@NotNull Graphics g) {
        g.drawImage(images[count],x,y,w,h,this);
        super.paint(g);
    }
}
