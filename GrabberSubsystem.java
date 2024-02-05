/*
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class GrabberSubsystem extends SubsystemBase {
    //DoubleSolenoid pitchSolenoid = null;

    public GrabberSubsystem() {
        //pitchSolenoid = new DoubleSolenoid(RobotMap.SHOOTER_PITCH_SOLENOID_DEPLOY, RobotMap.SHOOTER_PITCH_SOLENOID_RETRACT);

    }

    public void pitchUp(){
        //pitchSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void pitchDown(){
        //pitchSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    //Umar, Zaki, and Uthman
    
}
*/


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


public class GrabberSubsystem extends SubsystemBase {
    /** Creates a new ExampleSubsystem. */
    //DoubleSolenoid grabberSolenoid = new DoubleSolenoid(0, PneumaticsModuleType.CTREPCM, Constants.solenoidForward, Constants.solenoidReverse);

    public GrabberSubsystem() {

    }

    //Solenoid grabbersolenoids = new Solenoid(PneumaticsModuleType.CTREPCM, 0);
    public void ExtendGrabbers() {
       // grabberSolenoid.set(Value.kForward);
        //grabbersolenoids.set(true);
    }

    public void RetractGrabbers() {
      //  grabberSolenoid.set(Value.kReverse);
        //grabbersolenoids.set(false);
    }

    public void DisableGrabbers() {
     //   grabberSolenoid.set(Value.kOff);
        //grabbersolenoids.set(true);
    }

    /**
     * An example method querying a boolean state of the subsystem (for example, a digital sensor).
     *
     * @return value of some boolean subsystem state, such as a digital sensor.
     */
    public boolean exampleCondition() {
        // Query some boolean state, such as a digital sensor.
        return false;
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
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////