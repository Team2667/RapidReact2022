package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.BallGrabber;
public class BallGrabberCommand extends CommandBase {
    BallGrabber ballGrabberSub;
    XboxController joy;
    public BallGrabberCommand(BallGrabber ballGrabberSub)
    {
        this.ballGrabberSub=ballGrabberSub;
        this.setSubsystem("ballGrabberSub");
        this.addRequirements(ballGrabberSub);
    }

    @Override
    public void execute()
    {
        ballGrabberSub.toggleGrabber();
    }

    @Override
    public boolean isFinished()
    {
        return true;
    }

    @Override
    public void end(boolean interrupted)
    {
    }
}
