// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj.XboxController; //for button bindings

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static int FrontLeft=1;
    public static int BackLeft=2;
    public static int FrontRight=3;
    public static int BackRight=4;

    public static int beltMotor=5;
    public static final int BallGrabber=6;
    public static final int left_arm=7;
    public static final int right_arm=8;
    public static int pcm=11;


    public static double MaxMotorSpeed=0.65;
    public static final double MaxBeltSpeed=1;
    public static final double GrabberSpeed=1;
    public static final double beltSpeedToggle = 1;

    public static int autotime=1;

    /* Camera preset angles */
    public static int camServoChannel=9;
    public static int ang1 = 100;
    public static int ang2 = 125;
    public static int ang3 = 165;
    public static int ang4 = 0;

    /* button bindings */
    public static final int intakeExtender = XboxController.Button.kRightStick.value;
    public static final int changeCameraAngle = XboxController.Button.kLeftStick.value;
    public static final int intakeBackward=XboxController.Button.kLeftBumper.value;
    public static final int intakeForward=XboxController.Button.kRightBumper.value;
    public static final int armUp=XboxController.Button.kY.value;
    public static final int armDown=XboxController.Button.kA.value;
    public static final int bicepToggle=XboxController.Button.kB.value;
    public static final double LowerLimit = -13.5;
    public static final double UpperLimit = 133;



}
