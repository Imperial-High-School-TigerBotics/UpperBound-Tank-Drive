package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrain;

public class DriveTrainCmd extends Command {
    private DriveTrain drivetrain;
    private XboxController xbox;

    public DriveTrainCmd(DriveTrain dt, XboxController xbox) {
        this.drivetrain = dt;
        this.xbox = xbox;
        addRequirements(dt);
    }

    @Override
    public void execute() {
        drivetrain.drive_with_controller(xbox);
    }
}
