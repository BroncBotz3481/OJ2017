package frc.robot.commands.shooterCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter.ShooterSubsystem;


public class ShootCommand extends CommandBase {

    private final ShooterSubsystem m_shooterSubsystem;

    public ShootCommand(ShooterSubsystem subsystem) {
        m_shooterSubsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        m_shooterSubsystem.shoot(0.8);
    }

    @Override
    public void end(boolean interrupted) {
        m_shooterSubsystem.stopShooter();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
