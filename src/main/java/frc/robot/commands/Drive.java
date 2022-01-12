package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class Drive extends CommandBase {
    private DriveTrain driveTrain;
    private XboxController jstick;

    public Drive(DriveTrain dt, XboxController joy) {
        driveTrain = dt;
        jstick = joy;
        this.setSubsystem("DriveTrain");
        //this.addRequirements(dt);
    }
    public void execute() {
        driveTrain.DriveCartesian(
        jstick.getLeftX(),
        jstick.getLeftY(),
        jstick.getRightX()
        );
    }
    public void end(boolean interupted) {
        driveTrain.StopMotor();
    }
}