package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;

public class BallGrabber extends SubsystemBase {
    public CANSparkMax ballGrabberMotor;
    public CANSparkMax retainerMotor;
    public boolean CurrentState=false;

    public BallGrabber()
    {
        ballGrabberMotor=new CANSparkMax(Constants.BallGrabber,MotorType.kBrushless);
        retainerMotor=new CANSparkMax(Constants.retainer,MotorType.kBrushless);
    }
    
    public void setGrabberSpeed(double speed)
    {
        ballGrabberMotor.set(speed);
        retainerMotor.set(speed);
    }

    public void stopGrabber()
    {
        ballGrabberMotor.stopMotor();
        retainerMotor.stopMotor();
    }

    public void forward()
    {
        setGrabberSpeed(Constants.GrabberSpeed);
    }
    public void backward()
    {
        setGrabberSpeed(-Constants.GrabberSpeed);
    }
    public void off()
    {
        stopGrabber();
    }

    public void toggleGrabber()
    {
        CurrentState=!CurrentState;
        if(CurrentState)
        {
            setGrabberSpeed(Constants.GrabberSpeed);
        }
        else
        {
            stopGrabber();
        }

    }
    
}
