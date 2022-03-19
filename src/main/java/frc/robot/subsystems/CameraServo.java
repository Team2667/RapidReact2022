package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Servo;
public class CameraServo  extends SubsystemBase{

    private Servo camserv;
    private int angles[]={Constants.ang1,Constants.ang2,Constants.ang3};
    private int angleNow=0;

    public CameraServo()
    {
        camserv=new Servo(Constants.camServoChannel);
    }
    public void nextAngle()
    {
        angleNow=(angleNow+1)%(angles.length);
        System.out.println(angles[angleNow]);
        camserv.setAngle(angles[angleNow]);
    }
}
