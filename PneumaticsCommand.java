// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

//Umar and Usman 

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Timer;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class PneumaticsCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

 // private final PneumaticsSubsystem m_PneumaticsSubsystem;
  private final Timer timer = new Timer();
  private boolean debounce = false;
  boolean isGrabbing = false;
  //private final Elevator m_elevator;
 // private final Intake m_intake;
  //private final Shooter m_shooter;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem  The subsystem used by this command.
   */
  public PneumaticsCommand() {
    super();
    addRequirements(RobotContainer.PSubsystem);  // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //RobotContainer.PSubsystem.grabberSolenoidDisable();
    timer.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    System.out.println(PneumaticsSubsystem.compressor.getPressure()); //new

    boolean LB2Pressed = Robot.driver2.getLeftBumperPressed();
    boolean RB2Pressed = Robot.driver2.getRightBumperPressed();
    boolean xPressed = Robot.driver.getXButton();
    boolean bPressed = Robot.driver.getBButton();
    boolean XPressed = Robot.driver2.getXButton();
    boolean BPressed = Robot.driver2.getBButton();
    boolean LBPressed = Robot.driver.getLeftBumperPressed();
    boolean RBPressed = Robot.driver.getRightBumperPressed();
    boolean startButton2 = Robot.driver2.getStartButton();
    boolean endButton2 = Robot.driver2.getBackButton();
    boolean startButton = Robot.driver.getStartButton();
    boolean endButton = Robot.driver.getBackButton();

    if(LB2Pressed)
    RobotContainer.PSubsystem.actuateCompressorOn();

    if(RB2Pressed)
    RobotContainer.PSubsystem.actuateCompressorOff();

    if(RBPressed)
    RobotContainer.PSubsystem.GrabberOpen();

    if(LBPressed)
    RobotContainer.PSubsystem.GrabberClose();


    //if(startButton2)
    //Robot.PSubsystem.telescopingArmRetract();
        
    //if(endButton2)
    //Robot.PSubsystem.telescopingArmExtend();

     
    //if(xPressed)
    //System.out.print("------------------------------------------------------------");
    //RobotContainer.PSubsystem.grabberSolenoidLeft();
    //RobotContainer.PSubsystem.grabberSolenoidDisable();

   // if(bPressed){
    //System.out.print("IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
    //RobotContainer.PSubsystem.grabberSolenoidRight();
    //RobotContainer.PSubsystem.grabberSolenoidDisable();
   // }

   // else{
     // RobotContainer.PSubsystem.grabberSolenoidDisable();
   // }

    //if(startButton) //HINGE RATCHET RELEASE
    //Robot.PSubsystem.Solenoid2Left();

    //if(endButton) //RATCHET ON
    //Robot.PSubsystem.Solenoid2Right();

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
