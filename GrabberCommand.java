///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.Robot;
import frc.robot.subsystems.GrabberSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class GrabberCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final GrabberSubsystem m_subsystem;

    private final Timer timer = new Timer();
    private boolean debounce = false;
    boolean isGrabbing = false;


    public GrabberCommand(GrabberSubsystem subsystem) {
        m_subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        m_subsystem.DisableGrabbers();
        timer.reset();
    }

    @Override
    public void execute() {
       if (Robot.driver.getRightBumperPressed()) {

            if (timer.hasElapsed(0.75)) {
                timer.stop();
                timer.reset();
                debounce = false;
            }

            if (!debounce) {
                if (!isGrabbing) {
                    isGrabbing = true;
                    m_subsystem.ExtendGrabbers();

                } else {
                    isGrabbing = false;
                    m_subsystem.RetractGrabbers();
                }

                debounce = true;
                timer.start();
            }
        }
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}