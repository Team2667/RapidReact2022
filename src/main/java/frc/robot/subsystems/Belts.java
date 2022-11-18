package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;

public class Belts extends SubsystemBase {
    private CANSparkMax beltMotor;
    private CANSparkMax flyWheelMotor;
    private SparkMaxPIDController flyWheelPid;
    public double currentFlyWheelVelocity=5000;
    private RelativeEncoder flywheEncoder;
    public double p=0.00009,i=0.0000006,d=0;
    //p: 0.00009, i:0.0000001, d:0, rpm:6000
    //p: 0.00009, i:0.0000005, d:0, rpm:4000
    public Belts()
    {
        beltMotor=new CANSparkMax(Constants.beltMotor,MotorType.kBrushless);
        flyWheelMotor=new CANSparkMax(Constants.flyWheelMotor,MotorType.kBrushless);
        flyWheelPid=flyWheelMotor.getPIDController();
        flywheEncoder = flyWheelMotor.getEncoder();
        flyWheelMotor.setInverted(true);
    }

    public void setPidVals(double p, double i, double d)
    {
        flyWheelPid.setP(p);
        flyWheelPid.setI(i);
        flyWheelPid.setD(d);
    }
    
    public void periodicL()
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
        //setPidVals(p, i, d);
        SmartDashboard.putNumber("Flywheel RPMs", flywheEncoder.getVelocity());
    }

    public double getBeltSpeed()
    {
        return beltMotor.get();
    }

    public void setBeltSpeed(double speed)
    {
        setPidVals(p, i, d);
        beltMotor.set(speed);

        if(speed>0)
            flyWheelPid.setReference(currentFlyWheelVelocity,ControlType.kVelocity);
        else if (speed<0)
            flyWheelPid.setReference(-currentFlyWheelVelocity, ControlType.kVelocity);
        else if (speed==0)
            flyWheelMotor.stopMotor();
    }
    
    public void stopBelt()
    {
        beltMotor.stopMotor();
        flyWheelMotor.stopMotor();
    }
    
}
