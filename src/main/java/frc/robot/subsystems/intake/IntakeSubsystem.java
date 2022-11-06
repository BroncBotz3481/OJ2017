package frc.robot.subsystems.intake;


import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

    private final VictorSP spinner;

    private final VictorSP raiser;

    public IntakeSubsystem() {
        spinner = new VictorSP(6);
        raiser = new VictorSP(8);
    }

    public void toggleIntake(double rPower) {
        IntakePolicy.powerToggle = rPower;
        raiser.set(rPower);
    }

    public void spinIntake(double sPower) {
        IntakePolicy.powerSpin = sPower;
        spinner.set(sPower);
    }

    public void stopIntake() {
        IntakePolicy.powerToggle = 0;
        raiser.set(IntakePolicy.powerToggle);
    }

    public void stopSpinningIntake() {
        IntakePolicy.powerSpin = 0;
        spinner.set(IntakePolicy.powerSpin);
    }

}

