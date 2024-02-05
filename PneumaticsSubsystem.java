// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// Umar and Usman

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.*;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;

public class PneumaticsSubsystem extends SubsystemBase {
  
    private static PneumaticsSubsystem instance = null;
  
    //NOTE: may need to make these static
    public static Compressor compressor;
    public DoubleSolenoid telescoperSolenoid1;
    public DoubleSolenoid telescoperSolenoid2;
    public DoubleSolenoid Grabber;
    public DoubleSolenoid grabberSolenoid;



  public PneumaticsSubsystem() { // 
    super();

    compressor = new Compressor(PneumaticsModuleType.CTREPCM);
    Grabber = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 6, 7);
    //telescoperSolenoid1 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
    //telescoperSolenoid2 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 4, 5);
    //grabberSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);
  }


  private static PneumaticsSubsystem getInstance(){

    if (instance == null){
        System.out.println("PneumaticsSubsystem init");
        instance = new PneumaticsSubsystem();
    }
    return instance;

  }

//Actual methods
/* 
public void actuateCompressor(Boolean CompressorOn, Boolean CompressorOff){
    if(Robot.driver.getLeftStickButtonPressed() && activate){

      System.out.print("LStick was pressed");
        compressor.enableDigital();
        activate = false;

    } else if (Robot.driver.getLeftStickButtonPressed() && !activate){

        compressor.disable();
        activate = true;

    }
}
*/

public void actuateCompressorOn(){
    System.out.print("RB was pressed");
      compressor.enableDigital();
}

public void actuateCompressorOff(){
  System.out.print("LB was pressed");
    compressor.disable();
}

public void GrabberOpen(){
  Grabber.set(DoubleSolenoid.Value.kReverse);
}

public void GrabberClose(){
  Grabber.set(DoubleSolenoid.Value.kForward);
}


//
/*
public void telescopingArmRetract(){
      System.out.print("Left Bumper Pressed @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
      telescoperSolenoid1.set(Value.kReverse);
      //telescoperSolenoid2.set(Value.kReverse);
        // telescoperSolenoid1.toggle();
     // telescoperSolenoid2.toggle();

      }

public void telescopingArmExtend(){
    telescoperSolenoid1.set(Value.kForward);
    //telescoperSolenoid2.set(Value.kForward);
}

public void grabberSolenoidLeft(){
  grabberSolenoid.set(DoubleSolenoid.Value.kForward);
}

public void grabberSolenoidRight(){
  grabberSolenoid.set(DoubleSolenoid.Value.kReverse);
}

public void grabberSolenoidDisable(){
  grabberSolenoid.set(DoubleSolenoid.Value.kOff);
}

public void Solenoid2Left(){ //HINGE RACTHET
  telescoperSolenoid2.set(DoubleSolenoid.Value.kReverse);
}

//public void Solenoid2Right(){
//  telescoperSolenoid2.set(DoubleSolenoid.Value.kForward);
//}
*/

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
