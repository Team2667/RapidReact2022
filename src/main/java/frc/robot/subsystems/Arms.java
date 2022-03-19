package frc.robot.subsystems;

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
    public void set(double speed)
    {
        arml.set(speed);
        armr.set(speed);
    }
    public void stop()
    {
        arml.stopMotor();
        armr.stopMotor();
    }
    @Override
    public void periodic()
    {
        //System.out.println("left arm pos: "+encoderl.getPosition()+", right arm pos: "+encoderr.getPosition());
    }
}
