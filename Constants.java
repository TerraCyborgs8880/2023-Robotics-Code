// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*

  Date: 3/22/22
  Name: Faaiz
  Task Done: Added constants

*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    
  
    
  //Spark ID's
    final public static int backRightSpark = 3;
    final public static int frontRightSpark = 4;
    final public static int frontLeftSpark = 2;
    final public static int backLeftSpark = 1;
    
    final public static int elevatorMotorSpark = 5;
   // final public static int RedLineElevatorSpark2 = 6;
    
   // final public static int elbowSpark = 7;
    final public static int armSpark = 6;

  //Solenoid ID's

    final public static int solenoidForward = 0;
    final public static int solenoidReverse = 1;

    /*
    * ^^^^^^^^^^^^^^^^^^^^^^^^^
    * SOMEONE LOOK AT THESE PLS
    * IDK WHAT VALUES TO PUT
    */
    

    
  //Voltages/Speeds

    final public static double autoDrivetrainVolts = 0.3;

    final public static double elevatorVolts = 0.3;

    final public static double aVolts = 0.5;

    final public static double elbowVolts = 3;

    final public static double exponentialDrivePower = 1.5;

    // anzar, umar, zaki 3/06/2023
    final public static double limelightLensHeightInches = 54.0;

    final public static double goalHeightInches = 60.0;

    final public static double limelightMountAngleDegrees = 0.0;



    // GYRO DEADZONE

    public final static double gyroDeadzone = 5.5; 

    final public static double triggerSpeedMultiplier = 1.4;
    
}