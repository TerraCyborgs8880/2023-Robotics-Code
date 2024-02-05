// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
/* 
package frc.robot.commands;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Constants;
//import com.kauailabs.navx.frc.*;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/** An example command that uses an example subsystem. */
/*public class autoCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Autonomous m_autonomous;
  private final Drivetrain m_drivetrain;
  private final ElevatorSubsystem m_elevatorSubsystem;
  private final ArmSubsystem m_armSubsystem;
  private final GrabberSubsystem m_GrabberSubsystem;
  private final Limelight m_limelight;
  private final Timer timer;
  private final PneumaticsSubsystem m_pSubsystem;
  private boolean atAngle;
  private int stage;
  */
  /**
   * Creates a new ExampleCommand.
   /* 
   * @param subsystem  The subsystem used by this command.
   
  public autoCommand(Autonomous subsystem, Drivetrain drivetrain, ElevatorSubsystem elevatorSubsystem, ArmSubsystem armSubsystem, Limelight limelight, GrabberSubsystem grabberSubsystem, PneumaticsSubsystem pSubsystem) {
    m_autonomous = subsystem;
    m_drivetrain = drivetrain;
    m_elevatorSubsystem = elevatorSubsystem;
    m_armSubsystem = armSubsystem;
    m_limelight = limelight;
    m_GrabberSubsystem = grabberSubsystem;
    m_pSubsystem = pSubsystem;
    timer = new Timer();
    */
    //addRequirements(m_autonomous);
   // addRequirements(m_drivetrain);
    //addRequirements(m_drivetrain);
   // addRequirements(m_elevatorSubsystem);
   // addRequirements(m_armSubsystem);
   // addRequirements(m_pSubsystem);
  //}
/* 
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.start();  //Starts timer
    atAngle = false;
    stage = 0;
    m_autonomous.reset();
    m_autonomous.calibrate();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   /*double time = timer.get();  //Gets time elapsed in seconds
    SmartDashboard.putNumber("stage: ", stage);
    SmartDashboard.putNumber("timer", time);
    m_autonomous.print();


  if (time < 1){
    m_pSubsystem.actuateCompressorOn();
    m_pSubsystem.GrabberClose();
    m_autonomous.getAngle();
    m_drivetrain.tankDriveVolts(1, 1);
  }
  else if (time < 3){
    m_elevatorSubsystem.tankElevatorVolts(Constants.elevatorVolts);
  }
  else if (time < 4){
    m_drivetrain.tankDriveVolts(0.5, 0.5);
  }
  else if (time < 4.5){
    m_pSubsystem.GrabberOpen();
  }
  else if (time< 5){
    m_drivetrain.tankDriveVolts(0, 0);
    m_elevatorSubsystem.tankElevatorVolts(0);

 }
}*/
//  }
/*
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    timer.stop(); //stops the timer once autonomous ends
    timer.reset();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
 */
