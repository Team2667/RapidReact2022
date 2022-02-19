package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Intake extends SubsystemBase {
    DoubleSolenoid solLeft;
    DoubleSolenoid solRight;

    public Intake(){
        solRight=new DoubleSolenoid(Constants.pcm, PneumaticsModuleType.REVPH, 0, 1);
        solLeft=new DoubleSolenoid(Constants.pcm, PneumaticsModuleType.REVPH, 2, 3);
    }

    public void toggle(){
    
            if (solRight.get() == Value.kForward) {
                solRight.set(Value.kReverse);
                solLeft.set(Value.kReverse);
            }
            else {
                solLeft.set(Value.kForward);
                solRight.set(Value.kForward);
            }
    }

    public void close() {
        solLeft.close();
        solRight.close();
    }
}
