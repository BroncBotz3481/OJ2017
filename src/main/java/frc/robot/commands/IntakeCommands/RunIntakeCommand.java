package frc.robot.commands.IntakeCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intake.IntakeSubsystem;


public class RunIntakeCommand extends CommandBase {

    private final IntakeSubsystem m_intakeSubsystem;

    public RunIntakeCommand(IntakeSubsystem subsystem) {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        m_intakeSubsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        m_intakeSubsystem.spinIntake(0.5);
    }

    @Override
    public void end(boolean interrupted) {
        m_intakeSubsystem.stopSpinningIntake();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
