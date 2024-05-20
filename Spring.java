import java.awt.Color;
import java.awt.Graphics;

public class Spring
{
    private double k;
    public double getK() {
        return this.k;
    }
    public void setK(double value) {
        this.k = value;
    }

    private double size;
    public double getSize() {
        return this.size;
    }
    public void setSize(double value) {
        this.size = value;
    }

    private Mass m1;
    public Mass getMass1() {
        return this.m1;
    }
    public void setMass1(Mass value) {
        this.m1 = value;
    }

    private Mass m2;
    public Mass getMass2() {
        return this.m2;
    }
    public void setMass2(Mass value) {
        this.m2 = value;
    }

    public void draw(Graphics g) {
        g.setColor(new Color(120, 20, 20));
        g.drawLine(
            (int)m1.getPosX(),
            (int)m1.getPosY(),
            (int)m2.getPosX(),
            (int)m2.getPosY()
        );
    }

    public void move(double dt) {
        double vx = getMass2().getPosX() - getMass1().getPosX();
        double vy = getMass2().getPosY() - getMass1().getPosY();
        double mod = Math.sqrt(vx * vx + vy * vy);
        if (mod == 0)
            return;

        double esticada = this.size - mod;
        double force = this.k * esticada;

        double ux = vx / mod;
        double uy = vy / mod;

        double fx = force * ux;
        double fy = force * uy;

        m1.applyForce(-fx, -fy, dt);
        m2.applyForce(fx, fy, dt);
    }
}