package frc.robot.subsystems.shooter;


import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

    private final VictorSP shooterMotor;

    public ShooterSubsystem() {
        shooterMotor = new VictorSP(7);
    }

    public void shoot(double shootPower) {
        ShooterPolicy.power = shootPower;
        shooterMotor.set(ShooterPolicy.power);
    }

    public void stopShooter() {
        ShooterPolicy.power = 0;
        shooterMotor.set(ShooterPolicy.power);
    }

}

