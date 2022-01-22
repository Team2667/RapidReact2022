package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class Auto extends CommandBase {
    private DriveTrain driveTrain;
    private XboxController jstick;

    public Auto(DriveTrain dt) {
        driveTrain = dt;
        this.setSubsystem("DriveTrain");
        this.addRequirements(dt);
    }
    public void execute() {

        double x=-1;
        double y=0;
        double z=0;

        driveTrain.DriveCartesian(x,y,z);
        
    }
    public void end(boolean interupted) {
        driveTrain.StopMotor();
    }
}
