package org.usfirst.frc.team709.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Winch extends Subsystem {
    
	Talon winchTalon = new Talon(3);
	Servo winchFlap = new Servo(4);
	
	//AnalogInput ai = new AnalogInput(0);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void wind() {
    	winchTalon.set(.9);	
    }
    
    public void unwind() {
    	winchTalon.set(-.9);	
    }
    
    public void stop() {
    	winchTalon.set(0);
    }
    
    /*public boolean hasReachedMax(){
    	if (ai.getValue() <=3970){
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public boolean hasReachedMin(){
    	if (ai.getValue() >= 3970 ){
    		return true;
    	}
    	else {
    		return false;
    	}
    }*/
    
    public void toggleFlap() {
    	if (winchFlap.get() == .35){
    		winchFlap.set(0);
    	}
    	else if (winchFlap.get() == 0){
    		winchFlap.set(.35);
    	}
    	
    	else if (winchFlap.get() != .35 || winchFlap.get() != 0){
    		winchFlap.set(.35);
    	}
    	
    }
    public double getFlapPos() {
    	return winchFlap.get();
    }
    
    public String displayFlapPos() {
    	if (winchFlap.get() == 0) return "IN";
    	else if (winchFlap.get() == .35) return "OUT";
    	else return "This should not happen";
    }
    
    public void setFlapIn() {
    	winchFlap.set(0);
    }
    
    public void setFlapOut() {
    	winchFlap.set(.35);
    }
}

