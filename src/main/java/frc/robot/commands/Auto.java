package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.subsystems.Intake;

public class Auto extends CommandBase {
    private DriveTrain driveTrain;
    double x,y,z;
    Intake intake_;
    public Auto(DriveTrain dt) {
        driveTrain = dt;
        this.setSubsystem("DriveTrain");
        this.addRequirements(dt);
        x=-0.5;
        y=0;
        z=0;        
    }
    public void execute() {

        driveTrain.DriveCartesian(x,y,z);
    }

    public void end(boolean interupted) {
        driveTrain.StopMotor();

        if(interupted)
        {
            x=-x;
            return;
        }

    }
}
