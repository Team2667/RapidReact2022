package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
public class Arms extends SubsystemBase {
    private CANSparkMax arml;
    private CANSparkMax armr;
    private RelativeEncoder encoderl;
    private RelativeEncoder encoderr;
    private SparkMaxPIDController pidLeft;
    private SparkMaxPIDController pidRight;
    private double p=0.08;
    private double i=0;
    private double d=0;

    public Arms()
    {
        arml=new CANSparkMax(Constants.left_arm,MotorType.kBrushless);
        armr=new CANSparkMax(Constants.right_arm,MotorType.kBrushless);

        encoderl=arml.getEncoder();
        encoderr=armr.getEncoder();

        arml.setInverted(true);
        armr.setInverted(false);

        pidLeft=arml.getPIDController();
        pidRight=armr.getPIDController();

    }

    private void updatePidVals()
    {
        /*
        SparkMaxPIDController pidcontrollers[]={pidLeft,pidRight};        
        for(int i=0;i<2;i++)
        {
            pidcontrollers[i].setP(p);
            pidcontrollers[i].setI(i);
            pidcontrollers[i].setD(d);
        }
        */
        pidLeft.setP(p);
        pidRight.setP(p);

        pidLeft.setI(i);
        pidRight.setI(i);

        pidLeft.setD(d);
        pidRight.setD(d);

    }


    private void down(double pos,CANSparkMax motor) {
        if(pos > Constants.LowerLimit)
        {
            motor.set(-1);
        }
        else
            motor.stopMotor();
    }
    private void up(double pos,CANSparkMax motor) {
        if(pos < Constants.UpperLimitAngled)
        {
            motor.set(1);
        }
        else
            motor.stopMotor();
    }



    public void set(double speed)
    {
        if(speed < 0)
        {
            down(encoderr.getPosition(),armr);
            down(encoderl.getPosition(),arml);
        }
        else
        {
            up(encoderr.getPosition(),armr);
            up(encoderl.getPosition(),arml);
        }
    } 

    public void setpos(double position)
    {
        updatePidVals();
        pidLeft.setReference(position, ControlType.kPosition);
        pidRight.setReference(position, ControlType.kPosition);
    }



    public void stop()
    {
        arml.stopMotor();
        armr.stopMotor();
    }
    @Override
    public void periodic()
    {
        SmartDashboard.putNumber("left arm pos", encoderl.getPosition());
        SmartDashboard.putNumber("right arm pos",encoderr.getPosition());

        double sp=SmartDashboard.getNumber("p val", p);
        double si=SmartDashboard.getNumber("i val", i);
        double sd=SmartDashboard.getNumber("d val", d);


        if(sp!=p)
            p=sp;
        if(si!=i)
            i=si;
        if(sd!=d)
            d=sd;

        SmartDashboard.putNumber("p val", p);
        SmartDashboard.putNumber("i val", i);
        SmartDashboard.putNumber("d val", d);
        updatePidVals();
    }
}
