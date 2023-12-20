import java.awt.*;
import java.awt.event.*;

public class Demo extends Frame {

    public Demo() {
        super("Java AWT Examples");
        prepareGUI();
    }

    public static void main(String[] args) {
        Demo awtGraphicsDemo = new Demo();
        awtGraphicsDemo.setVisible(true);
    }

    private void prepareGUI() {
        setSize(400, 400);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.GRAY);
        Font font = new Font("Serif", Font.PLAIN, 24);
        g.setFont(font);
        g.drawString("Welcome to TutorialsPoint", 50, 150);
        g.setColor(Color.RED);
        g.drawArc(100, 100, 3, 1, 0, 270);
        g.fillArc(100, 100, 3, 1, 0, 270);
    }
}