package frc.robot.commands.driveTrainCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drivetrain.DrivetrainSubsystem;

import java.util.function.DoubleSupplier;


public class DrivetrainCommand extends CommandBase {

    private final DrivetrainSubsystem m_driveTrainSubsystem;

    private final DoubleSupplier m_leftPower, m_rightPower;

    public DrivetrainCommand(DrivetrainSubsystem subsystem, DoubleSupplier leftPower, DoubleSupplier rightPower) {
        m_driveTrainSubsystem = subsystem;
        m_leftPower = leftPower;
        m_rightPower = rightPower;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        m_driveTrainSubsystem.run(m_leftPower.getAsDouble(), m_rightPower.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        m_driveTrainSubsystem.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
