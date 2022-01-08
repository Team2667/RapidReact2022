package frc.robot.Utils;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.subsystems.models.TargetPos;

public class Vision {

    public static TargetPos CurrentTargetPos()
    {
        // Modify to return a TargetPos based on current readings from the limelight.
        // See: https://docs.limelightvision.io/en/latest/getting_started.html#basic-programming
       return new TargetPos(0.0,0.0,0.0);
    }
}
