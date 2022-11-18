package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class UndersideBallEject extends SubsystemBase {
    public CANSparkMax undersideMotor;
    public SparkMaxPIDController pid;
    private RelativeEncoder encoder;
    private double p=0.08,i=0,d=0;
     
    public UndersideBallEject()
    {
        undersideMotor=new CANSparkMax(Constants.flyWheelMotor,MotorType.kBrushless);
        pid=undersideMotor.getPIDController();
    }


    
    public void setUndersideSpeed(double speed)
    {
        pid.setReference(speed, ControlType.kVelocity);
    }
    
    public void stopBelt()
    {
        undersideMotor.stopMotor();
    }
    public void setPidVals(double p, double i, double d)
    {
        pid.setP(p);
        pid.setI(i);
        pid.setD(d);
    }
    public void periodic()
    {
        double sp=SmartDashboard.getNumber("p val flywheel", p);
        double si=SmartDashboard.getNumber("i val flywheel", i);
        double sd=SmartDashboard.getNumber("d val flywheel", d);

        if(sp!=p)
            p=sp;
        if(si!=i)
            i=si;
        if(sd!=d)
            d=sd;

        SmartDashboard.putNumber("p val flywheel", p);
        SmartDashboard.putNumber("i val flywheel", i);
        SmartDashboard.putNumber("d val flywheel", d);
        setPidVals(p, i, d);
    }
}
