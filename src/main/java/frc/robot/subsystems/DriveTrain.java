package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

public class DriveTrain extends SubsystemBase {

    private CANSparkMax right_1;
    private CANSparkMax right_2;
    private CANSparkMax left_1;
    private CANSparkMax left_2;


    public DriveTrain() {
        right_1 = new CANSparkMax(OperatorConstants.rightMotor1, MotorType.kBrushless);
        right_2 = new CANSparkMax(OperatorConstants.rightMotor2, MotorType.kBrushless);
        left_1 = new CANSparkMax(OperatorConstants.leftMotor1, MotorType.kBrushless);
        left_2 = new CANSparkMax(OperatorConstants.leftMotor2, MotorType.kBrushless);
    }

    public void drive_with_controller(XboxController xbox_controller) {

        double forward = -xbox_controller.getRawAxis(Constants.OperatorConstants.XBOX_Left_Y); // Left stick Y-axis
        double turn = xbox_controller.getRawAxis(Constants.OperatorConstants.XBOX_Right_X);  // Right stick X-axis
    
        // Scale inputs (optional, for fine-tuning)
        forward *= OperatorConstants.speed; // Scale forward/backward speed
        turn *= OperatorConstants.speed;    // Scale turning speed
    
        // Calculate motor outputs
        double left = forward + turn;
        double right = forward - turn;
    
        // Set motor speeds
        left_1.set(left);
        left_2.set(left);

        right_1.set(-right);
        right_2.set(-right);
    }
}