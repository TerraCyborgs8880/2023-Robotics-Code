// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
/*
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.kauailabs.navx.frc.*;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SerialPort.Port;
import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Autonomous extends SubsystemBase {
    /** Creates a new ExampleSubsystem. */
    /* 
    public static AHRS gyro;
    NetworkTableEntry tx;
    NetworkTableEntry ty;
    NetworkTableEntry ta;

    public Autonomous() {
      gyro = new AHRS(Port.kUSB);
      //Initialize Limelight's network table
      NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
      //Create objects for each important limelight entry
      tx = table.getEntry("tx");
      ty = table.getEntry("ty");
      ta = table.getEntry("ta");
    }
  
   public void print(){
      SmartDashboard.putNumber("Yaw:", gyro.getYaw());
      SmartDashboard.putNumber("displacement x:", gyro.getDisplacementX());
      SmartDashboard.putNumber("displacement y:", gyro.getDisplacementY());
      SmartDashboard.putNumber("displacement z:", gyro.getDisplacementZ());
      //Extract Table Entry into double
      double x = tx.getDouble(0.0);
      double y = ty.getDouble(0.0);
      double area = ta.getDouble(0.0);
      //Print limelight data to smartdashboard
      SmartDashboard.putNumber("LimelightX", x);
      SmartDashboard.putNumber("LimelightY", y);
      SmartDashboard.putNumber("LimelightArea", area);
    }
  
    public void reset(){
      gyro.reset();
    }

    public void calibrate(){
      gyro.calibrate();
    }

    public void getAngle(){
      gyro.getAngle();
      System.out.println(gyro.getAngle());
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
      
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
*/
