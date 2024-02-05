package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class GrabberUp extends CommandBase {
    public GrabberUp() {
        super();
        addRequirements(RobotContainer.GrabberSubsystem);
    }

    // Called once when the command executes
    @Override
    public void initialize() {
        RobotContainer.GrabberSubsystem.ExtendGrabbers();
    }

    //Umar, Zaki, Uthman
}

