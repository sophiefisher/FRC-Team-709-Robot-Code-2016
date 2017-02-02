
package org.usfirst.frc.team709.robot.subsystems;

import org.usfirst.frc.team709.robot.commands.DriveWithJoysticks;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
*
*/
public class DriveTrain extends Subsystem {
	Talon leftMotors = new Talon(0);
	Talon rightMotors = new Talon(1);

	
	
	RobotDrive robotDrive1 = new RobotDrive(leftMotors, rightMotors);
	
	
	
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveWithJoysticks());
    }
    
    public void takeJoystickInputs(Joystick stick) {
    	/*robotDrive1.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
    	robotDrive1.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
    	robotDrive1.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
    	robotDrive1.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);*/
    	leftMotors.setInverted(true);
    	rightMotors.setInverted(true);
    	robotDrive1.arcadeDrive(stick);
    	//robotDrive1.setSafetyEnabled(false);	
    	//robotDrive1.setSafetyEnabled(false));	
    }
    
    public void autoDrive(double outputMagnitude, double curve) {
    	//robotDrive1.setSafetyEnabled(true);	
    	robotDrive1.drive(outputMagnitude, curve);
    }
    
    public void stop() {
    	robotDrive1.drive(0,0);
    }
}

