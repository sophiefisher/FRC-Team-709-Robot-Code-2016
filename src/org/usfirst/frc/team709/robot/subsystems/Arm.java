package org.usfirst.frc.team709.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class Arm extends Subsystem {
	
	Talon motor = new Talon(2);
	//no longer any down limit switch
	//DigitalInput downLimitSwitch = new DigitalInput(0);
    DigitalInput upLimitSwitch = new DigitalInput(2);
    DigitalInput midLimitSwitch = new DigitalInput(0);
    DigitalInput downLimitSwitch = new DigitalInput(1);
    
    //AnalogInput ai = new AnalogInput(1);
    //pot = new AnalogPotentiometer(ai, 360, 30);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void up() {
    	motor.set(.7);
    }
    
    public void down() {
    	motor.set(-.7);
    }
    
    public void stop() {
    	motor.set(0);
    }
    
    public void mid() {
    	if (!upLimitSwitch.get()){
    		down();
    	}
    	else if (!downLimitSwitch.get()){
    		up();
    	}
    }
    
    public boolean isUpSwitchSet(){
    	if (!upLimitSwitch.get()){
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public String displayUpArm() {
    	if (!upLimitSwitch.get()){
    		return "YES";
    	}
    	else {
    		return "NO";
    	}
    }
    
    public boolean isMidSwitchSet(){
    	if (!midLimitSwitch.get()){
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public boolean isDownSwitchSet(){
    	if (!downLimitSwitch.get()){
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public String displayDownArm() {
    	if (!downLimitSwitch.get()){
    		return "YES";
    	}
    	else {
    		return "NO";
    	}
    }

}

