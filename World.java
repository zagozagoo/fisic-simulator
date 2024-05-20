import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.Timer;

public class World extends JComponent {

    ArrayList<Mass> masses = new ArrayList<>();
    ArrayList<Spring> springs = new ArrayList<>();

    public World() {
        Timer tm = new Timer(25, e -> {
            for (int i = 0; i < 100; i++)
            {
                for (Mass mass : this.masses)
                    mass.move(0.025 / 100, getHeight(), getWidth());
                for (Spring spring : this.springs)
                    spring.move(0.025 / 100);
            }
            repaint();
        });
        tm.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(60, 140, 255));
        g.fillRect(0, 0, getWidth(), getHeight());

        for (Mass mass : this.masses)
            mass.draw(g);

        for (Spring spring : this.springs)
            spring.draw(g);

    }
}