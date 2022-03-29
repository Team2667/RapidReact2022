package frc.robot.commands;
import frc.robot.Constants;
import frc.robot.subsystems.Arms;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Up extends CommandBase{
    private Arms arms_sub;
    public Up(Arms arms_sub)
    {
        this.arms_sub=arms_sub;
        this.addRequirements(arms_sub);
    }
    @Override
    public void execute()
    {
        arms_sub.setpos(Constants.UpperLimit);
    }
    @Override
    public boolean isFinished()
    {
        return true;
    }
    
}
