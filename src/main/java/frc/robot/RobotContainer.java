// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.IntakeCommands.LowerIntakeCommand;
import frc.robot.commands.IntakeCommands.RaiseIntakeCommand;
import frc.robot.commands.IntakeCommands.RunIntakeCommand;
import frc.robot.commands.IntakeCommands.StopIntakeCommand;
import frc.robot.commands.driveTrainCommands.DrivetrainCommand;
import frc.robot.commands.shooterCommands.ShootCommand;
import frc.robot.commands.shooterCommands.StopShooterCommand;
import frc.robot.subsystems.drivetrain.DrivetrainSubsystem;
import frc.robot.subsystems.intake.IntakeSubsystem;
import frc.robot.subsystems.shooter.ShooterSubsystem;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    // The robot's subsystems and commands are defined here...
    private final DrivetrainSubsystem m_driveTrainSubsystem;

    private final ShooterSubsystem m_shooterSubystem;

    private final IntakeSubsystem m_intakeSubsystem;

    private final XboxController controller0;

    private final XboxController controller1;

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        m_driveTrainSubsystem = new DrivetrainSubsystem();
        m_shooterSubystem = new ShooterSubsystem();
        m_intakeSubsystem = new IntakeSubsystem();
        controller0 = new XboxController(0);
        controller1 = new XboxController(1);
        configureButtonBindings();
    }


    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        m_driveTrainSubsystem.setDefaultCommand(new DrivetrainCommand(m_driveTrainSubsystem, controller0::getLeftY, controller0::getRightY));
        m_shooterSubystem.setDefaultCommand(new StopShooterCommand(m_shooterSubystem));
        m_intakeSubsystem.setDefaultCommand(new StopIntakeCommand(m_intakeSubsystem));

        new Trigger(controller1::getBButton).whileActiveContinuous(new ShootCommand(m_shooterSubystem));
        new Trigger(controller1::getYButton).whileActiveContinuous(new LowerIntakeCommand(m_intakeSubsystem));
        new Trigger(controller1::getXButton).whileActiveContinuous(new RunIntakeCommand(m_intakeSubsystem));
        new Trigger(controller1::getRightBumper).whileActiveContinuous(new RaiseIntakeCommand(m_intakeSubsystem));
    }
    
    
    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand()
    {
        // An ExampleCommand will run in autonomous
        return new StopShooterCommand(m_shooterSubystem);//Just a placeholder command
    }
}
