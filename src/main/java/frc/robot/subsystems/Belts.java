package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;

public class Belts extends SubsystemBase {
    public CANSparkMax beltMotor;
    public Belts()
    {
        beltMotor=new CANSparkMax(Constants.beltMotor,MotorType.kBrushless);
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
