package frc.robot.commands;
import frc.robot.Constants;
import frc.robot.subsystems.Arms;
import frc.robot.subsystems.Biceps;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Up extends CommandBase{
    private Arms arms_sub;
    private Biceps biceps;
    public Up(Arms arms_sub,Biceps bicep)
    {
        this.arms_sub=arms_sub;
        this.biceps=bicep;
        this.addRequirements(arms_sub);
        this.addRequirements(bicep);
    }
    @Override
    public void execute()
    {
        arms_sub.setpos(biceps.out?Constants.UpperLimitAngled:Constants.UpperLimitVert);
    }
    @Override
    public boolean isFinished()
    {
        return true;
    }
    
}
