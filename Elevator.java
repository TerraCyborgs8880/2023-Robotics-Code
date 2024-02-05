// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.*;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

/** An example command that uses an example subsystem. */
public class Elevator extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */

  public Elevator() {
    super();
    addRequirements(RobotContainer.ElevatorSubsystem);  // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    double LTPressed = Robot.driver.getLeftTriggerAxis();
    double RTPressed = Robot.driver.getRightTriggerAxis();

    
    if(RTPressed > 0 && LTPressed == 0){
        RobotContainer.ElevatorSubsystem.tankElevatorVolts(Constants.elevatorVolts);
        System.out.println("A was pressed");
      }
      else if (LTPressed > 0 && RTPressed == 0) {
        System.out.println("Y was pressed");
        RobotContainer.ElevatorSubsystem.tankElevatorVolts(Constants.elevatorVolts*-1);
      }
      /* 
      else if (isClimberUp && Robot.Elevator.getElevatorTicks() < 10000) {
        Robot.Elevator.lift(0.4); //Need to test for balanced power
      }
      */
      else{
        //System.out.println("Nothing was pressed");
        RobotContainer.ElevatorSubsystem.tankElevatorVolts(0);
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
