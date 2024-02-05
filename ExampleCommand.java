// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

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
public class ExampleCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ExampleSubsystem m_subsystem;
  private final Drivetrain m_drivetrain;
  private final ElevatorSubsystem m_elevatorSubsystem;
  private final ArmSubsystem m_armSubsystem;
  private final GrabberSubsystem m_GrabberSubsystem;
  private final Limelight m_limelight;
  private final Timer timer;
  private final PneumaticsSubsystem m_pSubsystem;
  private final NavX2Subsystem m_navX2Subsystem;
  private boolean atAngle;
  private int stage;

  /**
   * Creates a new ExampleCommand.
 * @param m_autonomous
 * @param m_autonomous
   */
  public ExampleCommand(ExampleSubsystem subsystem, Drivetrain drivetrain, ElevatorSubsystem elevatorSubsystem, ArmSubsystem armSubsystem, Limelight limelight, GrabberSubsystem grabberSubsystem, PneumaticsSubsystem pSubsystem, NavX2Subsystem navX2Subsystem) {
    m_subsystem = subsystem;
    m_drivetrain = drivetrain;
    m_elevatorSubsystem = elevatorSubsystem;
    m_armSubsystem = armSubsystem;
    m_limelight = limelight;
    m_GrabberSubsystem = grabberSubsystem;
    m_pSubsystem = pSubsystem;
    m_navX2Subsystem = navX2Subsystem;
    timer = new Timer();

    addRequirements(m_subsystem);
    //addRequirements(drivetrain);
    //addRequirements();
   // addRequirements(m_drivetrain);
   // addRequirements(m_elevatorSubsystem);
   // addRequirements(m_armSubsystem);
   // addRequirements(m_pSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

   // m_drivetrain.tankDriveVolts(0.5, 0.5);
}

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
