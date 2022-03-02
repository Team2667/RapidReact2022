package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;

public class Belts extends SubsystemBase {
    public CANSparkMax beltMotor;
    public SparkMaxPIDController pidController;
    public RelativeEncoder encoder;
    private double p=0.0001*5;
    private double i=10;
    private double d=0;
    private double ff=0.000015;
    public Belts()
    {
        beltMotor=new CANSparkMax(Constants.beltMotor,MotorType.kBrushless);
        encoder = beltMotor.getEncoder();
        pidController = beltMotor.getPIDController();
    }
    public void setBeltSpeed(double speed)
    {
        beltMotor.set(speed);
    }
    
    public void stopBelt()
    {
        beltMotor.stopMotor();
    }

    public void setBeltVelocity(double velocity){
        //TODO: Complete this method. Need to determine value for velocity. Velocity 
        // will be number of motor rotations per second. Need to find the vaule that will
        // lob a ball into the portal
        pidController.setP(p);
        //pidController.setI(0.0000001);
        pidController.setI(i);
        pidController.setD(d);
        pidController.setFF(ff);
        pidController.setOutputRange(-1, 1);
        pidController.setReference(3000, ControlType.kVelocity);
        //
    }

    public void pullInBall(){
        //TODO: complete this method. Need to deterine what rotiations is.
        // Need to determine proper values for P, I and D.
        // Setting pid values can eventually be moved into the contructor.
        pidController.setP(0);
        pidController.setI(0);
        pidController.setD(0);
        
        
      //  pidController.setReference(num rotations, ControlType.kPosition);
      // could also use encoder.setPosition. 
    }

    public boolean currentSpikeDetected(){
        // return beltMotor.getOutputCurrent() > some limmit to be determined by
        // expirmentation
        return false;
    }
    
    @Override
    public void periodic() {
        // TODO output to smart dashboard values for current and velocity and position
        //encoder.getVelocity()
        //encoder.getPosition()
        //beltMotor.getOutputCurrent();
        double sp=SmartDashboard.getNumber("p val", p);
        double si=SmartDashboard.getNumber("i val", i);
        double sd=SmartDashboard.getNumber("d val", d);
        double sff=SmartDashboard.getNumber("ff val", ff);
        if(sp!=p)
            p=sp;
        if(si!=i)
            i=si;
        if(sd!=d)
            d=sd;
        if(sff!=ff)
            ff=sff;

              
        SmartDashboard.putNumber("p val", p);
        SmartDashboard.putNumber("i val", i);
        SmartDashboard.putNumber("d val", d);
        SmartDashboard.putNumber("ff val", ff);
        
        SmartDashboard.putNumber("velocity", encoder.getVelocity());
        SmartDashboard.putNumber("position", encoder.getPosition());
        SmartDashboard.putNumber("current draw", beltMotor.getOutputCurrent());
        SmartDashboard.putNumber("accum", pidController.getIAccum());

 

        super.periodic();
    }
}
