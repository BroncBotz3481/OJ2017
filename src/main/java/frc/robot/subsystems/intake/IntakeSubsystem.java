package frc.robot.subsystems.intake;


import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

    private VictorSP spinner;

    private VictorSP raiser;

    public IntakeSubsystem() {
       spinner = new VictorSP(8);
       raiser = new VictorSP(9);
    }

    public void raiseMotor(double power){

    }
}

