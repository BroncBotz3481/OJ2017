package frc.robot.subsystems.drivetrain;


import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class DrivetrainSubsystem extends SubsystemBase {

    private VictorSP rightMotor;

    private VictorSP leftMotor;

    private DifferentialDrive driveTrain;

    public DrivetrainSubsystem() {
        rightMotor = new VictorSP(1);
        leftMotor = new VictorSP(2);

        leftMotor.setInverted(true);

        rightMotor.setInverted(false);

        driveTrain = new DifferentialDrive(leftMotor,rightMotor);

    }

    public void run(double powerRight, double powerLeft){
        DrivetrainPolicy.powerLeft = powerLeft;
        DrivetrainPolicy.powerRight = powerRight;

        //powerScale added for safety
        driveTrain.tankDrive(DrivetrainPolicy.powerLeft * .5,DrivetrainPolicy.powerRight *.5);
    }
}

