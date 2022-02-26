package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Intake extends SubsystemBase {
    Solenoid solLeft;
    Solenoid solRight;

    public Intake(){
        solLeft=new Solenoid(Constants.pcm,PneumaticsModuleType.CTREPCM, 0);
        solRight=new Solenoid(Constants.pcm,PneumaticsModuleType.CTREPCM, 1);
        }

    public void toggle(){
            boolean oldVal=solRight.get();
            solRight.set(!oldVal);
            solLeft.set(!oldVal);
    }

    public void close() {
        solLeft.close();
        solRight.close();
    }
}
