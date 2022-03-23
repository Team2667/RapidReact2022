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
import frc.robot.commands.AutoEjectBall;
import frc.robot.commands.BallGrabberCommand;
import frc.robot.commands.BallGrabberCommandBack;
import frc.robot.commands.BicepExtender;
import frc.robot.commands.CameraAngle;
import frc.robot.commands.DPadButton;
import frc.robot.commands.Drive;
import frc.robot.commands.IntakeExtender;
import frc.robot.commands.LLDriverCamera;
import frc.robot.subsystems.Arms;
import frc.robot.subsystems.BallGrabber;
import frc.robot.subsystems.Belts;
import frc.robot.subsystems.Biceps;
import frc.robot.subsystems.CameraServo;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.LimeLight;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.LLDriverCamera;
import frc.robot.commands.LLVisionCamera;
import frc.robot.commands.MoveBall;
import frc.robot.commands.Punchy;
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
  private BallGrabberCommandBack ballGrabberCommandBack;
  IntakeExtender intake_ext;
  CameraServo cameraServo_sub;
  CameraAngle cameraAngle_command;
  AutoEjectBall autoEjectBall_command;
  private Arms arms_sub;
  private Punchy punchy_up;
  private Punchy punchy_down;
  private Biceps biceps;
  private BicepExtender bicep_ext;
  private LLVisionCamera visionMode;
  private DPadButton dpadHandler;


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
    cameraServo_sub=new CameraServo();
    arms_sub=new Arms();
    biceps=new Biceps();
  }
  public void InitCommands()
  {
    ballGrabberCommand=new BallGrabberCommand(ballGrabberSub);
    ballGrabberCommandBack=new BallGrabberCommandBack(ballGrabberSub);
    intake_ext=new IntakeExtender(intake_sub);
    cameraAngle_command=new CameraAngle(cameraServo_sub);
    punchy_up=new Punchy(arms_sub, 1);
    punchy_down=new Punchy(arms_sub, -1);
    bicep_ext=new BicepExtender(biceps);
    visionMode=new LLVisionCamera(limeLight);
    dpadHandler=new DPadButton(joy, cameraServo_sub);
  }
  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    LLDriverCamera drivermode=new LLDriverCamera(limeLight);
    limeLight.setDefaultCommand(visionMode);
    
    // JoystickButton bR = new JoystickButton(joy,XboxController.Button.kX.value);
    // bR.whileHeld(new LLVisionCamera(limeLight));
    
    JoystickButton bY=new JoystickButton(joy, Constants.intakeExtender);
    bY.whenPressed(intake_ext);

    MoveBall moveball=new MoveBall(joy, belts_sub);
    belts_sub.setDefaultCommand(moveball);

    JoystickButton changeCameraAngle=new JoystickButton(joy, Constants.changeCameraAngle);
    changeCameraAngle.whenPressed(cameraAngle_command, false);

    JoystickButton intakeForward=new JoystickButton(joy, Constants.intakeForward);
    intakeForward.whileHeld(ballGrabberCommand);

    JoystickButton intakeBackward=new JoystickButton(joy, Constants.intakeBackward);
    intakeBackward.whileHeld(ballGrabberCommandBack);

    JoystickButton armup=new JoystickButton(joy, Constants.armUp);
    armup.whileHeld(punchy_up);

    JoystickButton armdown=new JoystickButton(joy, Constants.armDown);
    armdown.whileHeld(punchy_down);

    JoystickButton bicepToggle=new JoystickButton(joy,Constants.bicepToggle);
    bicepToggle.whenPressed(bicep_ext);
    cameraServo_sub.setDefaultCommand(dpadHandler);
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
    // An ExampleCommand will run in autonomous
    return new AutoEjectBall(belts_sub).withTimeout(1).andThen(new Auto(m_driveTrainSub));
  }
}
