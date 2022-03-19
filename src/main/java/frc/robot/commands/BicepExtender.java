package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Biceps;
import frc.robot.subsystems.Intake;

public class BicepExtender extends CommandBase{
    private Biceps bicep;
    public BicepExtender(Biceps bicep_cons)
    {
        bicep=bicep_cons;
    }
    public void execute()
    {
        bicep.toggle();
    }
    public boolean isFinished()
    {
        return true;
    }
}
