package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;

public class Belts extends SubsystemBase {
    public CANSparkMax beltMotor;
    private boolean state=false;
    public boolean mutex=false;
    public Belts()
    {
        beltMotor=new CANSparkMax(Constants.beltMotor,MotorType.kBrushless);
    }
    public void toggleBelt()
    {
        state=!state;
        if(state)
        {
            setBeltSpeed(Constants.beltSpeedToggle);
        }
        else
        {
            stopBelt();
        }
    }
    public double getBeltSpeed()
    {
        return beltMotor.get();
    }

    public void setBeltSpeed(double speed)
    {
        beltMotor.set(speed);
    }
    
    public void stopBelt()
    {
        beltMotor.stopMotor();
    }
    
}
