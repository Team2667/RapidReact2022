package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.BallGrabber;
import frc.robot.subsystems.Belts;
public class toggleBeltAndGrabber extends CommandBase {
    BallGrabber ballGrabberSub;
    Belts beltSub;
    XboxController joy;
    public toggleBeltAndGrabber(BallGrabber ballGrabberSub,Belts beltSub)
    {
        this.ballGrabberSub=ballGrabberSub;
        this.beltSub=beltSub;

        this.setSubsystem("ballGrabberSub");
        this.addRequirements(ballGrabberSub);
        this.addRequirements(beltSub);

    }

    @Override
    public void execute()
    {
        ballGrabberSub.toggleGrabber();
        beltSub.toggleBelt();
        beltSub.mutex=!beltSub.mutex;
        System.out.println("execute");
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
