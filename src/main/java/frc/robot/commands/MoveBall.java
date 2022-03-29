package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Belts;
public class MoveBall extends CommandBase {
    Belts belts_sub;
    XboxController joy;
    public MoveBall(XboxController joy,Belts belts_sub)
    {
        this.belts_sub=belts_sub;
        this.joy=joy;
        this.setSubsystem("Belts");
        this.addRequirements(belts_sub);
    }
    double getTriggerVal()
    {
        double leftTrig=joy.getLeftTriggerAxis();
        double rightTrig=joy.getRightTriggerAxis();
    //    System.out.println("right: "+rightTrig+"\nleft: "+leftTrig);
        return (rightTrig >0 ? 1 : -leftTrig)*Constants.MaxBeltSpeed;
    }

    @Override
    public void execute()
    {
        double speed=getTriggerVal();
        belts_sub.setBeltSpeed(speed);
    }
    @Override
    public void end(boolean interrupted)
    {
        belts_sub.stopBelt();
    }
}
