package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Belts;

public class AutoEjectBall extends CommandBase {
    private Belts belt;
    public AutoEjectBall(Belts belt)
    {
        this.belt=belt;
    }
    @Override
    public void initialize()
    {
        belt.setBeltSpeed(1);
    }
    @Override
    public void end(boolean interrupted)
    {
        belt.stopBelt();
    }
    
    @Override
    public boolean isFinished()
    {
        return false;
    }
}
