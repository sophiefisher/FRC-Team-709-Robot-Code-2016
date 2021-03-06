package org.usfirst.frc.team709.robot.commands;

import org.usfirst.frc.team709.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WinchFlap extends Command {
	public boolean winchFlapToggled = false;
	
    public WinchFlap() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.winch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	winchFlapToggled = false;
    	Robot.winch.toggleFlap();
    	winchFlapToggled = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (winchFlapToggled){
        	return true;
        }
        else {
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
