// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.sql.Driver;
import java.util.function.BiPredicate;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;

/** An example command that uses an example subsystem. */
public class Arm extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  /*
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */

  public Arm() {
    super();
    addRequirements(RobotContainer.ArmSubsystem);  // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  

    boolean xPressed = Robot.driver.getXButton();
    boolean bPressed = Robot.driver.getBButton();

    if (xPressed) {
     // Robot.PSubsystem.Solenoid2Right();
      RobotContainer.ArmSubsystem.armVolts(Constants.aVolts * -1);
      System.out.println("RT was pressed");
      //Robot.driver.setRumble(RumbleType.kLeftRumble, 1.0);
    }
    else if (bPressed) {
     // Robot.PSubsystem.Solenoid2Left();
      RobotContainer.ArmSubsystem.armVolts(Constants.aVolts);
      System.out.println("LT was pressed");
      //Robot.driver.setRumble(RumbleType.kRightRumble, 1.0);
    }
    else {
      //System.out.println("Nothing was pressed");
      RobotContainer.ArmSubsystem.armVolts(0);
      //Robot.driver.setRumble(RumbleType.kBothRumble, 0.0);
    }



}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}