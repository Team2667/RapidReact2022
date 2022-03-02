package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Belts;

public class BeltAtVelocity extends CommandBase {
    Belts belts_sub;
    public BeltAtVelocity(Belts belts_sub)
    {
        this.belts_sub=belts_sub;
    }

    @Override
    public void initialize() {

      //  super.initialize();
    }

    @Override
    public void execute()
    {
        belts_sub.setBeltVelocity(3000);

    }

    @Override
    public boolean isFinished()
    {
        return false;
    }
    
}
