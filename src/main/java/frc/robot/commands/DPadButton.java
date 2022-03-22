package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CameraServo;

public class DPadButton extends CommandBase { 
    private XboxController joystick;
    private CameraServo cameraServo;
    int prevDir=-1;

    public DPadButton(XboxController joystick, CameraServo cameraServo) {
        this.joystick = joystick;
        this.cameraServo = cameraServo;
        this.addRequirements(cameraServo);
        this.setSubsystem("CameraServo");
    }

    @Override
    public void execute() {
        int dPadDir = joystick.getPOV();
        if(dPadDir==-1 || prevDir==dPadDir)
            return;
        prevDir=dPadDir;
        cameraServo.setPresetAng(1+(dPadDir/90));
    }
    
}