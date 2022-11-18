package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallGrabber;
import frc.robot.subsystems.Belts;

public class AutoEjectBall extends CommandBase {
    private Belts belt;
    private BallGrabber ballgrabber;
    public AutoEjectBall(Belts belt,BallGrabber ballgrabber)
    {
        this.belt=belt;
        this.ballgrabber=ballgrabber;
        this.addRequirements(belt);
        this.addRequirements(ballgrabber);
    }
    @Override
    public void initialize()
    {
        belt.setBeltSpeed(1);
        ballgrabber.forward();
    }
    @Override
    public void end(boolean interrupted)
    {
        if(interrupted)
        {
            belt.stopBelt();
            ballgrabber.stopGrabber();
        }

    }
    
    @Override
    public boolean isFinished()
    {
        return false;
    }
}
