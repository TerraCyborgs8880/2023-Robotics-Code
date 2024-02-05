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
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.revrobotics.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


public class ArmSubsystem extends SubsystemBase {
    private static ArmSubsystem instance = null;

    public static CANSparkMax Arm;
    //public static DoubleSolenoid ratchetSolenoid; //new

    public static ArmSubsystem getInstance(){
        if (instance == null){
            System.out.println("ArmSubsystem init");
            instance = new ArmSubsystem();
        }
        return instance;
    } 

    public ArmSubsystem () {
        super();
    //  Arm.setIdleMode(IdleMode.kBrake);
        

        //Right
        Arm = new CANSparkMax(Constants.armSpark, CANSparkMaxLowLevel.MotorType.kBrushless);
        //ratchetSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3); //new

       //rightGroup.setInverted(true);
    }

    public void armVolts(double aVolts){
        Arm.setVoltage(aVolts*5);
    }

    //public void ratchetSolenoidOn(){
      //  ratchetSolenoid.set(Value.kReverse);
    //}
      
    //public void ratchetSolenoidOff(){
      //  ratchetSolenoid.set(Value.kForward);
    //}

}