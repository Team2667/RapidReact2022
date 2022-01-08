package frc.robot.subsystems.models;

public class TargetPos {
    private double x;
    private double y;
    private double a;

    public TargetPos(double x, double y, double a){
        this.x = x;
        this.y = y;
        this.a = a;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getArea(){
        return a;
    }
}
