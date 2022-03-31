package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Biceps extends SubsystemBase {
    Solenoid bicepLeft;
    Solenoid bicepRight;
    public boolean out=false;

    public Biceps(){
        bicepLeft=new Solenoid(Constants.pcm,PneumaticsModuleType.CTREPCM, 2);
        bicepRight=new Solenoid(Constants.pcm,PneumaticsModuleType.CTREPCM, 1);
        }

    public void toggle(){
            out=!out;
            bicepRight.set(out);
            bicepLeft.set(out);
    }

    public void close() {
        bicepLeft.close();
        bicepRight.close();
    }
}
