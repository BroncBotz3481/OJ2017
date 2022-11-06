package frc.robot.commands.shooterCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter.ShooterSubsystem;


public class StopShooterCommand extends CommandBase {

    private final ShooterSubsystem m_shooterSubsystem;

    public StopShooterCommand(ShooterSubsystem subsystem) {
        m_shooterSubsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        m_shooterSubsystem.stopShooter();
    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
