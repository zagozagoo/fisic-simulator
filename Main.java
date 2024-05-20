import javax.swing.JFrame;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("Banana");

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        World world = new World();

        for (int i = 0; i < 27; i++) {
            Random rand = new Random();
            rsrsrsrsrsr(world, rand.nextInt(600), rand.nextInt(600));
        }

        frame.add(world);
        frame.setVisible(true);
    }

    static void rsrsrsrsrsr(World world, double x, double y)
    {
        Mass m1 = new Mass();
        m1.setPosX(x);
        m1.setPosY(y);
        m1.setMass(10);
        m1.setSpeedX(1000);
        world.masses.add(m1);

        Mass m2 = new Mass();
        m2.setPosX(x + 100);
        m2.setPosY(y);
        m2.setMass(10);
        world.masses.add(m2);

        Mass m3 = new Mass();
        m3.setPosX(x);
        m3.setPosY(y + 100);
        m3.setMass(10);
        world.masses.add(m3);

        Mass m4 = new Mass();
        m4.setPosX(x + 100);
        m4.setPosY(y + 100);
        m4.setMass(10);
        world.masses.add(m4);

        Spring s1 = new Spring();
        s1.setK(1000000);
        s1.setSize(100);
        s1.setMass1(m1);
        s1.setMass2(m2);
        world.springs.add(s1);

        Spring s2 = new Spring();
        s2.setK(1000000);
        s2.setSize(100);
        s2.setMass1(m1);
        s2.setMass2(m3);
        world.springs.add(s2);

        Spring s3 = new Spring();
        s3.setK(1000000);
        s3.setSize(100);
        s3.setMass1(m3);
        s3.setMass2(m4);
        world.springs.add(s3);

        Spring s4 = new Spring();
        s4.setK(1000000);
        s4.setSize(100);
        s4.setMass1(m2);
        s4.setMass2(m4);
        world.springs.add(s4);

        Spring s5 = new Spring();
        s5.setK(1000000);
        s5.setSize(141);
        s5.setMass1(m2);
        s5.setMass2(m3);
        world.springs.add(s5);

        Spring s6 = new Spring();
        s6.setK(1000000);
        s6.setSize(141);
        s6.setMass1(m1);
        s6.setMass2(m4);
        world.springs.add(s6);
    }
}