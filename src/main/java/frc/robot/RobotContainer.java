// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.DriveTrainCmd;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;



/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */

public class RobotContainer{
  // The robot's subsystems and commands are defined here...
  private final DriveTrain m_DriveTrain;
  private final DriveTrainCmd m_DriveTrainCmd;
  private XboxController xbox;

  public Joystick joystickleft = new Joystick(0);
  public Joystick joystickright = new Joystick(0);

  // Replace with CommandPS4Controller or CommandJoystick if needed
  public RobotContainer() {
    xbox = new XboxController(0);
    
    m_DriveTrain = new DriveTrain();
    m_DriveTrainCmd = new DriveTrainCmd(m_DriveTrain, xbox);
    m_DriveTrain.setDefaultCommand(m_DriveTrainCmd);
  }
}
