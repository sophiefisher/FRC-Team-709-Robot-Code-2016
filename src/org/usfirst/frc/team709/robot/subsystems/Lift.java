package org.usfirst.frc.team709.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class Lift extends Subsystem {
	
	Talon pivotTalon = new Talon(6);
	Talon extendTalon = new Talon(5);
	
	AnalogInput ai = new AnalogInput(0);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void pivotOut() {
    	pivotTalon.set(1);
    }
    
    public void pivotIn() {
    	pivotTalon.set(-1);
    }
    
    public void pivotStop() {
    	pivotTalon.set(0);
    }
    
    public void extend() {
    	extendTalon.set(1);
    	//System.out.println(ai.getValue());
    }
    
    public void contract() {
    	extendTalon.set(-.5);
    	//System.out.println(ai.getValue());
    }
    
    public void extendStop() {
    	extendTalon.set(0);
    }
    public boolean hasReachedMax(){
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
    }
    
    public double getAi(){
    	return ai.getValue();
    }
}

