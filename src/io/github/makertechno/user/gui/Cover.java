package io.github.makertechno.user.gui;

import io.github.makertechno.user.logic.picture.ISourceImage;
import io.github.makertechno.user.logic.picture.MultiPictureCanvas;
import io.github.makertechno.user.sys.BaseDispatcher;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;

import static io.github.makertechno.user.gui.util.JCUtils.getAvailableArea;

public class Cover extends JFrame {
    JPanel panel = new JPanel();
    JTextField field = new JTextField(" ");
    public Cover() throws IOException {
        Container container = getContentPane();
        Rectangle available = getAvailableArea(getGraphicsConfiguration());
        setSize(available.width/5*3,available.height/3*2);
        setLayout(null);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setBackground(Color.WHITE);
        container.setBackground(Color.WHITE);
        setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),60,60));
        labelInit();

        container.add(panel);
        MultiPictureCanvas canvas = new MultiPictureCanvas(canvasInit(), Color.WHITE);
        canvas.setBounds(0,0,getWidth()/3*2,getHeight()/4*3);
        canvas.toRound(60);
        canvas.setRoundCorner(false, false, false, false);

        container.add(canvas);

        setVisible(true);
        BaseDispatcher.registerEventListener(BaseDispatcher.BASE_EVENT, handler -> {
            field.setText(handler.getDescription() + ":   " + handler.queryProcess() + "%");
            if (handler.queryState()) {
                field.setDisabledTextColor(Color.GREEN);
                Thread.sleep(200000);
                System.exit(114514);
            }
        });
    }
    private void labelInit(){
        field.setOpaque(false);
        panel.setLocation(getWidth() / 30,getHeight()/5*4);
        panel.setSize(getWidth()/2, getHeight()/9);
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout());
        field.setFont(new Font("宋体", Font.BOLD, getHeight()/20));
        field.setDisabledTextColor(new Color(81, 203, 242));
        field.setBorder(null);
        field.setEnabled(false);
        panel.add(field, BorderLayout.CENTER);
    }
    private ISourceImage @NotNull [] canvasInit() throws IOException {
        ISourceImage p1 = new ISourceImage(ISourceImage.get("flash1.png"),0,0,0,0)
                .toOneSideMax(getWidth()/3*2,getHeight()/4*3)
                .toCenter(getWidth()/3*2,getHeight()/4*3);

        return new ISourceImage[]{
                p1,
                new ISourceImage(ISourceImage.get("up.png"), p1.x(), p1.y() + p1.h()/7*5,p1.w(),p1.h()/7*2)
        };
    }


    @Override
    public void paint(Graphics g) {
    }
}
