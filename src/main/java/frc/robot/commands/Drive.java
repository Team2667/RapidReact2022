package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive extends CommandBase {
    private DriveTrain driveTrain;
    private XboxController jstick;

    public Drive(DriveTrain dt, XboxController joy) {
        driveTrain = dt;
        jstick = joy;
        this.setSubsystem("DriveTrain");
        this.addRequirements(dt);
    }
    private double deadZoneify(double input)
    {
        double sign=input>0?1:-1;
        double val=Math.abs(input);
        if(val>0.1)
            return (val*sign);
        return 0;
    }
    public void execute() {
        
        SmartDashboard.putNumber("x: ",jstick.getLeftY());
        SmartDashboard.putNumber("y: ",jstick.getLeftX());
        SmartDashboard.putNumber("left x: ",jstick.getLeftX());

        double y= -deadZoneify(jstick.getRightY());
        double x= deadZoneify(jstick.getRightX());
        double z= deadZoneify(jstick.getLeftX());

        driveTrain.DriveCartesian(-y,-x,z);        
    }
    public void end(boolean interupted) {
        driveTrain.StopMotor();
    }
}