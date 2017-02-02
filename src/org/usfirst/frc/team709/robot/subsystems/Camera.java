	package org.usfirst.frc.team709.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Camera extends Subsystem {
Servo tiltServo = new Servo(7);
Servo panServo = new Servo(8);
Servo pivotServo = new Servo(9);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void panHome() {
    	panServo.set(.5);
    }
    
    public void panLeft() {
    	panServo.set(0);
    }
    
    public void panRight() { 
    	panServo.set(1);
    }
    
    public void pivotOut() {
    	pivotServo.set(.45);
    }
    
    public void pivotIn() {
    	pivotServo.set(.9);
    }
    
    public void toggleTilt() {
    	
    	if (tiltServo.get() == 1) {
    		tiltServo.set(0.0);
    	}
    	
    	else if (tiltServo.get() == 0.0) {
    		tiltServo.set(1.0);
    	}
    	
    	else if (tiltServo.get() != 0.0 || tiltServo.get() != 1.0) {
    		tiltServo.set(0.0);
    	}
    	
    }
    
    public void duckTilt() {
    	if (tiltServo.get() != 0.5){
    		tiltServo.set(0.5);
    	}
    	else if (tiltServo.get() == 0.5){
    		tiltServo.set(0);
    	}
    }
    
    public double getTiltServo() {
    	return tiltServo.get();
    }
    
    public void autoDuck() {
    	tiltServo.set(.5);
    }
    
}

