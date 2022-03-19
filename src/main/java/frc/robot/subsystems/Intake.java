package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Intake extends SubsystemBase {
    Solenoid sol;

    public Intake(){
        sol=new Solenoid(Constants.pcm,PneumaticsModuleType.CTREPCM, 0);
        }

    public void toggle(){
            boolean oldVal=sol.get();
            sol.set(!oldVal);
    }

    public void close() {
        sol.close();
    }
}
