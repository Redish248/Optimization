import static java.lang.Math.abs;
import static java.lang.Math.log;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Methods {

    private double A_div = 1.5;
    private double B_div = 2;
    private double EPS = 0.02;
    private double PHI = (1+sqrt(5))/2;
    public double minGoldenX;
    public double minGoldenY;
    private double minParabolaX;
    private double minParabolaY;

    public void parabolaImpl() {
        double x1 = A_div, x2 = (A_div + B_div)/2, x3 = B_div;
        System.out.println("Точки: x1 = " + x1 + ", x2 = " + x2 + ", x3 = " + x3);
        parabola(x1, x2, x3);
        System.out.println("Текущий минимум: Xmin = " + minParabolaX + ", Ymin = " + minParabolaY);
        double x_prev = minParabolaX, delta = 100;
        while (delta >= EPS) {
            if (minParabolaX > x2) {
                x1 = x2;
            } else {
                x3 = x2;
            }
            x2 = minParabolaX;
            System.out.println("Точки: x1 = " + x1 + ", x2 = " + x2 + ", x3 = " + x3);
            parabola(x1, x2, x3);
            System.out.println("Текущий минимум: Xmin = " + minParabolaX + ", Ymin = " + minParabolaY);
            delta = minParabolaX - x_prev;
            System.out.println("Дельта: " + delta);
        }
    }


    public void goldenRatio() {
        double x1, x2;
        double a = A_div, b = B_div;
        while (abs(a - b) >= EPS) {
            x1 = b - (b - a) / PHI;
            x2 = a + (b - a) / PHI;
            if (function(x1) >= function(x2)) {
                a = x1;
            } else {
                b = x2;
            }
        }
        minGoldenX = a;
        minGoldenY = function(a);
    }

    private void parabola(double x1, double x2, double x3) {
        double y1, y2, y3, delta, A, B, C;
        y1 = function(x1);
        y2 = function(x2);
        y3 = function(x3);
        delta = (x2-x1)*(x3-x1)*(x3-x2);
        A = ((x3-x2)*y1 - (x3-x1)*y2 + (x2-x1)*y3)/delta;
        B = (-(x3*x3-x2*x2)*y1 + (x3*x3 - x1*x1)*y2 - (x2*x2 - x1*x1)*y3)/delta;
        C = (x2*x3*(x3-x2)*y1 - x1*x3*(x3-x1)*y2 + x1*x2*(x2-x1)*y3)/delta;
        minParabolaX = -B/(2*A);
        minParabolaY = -B*B/(4*A) + C;
    }

    private double function(double x) {
        return pow(x,3)/3 - 5*x + x*log(x);
    }

}
