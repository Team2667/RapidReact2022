package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arms;
public class Punchy extends CommandBase {
    private Arms arms;
    private int direction;
    public Punchy(Arms arms,int direction)
    {
        this.arms=arms;
        this.setSubsystem("Arms");
        this.addRequirements(arms);
        this.direction=direction;
    }
    @Override
    public void execute()
    {
        arms.set(1*direction);
    }

    @Override
    public void end(boolean interrupted)
    {
        arms.stop();
    }
    @Override
    public boolean isFinished()
    {
        return false;
    }
}
