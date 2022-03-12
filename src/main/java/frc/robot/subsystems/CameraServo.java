package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Servo;
public class CameraServo  extends SubsystemBase{
    private Servo camserv;
    private int angles[]={0,10,20,30,40,50,60,70,80,90,100,110,120,130,140,150,160,170,180};
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
