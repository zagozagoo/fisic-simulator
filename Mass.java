import java.awt.Color;
import java.awt.Graphics;

public class Mass {
    private double posX;
    public double getPosX() {
        return posX;
    }
    public void setPosX(double posX) {
        this.posX = posX;
    }

    private double posY;
    public double getPosY() {
        return posY;
    }
    public void setPosY(double posY) {
        this.posY = posY;
    }

    private double speedX;
    public double getSpeedX() {
        return speedX;
    }
    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    private double speedY;
    public double getSpeedY() {
        return speedY;
    }
    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    private double mass;
    public double getMass() {
        return mass;
    }
    public void setMass(double mass) {
        this.mass = mass;
    }

    public void draw(Graphics g) {
        g.setColor(new Color(80, 0, 160));
        g.fillOval((int)posX - 10, (int)posY - 10, 20, 20);
    }

    public void move(double dt, double maxY, double maxX) {
        posX += speedX * dt;
        posY += speedY * dt;

        speedY += 980 * dt;
        if (posY + 10 > maxY) {
            speedY = -0.6 * speedY;
            posY = maxY - 10;
        }

        if (posX > maxX) {
            speedX = -speedX;
        }

        if (posX < 0) {
            speedX = -speedX;
        }
        
        if (posY < 0) {
            speedY = -speedY;
        }
    }

    public void applyForce(double fx, double fy, double dt) {
        // F = m * a -> a = F / m
        double ax = fx / mass;
        double ay = fy / mass;

        speedX += ax * dt;
        speedY += ay * dt;
    }
}
