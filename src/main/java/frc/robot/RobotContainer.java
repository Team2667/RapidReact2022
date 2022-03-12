// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.commands.Auto;
import frc.robot.commands.BallGrabberCommand;
import frc.robot.commands.Drive;
import frc.robot.commands.IntakeExtender;
import frc.robot.commands.LLDriverCamera;
import frc.robot.subsystems.BallGrabber;
import frc.robot.subsystems.Belts;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.LimeLight;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.LLDriverCamera;
import frc.robot.commands.LLVisionCamera;
import frc.robot.commands.MoveBall;
import frc.robot.commands.toggleBeltAndGrabber;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final LimeLight limeLight = new LimeLight();
  private XboxController joy;
  private DriveTrain m_driveTrainSub;
  private Drive m_driveCmd;
  private Auto Autonomous;
  private Intake intake_sub;
  private Belts belts_sub;

  private BallGrabber ballGrabberSub;
  private BallGrabberCommand ballGrabberCommand;
  private toggleBeltAndGrabber beltwgrabber;



  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings'
    joy = new XboxController(0);
    InitSubs();
    InitCommands();
    configureButtonBindings();
    setupDriveTrain();
  }

  public void InitSubs(){
    intake_sub=new Intake();
    belts_sub=new Belts();
    ballGrabberSub=new BallGrabber();
  }
  public void InitCommands()
  {
    ballGrabberCommand=new BallGrabberCommand(ballGrabberSub);
    beltwgrabber=new toggleBeltAndGrabber(ballGrabberSub, belts_sub);
  }
  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    LLDriverCamera drivermode=new LLDriverCamera(limeLight);
    limeLight.setDefaultCommand(drivermode);

    JoystickButton bR = new JoystickButton(joy,XboxController.Button.kX.value);
      bR.whileHeld(new LLVisionCamera(limeLight));

    IntakeExtender intake_ext=new IntakeExtender(intake_sub);
    JoystickButton bY=new JoystickButton(joy, XboxController.Button.kY.value);
    bY.whenPressed(intake_ext);

    MoveBall moveball=new MoveBall(joy, belts_sub);
    belts_sub.setDefaultCommand(moveball);

    JoystickButton bB=new JoystickButton(joy, XboxController.Button.kB.value);
    bB.whenPressed(beltwgrabber, false);

//    JoystickButton bX=new JoystickButton(joy, XboxController.Button.kX.value);
//    bX.whenPressed(ballGrabberCommand.alongWith(parallel), false);
  }
  
  private void setupDriveTrain() {
    m_driveTrainSub = new DriveTrain();
    m_driveCmd = new Drive(m_driveTrainSub,joy);
    m_driveTrainSub.setDefaultCommand(m_driveCmd);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous0
    return new Auto(m_driveTrainSub).withTimeout(Constants.autotime);
  }
}
