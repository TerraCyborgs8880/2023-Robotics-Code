package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Timer;


public class Limelight extends SubsystemBase {

    private NetworkTable table;
    private NetworkTableEntry tx;
    private NetworkTableEntry ty;
    private NetworkTableEntry ta;
    private NetworkTableEntry tv;

    private Timer timer = new Timer();
    private double setTime = 0.0;
    private boolean reachedDistance = false;
    private double limelightOffset = 8;

    public Limelight() {
        
            //zaki, umar, taj
            table = NetworkTableInstance.getDefault().getTable("limelight");
            tx = table.getEntry("tx");
            ty = table.getEntry("ty");
            ta = table.getEntry("ta");
            tv = table.getEntry("tv");

            timer.start();

    }
    
    @Override
    public void periodic() {
        double x = tx.getDouble(0.0);
        double y = ty.getDouble(0.0);
        double area = ta.getDouble(0.0);
        boolean v = tv.getInteger(0) == 1;

        //post to smart dashboard periodically
        SmartDashboard.putNumber("LimelightX", x);
        SmartDashboard.putNumber("LimelightY", y);
        SmartDashboard.putNumber("LimelightArea", area);
        SmartDashboard.putBoolean("TargetsVisible", v);  

        //System.out.println(x + "\t" + y + "\t" + area + "\t" + v);
        if (v) {
            double rawDistance = estimateDistance(
                0,
                22.5,
                6
            );

            double distance = Math.abs((double)((int)rawDistance*100)/100);
            // double txCentered = Math.asin((distance*Math.sin(x)+limelightOffset)/distance)*180/(2*Math.PI);
            //System.out.println(distance);
            // System.out.println(txCentered);
            // if(Math.abs(txCentered) >= 3.0){
            //     RobotContainer.Drivetrain.tankDriveVolts((Math.abs(txCentered))/(txCentered)*-0.5,(Math.abs(txCentered))/(txCentered)*0.7 );
                
            //     return; 
            // }

            if (distance > 75.0) {
                RobotContainer.Drivetrain.tankDriveVolts(-0.5, -0.7);
                return;
            }
            System.out.println("distance reached");
            double currentTime = timer.get();

            if (!reachedDistance) {
                reachedDistance = true;
                setTime = currentTime;
                System.out.println("arm started");
                return;
            }

            if (currentTime >= (setTime + 7)) {
                RobotContainer.ElevatorSubsystem.tankElevatorVolts(0);
                System.out.println("elevator should have gone up");
                return;
            }

            RobotContainer.ElevatorSubsystem.tankElevatorVolts(1.0);
            System.out.println("arm should be going up");

            }
            else {
                //RobotContainer.ElevatorSubsystem.tankElevatorVolts(-0.35);
            }


        RobotContainer.Drivetrain.tankDriveVolts(0,0);
    }



    public double estimateDistance(double limelightMountAngleDegrees, double limelightLensHeightInches, double goalHeightInches) {
        NetworkTable _table = NetworkTableInstance.getDefault().getTable("limelight");
        NetworkTableEntry _ty = _table.getEntry("ty");
        double targetOffsetAngle_Vertical = _ty.getDouble(0.0);
        double angleToGoalDegrees = limelightMountAngleDegrees + targetOffsetAngle_Vertical;
        double angleToGoalRadians = angleToGoalDegrees * (Math.PI / 180.0);
    
        //calculate distance
        double distanceFromLimelightToGoalInches = (goalHeightInches - limelightLensHeightInches)/Math.tan(angleToGoalRadians);
        return distanceFromLimelightToGoalInches;
    }

}
