package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Belts;

public class SetFlywheelSpeed extends CommandBase {
    Belts belts_sub;
    int presetNum;
    public SetFlywheelSpeed(Belts belts_sub, int presetNum)
    {
        this.presetNum=presetNum;
        this.belts_sub=belts_sub;
        this.addRequirements(belts_sub);
    }
    public void execute()
    {
        belts_sub.currentFlyWheelVelocity=Constants.flywheelRpms[presetNum];
        belts_sub.p=Constants.flywheelPs[presetNum];
        belts_sub.i=Constants.flywheelIs[presetNum]; 
        belts_sub.d=Constants.flywheelDs[presetNum];
    }

    @Override
    public boolean isFinished()
    {
        return true;
    }
    
}
