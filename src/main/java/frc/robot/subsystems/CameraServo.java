package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import javax.sound.sampled.SourceDataLine;

import edu.wpi.first.wpilibj.Servo;
public class CameraServo extends SubsystemBase{

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
    public void setPresetAng(int input)
    {
        switch (input) {
            case 1: camserv.setAngle(Constants.ang1);
                    break;
            case 2: camserv.setAngle(Constants.ang2);
                    break;
            case 3: camserv.setAngle(Constants.ang3);
                    break;
            case 4: camserv.setAngle(Constants.ang4);
                    break;
        }
    }
}
