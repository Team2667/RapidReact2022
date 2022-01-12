package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
    private MecanumDrive Mecanum;
    private CANSparkMax BackLeft,BackRight,FrontLeft,FrontRight;

    public DriveTrain(){
        BackLeft   = new CANSparkMax(Constants.BackLeft,MotorType.kBrushless);
        BackRight  = new CANSparkMax(Constants.BackRight,MotorType.kBrushless);
        FrontLeft  = new CANSparkMax(Constants.FrontLeft,MotorType.kBrushless);
        FrontRight = new CANSparkMax(Constants.FrontRight,MotorType.kBrushless);
        Mecanum    = new MecanumDrive(FrontLeft,BackLeft,FrontRight,BackRight);
    }
    public void DriveCartesian(double ySpeed,double xSpeed,double zRotation)
    {
        Mecanum.driveCartesian(ySpeed, xSpeed, zRotation);
    }
    
    public void StopMotor()
    {
        Mecanum.stopMotor();
    }
    
}
