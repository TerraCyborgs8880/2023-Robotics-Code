package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

//Zakayy
public class SparkySubsystem extends SubsystemBase {

    public static SparkySubsystem instance = null;

    public static CANSparkMax Sparky;

    public SparkySubsystem() {
        super();

        Sparky = new CANSparkMax(Constants.armSpark, CANSparkMaxLowLevel.MotorType.kBrushed);
    }
}
