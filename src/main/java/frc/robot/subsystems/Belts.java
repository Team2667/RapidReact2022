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
        pidController.setP(.5);
        pidController.setI(0);
        pidController.setD(0);
        //
    }

    public void pullInBall(){
        //TODO: complete this method. Need to deterine what rotiations is.
        // Need to determine proper values for P, I and D.
        // Setting pid values can eventually be moved into the contructor.
        pidController.setP(.5);
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
        SmartDashboard.putNumber("velocity", encoder.getVelocity());
        SmartDashboard.putNumber("position", encoder.getPosition());
        SmartDashboard.putNumber("current draw", beltMotor.getOutputCurrent());
        super.periodic();
    }
}
