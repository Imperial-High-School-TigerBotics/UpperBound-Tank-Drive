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

        left_1.setInverted(OperatorConstants.leftReversed);
        left_2.setInverted(OperatorConstants.leftReversed);

        right_1.setInverted(OperatorConstants.rightReversed);
        right_2.setInverted(OperatorConstants.rightReversed);

    }

    private double applyDeadzone(double value, double deadzone) {
        if (Math.abs(value) > deadzone) {
            return value; // Keep values outside the deadzone
        } else {
            return 0.0; // Set values inside the deadzone to zero
        }
    }

    public void drive_with_controller(XboxController xbox_controller) {
        if(OperatorConstants.isArcadeOperation){
            double forward = -xbox_controller.getRawAxis(OperatorConstants.XBOX_Right_X); // Left stick Y-axis
            double turn = xbox_controller.getRawAxis(OperatorConstants.XBOX_Left_Y);  // Right stick X-axis
        
            // Scale inputs (optional, for fine-tuning)
            forward *= OperatorConstants.speed; // Scale forward/backward speed
            turn *= OperatorConstants.speed;    // Scale turning speed

                // Apply deadzone
            forward = applyDeadzone(forward, 0.09);
            turn = applyDeadzone(turn, 0.09);
        
            // Calculate motor outputs
            double left = forward + turn;
            double right = forward - turn;
        
            // Set motor speeds
            left_1.set(-left);
            left_2.set(-left);

            right_1.set(-right);
            right_2.set(-right);
        }else if(OperatorConstants.isTankOperation){
            double left = -xbox_controller.getRawAxis(OperatorConstants.XBOX_Left_Y); // Left stick Y-axis
            double right = -xbox_controller.getRawAxis(OperatorConstants.XBOX_Right_Y);  // Right stick Y-axis
        
            // Scale inputs (optional, for fine-tuning)
            left *= OperatorConstants.speed; // Scale forward/backward speed
            right *= OperatorConstants.speed;    // Scale turning speed
        
            // Set motor speeds
            left_1.set(left);
            left_2.set(left);

            right_1.set(-right);
            right_2.set(-right);

            System.out.println("left; " + left + "Right" + right );
        }
    }
}