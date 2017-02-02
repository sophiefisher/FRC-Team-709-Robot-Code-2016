package org.usfirst.frc.team709.robot.commands;

import org.usfirst.frc.team709.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Kick extends Command {
	double speed;
	long time;
	long endTime;

    public Kick(double speed, long timeInMillis) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kicker);
    	this.speed = speed;
    	this.time = timeInMillis;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	long startTime = System.currentTimeMillis();
        endTime = startTime + time;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.kicker.kick(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return System.currentTimeMillis() >= endTime;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.kicker.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
