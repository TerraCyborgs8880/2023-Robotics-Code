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


public class ElevatorSubsystem extends SubsystemBase {
    private static ElevatorSubsystem instance = null;

    public static CANSparkMax elevatorMotor;
    //public static CANSparkMax RedLineElevator2;

   // public static MotorControllerGroup RedLineGroup;

    public static ElevatorSubsystem getInstance(){
        if (instance == null){
            System.out.println("ElevatorSubsystem init");
            instance = new ElevatorSubsystem();
        }
        return instance;
    } 

    public ElevatorSubsystem () {
        super();
        //frontLeft.setIdleMode(Spark.Kbrake);

        //Right
        elevatorMotor = new CANSparkMax(Constants.elevatorMotorSpark, CANSparkMaxLowLevel.MotorType.kBrushless);
        //RedLineElevator2 = new CANSparkMax(Constants.RedLineElevatorSpark2, CANSparkMaxLowLevel.MotorType.kBrushed);

       // RedLineGroup = new MotorControllerGroup(RedLineElevator, RedLineElevator2);
    
       //rightGroup.setInverted(true);
       //backRight.setInverted(true);
    }

    public void tankElevatorVolts(double ElevVolts){
        elevatorMotor.setVoltage(ElevVolts*8);
    }

}