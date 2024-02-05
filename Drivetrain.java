// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*

  Date: 3/22/22
  Name: Team 2338 (everyone knows methods though)
  Task Done: Created class

*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.revrobotics.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.SerialPort.Port;


public class Drivetrain extends SubsystemBase {
    private static Drivetrain instance = null;

    public static CANSparkMax frontRight;
    public static CANSparkMax frontLeft;
    public static CANSparkMax backRight;
    public static CANSparkMax backLeft;

    public static MotorControllerGroup leftGroup;
    public static MotorControllerGroup rightGroup;

    public static DifferentialDrive drivetraincontrol;

    //public static final int VOLTAGE = 8;

    public static Drivetrain getInstance(){
        if (instance == null){
            System.out.println("drivetrain init");
            instance = new Drivetrain();
        }
        return instance;
    }

    public Drivetrain () {
        super();
        //frontLeft.setIdleMode(Spark.Kbrake);
        

        //Right
        frontRight = new CANSparkMax(Constants.frontRightSpark, CANSparkMaxLowLevel.MotorType.kBrushed);
        backRight = new CANSparkMax(Constants.backRightSpark, CANSparkMaxLowLevel.MotorType.kBrushed);

        frontLeft = new CANSparkMax(Constants.frontLeftSpark, CANSparkMaxLowLevel.MotorType.kBrushed);
        backLeft = new CANSparkMax(Constants.backLeftSpark, CANSparkMaxLowLevel.MotorType.kBrushed);
    

        leftGroup = new MotorControllerGroup(frontLeft, backLeft);
        rightGroup = new MotorControllerGroup(frontRight, backRight);
        drivetraincontrol = new DifferentialDrive(leftGroup, rightGroup);
     //   drivetraincontrol.setSafetyEnabled(true);
    
       rightGroup.setInverted(true);
       //backRight.setInverted(true);
    }

    //public void tankExponentialDriveVolts(double leftVolts, double rightVolts){
     //   leftGroup.setVoltage(safeSquare(leftVolts) * 10);
       // rightGroup.setVoltage(safeSquare(rightVolts) * 10);
    //}
    public void tankDriveVolts(double leftVolts, double rightVolts){
        leftGroup.setVoltage(leftVolts * 7);
        rightGroup.setVoltage(rightVolts * 7);
    }

    // public void tankExponentialDriveVolts(double leftVolts, double rightVolts){
    //     leftGroup.setVoltage(leftVolts * 10);
    //     rightGroup.setVoltage(rightVolts * 10);
    // }

    public void tankSpeed(double leftVolts, double rightVolts){
        leftGroup.setVoltage(leftVolts*12);
        rightGroup.setVoltage(rightVolts*12);
    }

    public double safeSquare(double input) {
        double result = 0;
        if(input > 0) {result =  Math.pow(input, Constants.exponentialDrivePower);}
        if(input < 0) {result = -Math.pow(input, Constants.exponentialDrivePower);}
        return result;
    }


}