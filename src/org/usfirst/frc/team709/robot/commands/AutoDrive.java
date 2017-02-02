package org.usfirst.frc.team709.robot.commands;

import org.usfirst.frc.team709.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDrive extends Command {
	double outputMagnitude;
	double curve;
	long time;
	long endTime;

    public AutoDrive(double outputMagnitude, double curve, long timeInMillis) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
   
    	requires(Robot.driveTrain);
    	this.outputMagnitude = outputMagnitude;
    	this.curve = curve;
    	this.time = timeInMillis;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.stop();
    	 long startTime = System.currentTimeMillis();
         endTime = startTime + this.time;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.autoDrive(outputMagnitude, curve);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return System.currentTimeMillis() >= endTime;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
