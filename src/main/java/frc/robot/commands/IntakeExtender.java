package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeExtender extends CommandBase{
    Intake intake;
    public IntakeExtender(Intake intake_cons)
    {
        intake=intake_cons;
    }
    public void execute()
    {
        intake.toggle();
    }

    public boolean isFinished()
    {
        return true;
    }
}
