package frc.robot.subsystems.drivetrain;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {

    private final VictorSP rightMotor;

    private final VictorSP leftMotor;

    private final DifferentialDrive driveTrain;

    public DrivetrainSubsystem() {
        rightMotor = new VictorSP(0);//placeholders because driveTrain motor controllers not plugged in
        leftMotor = new VictorSP(1);

        leftMotor.setInverted(true);

        rightMotor.setInverted(false);

        driveTrain = new DifferentialDrive(leftMotor, rightMotor);

    }

    public void run(double powerRight, double powerLeft) {
        DrivetrainPolicy.powerLeft = powerLeft;
        DrivetrainPolicy.powerRight = powerRight;

        //powerScale added for safety
        driveTrain.tankDrive(DrivetrainPolicy.powerLeft * .5, DrivetrainPolicy.powerRight * .5);
    }

    public void stop() {
        DrivetrainPolicy.powerLeft = 0;
        DrivetrainPolicy.powerRight = 0;
        driveTrain.tankDrive(DrivetrainPolicy.powerLeft, DrivetrainPolicy.powerRight);
    }
}

