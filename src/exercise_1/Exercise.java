package exercise_1;
import exercise_1.ln.Ln;
import exercise_1.cos.Cos;
import exercise_1.pow.Pow;

public class Exercise {

    private double x;
    private double result;

    public Exercise(double x) {
        this.x = x;
    }

    public double SolveTheEquation (){
        result = (Ln.lnNumber(Cos.cosNum(x)))/(Ln.lnNumber(1 + Pow.powNum(x,2)));
        return result;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
}
