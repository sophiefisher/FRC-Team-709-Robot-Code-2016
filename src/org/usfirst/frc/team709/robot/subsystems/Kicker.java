package org.usfirst.frc.team709.robot.subsystems;

import org.usfirst.frc.team709.robot.commands.DriveWithJoysticks;
//import org.usfirst.frc.team709.robot.commands.Kick;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Kicker extends Subsystem {
	
	//Talon motor = new Talon(4);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new Kick());
    }
    
    public void kick(double speed) {
    	//motor.set(speed);
    }
    
    public void stop() {
    	//motor.set(0);
    }
    
    
}

