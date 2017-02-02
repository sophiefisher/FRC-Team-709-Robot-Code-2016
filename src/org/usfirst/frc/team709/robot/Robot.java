
package org.usfirst.frc.team709.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.USBCamera;

import org.usfirst.frc.team709.robot.commands.ArmDownDrive;
import org.usfirst.frc.team709.robot.commands.ArmMidDrive;
import org.usfirst.frc.team709.robot.commands.ArmUp;
import org.usfirst.frc.team709.robot.commands.AutoArmDown;
import org.usfirst.frc.team709.robot.commands.AutoDrive;
import org.usfirst.frc.team709.robot.commands.AutoDuckDrive;
//import org.usfirst.frc.team709.robot.commands.Kick;
//import org.usfirst.frc.team709.robot.commands.ExampleCommand;
import org.usfirst.frc.team709.robot.subsystems.Arm;
import org.usfirst.frc.team709.robot.subsystems.Camera;
import org.usfirst.frc.team709.robot.subsystems.CameraUSB;
import org.usfirst.frc.team709.robot.subsystems.DriveTrain;
import org.usfirst.frc.team709.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team709.robot.subsystems.Kicker;
import org.usfirst.frc.team709.robot.subsystems.Lift;
import org.usfirst.frc.team709.robot.subsystems.Winch;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static DriveTrain driveTrain;
	public static Arm arm;
	public static Kicker kicker;
	public static Camera camera;
	public static Lift lift;
	public static Winch winch;
	public static CameraUSB cameraUSB;
	public static OI oi;

    Command autonomousCommand;
    SendableChooser autoChooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	driveTrain = new DriveTrain();
    	arm = new Arm();
    	kicker = new Kicker();
    	camera = new Camera();
    	lift = new Lift();
    	winch = new Winch();
    	cameraUSB = new CameraUSB();
		oi = new OI();
        // instantiate the command used for the autonomous period
		
        autoChooser = new SendableChooser();
        autoChooser.addObject("Arm Down Drive Forward", new ArmDownDrive());
        autoChooser.addObject("Arm Middle Drive Forward", new ArmMidDrive());
        autoChooser.addObject("Drive Forward", new AutoDrive(-.5,0,4000));
        autoChooser.addObject("Drive Backwards", new AutoDrive(.5,0,4000));
        //autoChooser.addObject("Arm Up", new ArmUp());
        autoChooser.addObject("No Autonomous", new AutoDrive(0,0,0));
        
        //autoChooser.addObject("Kick", new Kick());
        SmartDashboard.putData("Autonomous mode chooser", autoChooser);
		
		//autonomousCommand = new AutoDuckDrive();
		//autonomousCommand = new AutoDrive(-.5,0,7000);
        
        //turn a camera on
        cameraUSB.streamFrontCam();
        
        //set winch flap out
        winch.setFlapOut();
        
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	
    	autonomousCommand = (Command) autoChooser.getSelected();
    	if (autonomousCommand != null) autonomousCommand.start();
    	
    	
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        //System.out.println(lift.getAi());
        //System.out.println(winch.getFlapPos());
        //SmartDashboard.putNumber("Winch Flap", winch.getFlapPos());
        SmartDashboard.putString("Winch Flap:", winch.displayFlapPos());
        SmartDashboard.putString("Arm Up:",arm.displayUpArm());
        SmartDashboard.putString("Arm Down:",arm.displayDownArm());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
