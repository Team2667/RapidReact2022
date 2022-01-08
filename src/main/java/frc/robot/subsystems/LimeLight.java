// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.models.TargetPos;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;


public class LimeLight extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public LimeLight() {

  }

  public TargetPos getCurrentTargetPos()
  {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");

    double x=tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double area = ta.getDouble(0.0);

      // TODO: Modify to return a TargetPos based on current readings from the limelight. 
      // See: https://docs.limelightvision.io/en/latest/getting_started.html#basic-programming
      
      return new TargetPos(x,y,area);
  }

  private Boolean SetEntry(String entry, int value)
  {
    return NetworkTableInstance.getDefault().getTable("limelight").getEntry(entry).setNumber(value);
  }
/*
0 	Vision processor
1 	Driver Camera (Increases exposure, disables vision processing)
*/

  public Boolean setVisionProcessing(){
    //put camera into vision mode
    boolean retval = SetEntry("CamMode", 0);
    if(!retval)
    {
      System.out.println("unable to put camera into vision mode");
      return false;
    }

    //force enable leds
    retval = SetEntry("ledMode",3);
    if(!retval)
    {
      return false;
    }

    return true;
    // See: https://docs.limelightvision.io/en/latest/networktables_api.html
  }

  public Boolean setTeleopDriving() {
    //put camera into driving mode
    Boolean retval = SetEntry("CamMode", 1);
    if(!retval)
    {
      return false;
    }

    //force disable leds
    retval = SetEntry("ledMode",1);
    if(!retval)
    {
      return false;
    }
    return true;
    // See: https://docs.limelightvision.io/en/latest/networktables_api.html
  }

  @Override
  public void periodic() {
    // TODO: Use  Vision.CurrentTargetPos(); to get the current position of the target.
    // Display the values on the smart dashboard. See: 
    // https://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj/smartdashboard/SmartDashboard.html

  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
