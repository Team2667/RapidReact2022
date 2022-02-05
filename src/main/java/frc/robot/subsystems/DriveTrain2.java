package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.MecanumDriveKinematics;
import edu.wpi.first.math.kinematics.MecanumDriveWheelSpeeds;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain2 extends SubsystemBase {
public static final double kMaxSpeed = 3.0; // 3 meters per second
  public static final double kMaxAngularSpeed = Math.PI; // 1/2 rotation per second


  // TODO: Replace Can Ids with constants
  private final MotorController m_frontLeftMotor = new PWMSparkMax(1);
  private final MotorController m_frontRightMotor = new PWMSparkMax(2);
  private final MotorController m_backLeftMotor = new PWMSparkMax(3);
  private final MotorController m_backRightMotor = new PWMSparkMax(4);

  private final Encoder m_frontLeftEncoder = new Encoder(0, 1);
  private final Encoder m_frontRightEncoder = new Encoder(2, 3);
  private final Encoder m_backLeftEncoder = new Encoder(4, 5);
  private final Encoder m_backRightEncoder = new Encoder(6, 7);

  private final Translation2d m_frontLeftLocation = new Translation2d(0.381, 0.381);
  private final Translation2d m_frontRightLocation = new Translation2d(0.381, -0.381);
  private final Translation2d m_backLeftLocation = new Translation2d(-0.381, 0.381);
  private final Translation2d m_backRightLocation = new Translation2d(-0.381, -0.381);

  private final PIDController m_frontLeftPIDController = new PIDController(1, 0, 0);
  private final PIDController m_frontRightPIDController = new PIDController(1, 0, 0);
  private final PIDController m_backLeftPIDController = new PIDController(1, 0, 0);
  private final PIDController m_backRightPIDController = new PIDController(1, 0, 0);

  private final MecanumDriveKinematics m_kinematics =
      new MecanumDriveKinematics(
          m_frontLeftLocation, m_frontRightLocation, m_backLeftLocation, m_backRightLocation);


    private final SimpleMotorFeedforward m_feedforward = new SimpleMotorFeedforward(1, 3);

    public DriveTrain2() {
            // We need to invert one side of the drivetrain so that positive voltages
            // result in both sides moving forward. Depending on how your robot's
            // gearbox is constructed, you might have to invert the left side instead.

            //TODO: Determine if this is needed based on current DriveTrain subsystem
        m_frontRightMotor.setInverted(true);
        m_backRightMotor.setInverted(true);
    }

    public void drive(double xSpeed, double ySpeed, double rot) {
        var mecanumDriveWheelSpeeds =
            m_kinematics.toWheelSpeeds(new ChassisSpeeds(xSpeed, ySpeed, rot));

        mecanumDriveWheelSpeeds.desaturate(kMaxSpeed);
        setSpeeds(mecanumDriveWheelSpeeds);
    }

    public void setSpeeds(MecanumDriveWheelSpeeds speeds) {
        final double frontLeftFeedforward = m_feedforward.calculate(speeds.frontLeftMetersPerSecond);
        final double frontRightFeedforward = m_feedforward.calculate(speeds.frontRightMetersPerSecond);
        final double backLeftFeedforward = m_feedforward.calculate(speeds.rearLeftMetersPerSecond);
        final double backRightFeedforward = m_feedforward.calculate(speeds.rearRightMetersPerSecond);
    
        final double frontLeftOutput =
            m_frontLeftPIDController.calculate(
                m_frontLeftEncoder.getRate(), speeds.frontLeftMetersPerSecond);
        final double frontRightOutput =
            m_frontRightPIDController.calculate(
                m_frontRightEncoder.getRate(), speeds.frontRightMetersPerSecond);
        final double backLeftOutput =
            m_backLeftPIDController.calculate(
                m_backLeftEncoder.getRate(), speeds.rearLeftMetersPerSecond);
        final double backRightOutput =
            m_backRightPIDController.calculate(
                m_backRightEncoder.getRate(), speeds.rearRightMetersPerSecond);
    
        m_frontLeftMotor.setVoltage(frontLeftOutput + frontLeftFeedforward);
        m_frontRightMotor.setVoltage(frontRightOutput + frontRightFeedforward);
        m_backLeftMotor.setVoltage(backLeftOutput + backLeftFeedforward);
        m_backRightMotor.setVoltage(backRightOutput + backRightFeedforward);
      }

}
