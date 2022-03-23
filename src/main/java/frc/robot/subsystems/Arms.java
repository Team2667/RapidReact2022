package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
public class Arms extends SubsystemBase {
    private CANSparkMax arml;
    private CANSparkMax armr;
    private RelativeEncoder encoderl;
    private RelativeEncoder encoderr;
    public Arms()
    {
        arml=new CANSparkMax(Constants.left_arm,MotorType.kBrushless);
        armr=new CANSparkMax(Constants.right_arm,MotorType.kBrushless);

        encoderl=arml.getEncoder();
        encoderr=armr.getEncoder();

        arml.setInverted(true);
        armr.setInverted(false);
    }


    private void down(double pos,CANSparkMax motor) {
        if(pos > Constants.LowerLimit)
        {
            motor.set(-1);
        }
        else
            motor.stopMotor();
    }
    private void up(double pos,CANSparkMax motor) {
        if(pos < Constants.UpperLimit)
        {
            motor.set(1);
        }
        else
            motor.stopMotor();
    }



    public void set(double speed)
    {
        if(speed < 0)
        {
            down(encoderr.getPosition(),armr);
            down(encoderl.getPosition(),arml);
        }
        else
        {
            up(encoderr.getPosition(),armr);
            up(encoderl.getPosition(),arml);
        }
    } 



    public void stop()
    {
        arml.stopMotor();
        armr.stopMotor();
    }
    @Override
    public void periodic()
    {
        SmartDashboard.putNumber("left arm pos", encoderl.getPosition());
        SmartDashboard.putNumber("right arm pos",encoderr.getPosition());
    }
}
