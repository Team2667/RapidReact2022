package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CameraServo;

public class CameraAngle extends CommandBase {
    CameraServo CameraServ;
    public CameraAngle(CameraServo CameraServ)
    {
        this.CameraServ=CameraServ;
    }
    @Override
    public void execute()
    {
        CameraServ.nextAngle();
    }
    @Override
    public boolean isFinished()
    {
        return true;
    }
}
