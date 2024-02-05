// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.VideoSource.ConnectionStrategy;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.Limelight;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  //public static PneumaticsSubsystem pSubsystem = new PneumaticsSubsystem();
  private Command m_autonomousCommand;
  // public static ExampleSubsystem ExampleSubsystem = new ExampleSubsystem();
  public static Command pMaticsCommand;
  public static Command driveCommand;
  public static Command elevatorCommand;
  public static Command armCommand;
  public static Command grabberUp;
  public static Command grabberDown;
  private static Timer timer;
  private static double startTimer;
  public static Limelight limelight;
  //public static ElevatorSubsystem ElevatorSubsystem = new ElevatorSubsystem();
  // public static Command exampleCommand;
  //private Compressor compressor;
  //private DoubleSolenoid solenoid1;


  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  
  public Robot(){
  }

  private RobotContainer m_robotContainer;
  public static final XboxController driver = new XboxController(0);
  public static final XboxController driver2 = new XboxController(1);

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.

    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("Custom Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    
    m_robotContainer = new RobotContainer();
    driveCommand = new Drive();
    elevatorCommand = new Elevator();
    armCommand = new Arm();
    grabberUp = new GrabberUp();
    grabberDown = new GrabberDown();
    pMaticsCommand = new PneumaticsCommand(); //NOTE: check this please
    timer = new Timer();
    limelight = new Limelight();
    

    
  }


  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();

    m_autoSelected = m_chooser.getSelected();
    System.out.println("Auto selected: " + m_autoSelected);

    switch (m_autoSelected) {
      case kCustomAuto:
        limelight.periodic();
        System.out.println("tase");
        break;
      case kDefaultAuto:
        default:
          RobotContainer.PSubsystem.GrabberClose();
          try{
            /*
            * NOTE: KEEP THE BATTERY LEVEL IN MIND WHEN
            * TWEAKING VALUES AS IT CAN AFFECT THINGS
            */


            //1 is equivalent to 1 ms, 1000 is equivalent to 1 s
            //lift arm up
            RobotContainer.ElevatorSubsystem.tankElevatorVolts(0.45);
            Thread.sleep(2400);
            RobotContainer.ElevatorSubsystem.tankElevatorVolts(0);
            
            //extend arm
            RobotContainer.ArmSubsystem.armVolts(0.5);
            Thread.sleep(2700);
            RobotContainer.ArmSubsystem.armVolts(0);
          
            //open grabber
            RobotContainer.PSubsystem.GrabberOpen();
            Thread.sleep(500);
            
            //retract arm
            RobotContainer.ArmSubsystem.armVolts(-0.5);      
            Thread.sleep(2700);
            RobotContainer.ArmSubsystem.armVolts(0);
            
            //lower arm
            RobotContainer.ElevatorSubsystem.tankElevatorVolts(-0.5);
            Thread.sleep(2050);
            RobotContainer.ElevatorSubsystem.tankElevatorVolts(0);
            
            //move forward
            //tweak values here based on battery, the robot should stop at charging station and should be partially on so
          //  timer.start();
            for(int i = 0; i < 100; i++) {
              for (int h = 0; h < 130; h++){
              RobotContainer.Drivetrain.tankDriveVolts(0.5, 0.6);
            }
          }
            RobotContainer.Drivetrain.tankDriveVolts(0, 0);
            
            }
          catch(Exception e){
            System.out.println("ERROR");
            throw new RuntimeException(e);
          }
          
        
          
          // schedule the autonomous command (example)      
          if (m_autonomousCommand != null) {
            m_autonomousCommand.schedule();
          }
            break;
        }
      }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {

    

  }

      public void balance(){
        double gyroRoll = NavX2Subsystem.navX2Micro.getRoll();

        if (Math.abs(gyroRoll) < Constants.gyroDeadzone) {
            gyroRoll = 0; 
        }
        System.out.println("Adjusted Value:\t" + round(gyroRoll, 4) + 
        "\t Actual Value: " + round(NavX2Subsystem.navX2Micro.getRoll(), 4));
        double balanceSpeed = NavX2Subsystem.navX2Micro.getRoll()/50;
        RobotContainer.Drivetrain.tankDriveVolts(balanceSpeed, balanceSpeed);

        
    }

    public double round(double num, int places) {
      return Math.round(num * Math.pow(10, places)) / Math.pow(10, places);
    }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    driveCommand.schedule();
    elevatorCommand.schedule();
    armCommand.schedule();
    pMaticsCommand.schedule();

  }
  
  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
//  @Override
 // public void simulationInit() {}

  /** This function is called periodically whilst in simulwation. */
 // @Override
 // public void simulationPeriodic() {}
}




//sulaiman was here cuz he wrote this entire code jk it was copy 