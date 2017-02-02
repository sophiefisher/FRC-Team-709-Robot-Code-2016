package org.usfirst.frc.team709.robot;

import org.usfirst.frc.team709.robot.commands.ArmDown;
import org.usfirst.frc.team709.robot.commands.ArmDownKickDown;
import org.usfirst.frc.team709.robot.commands.ArmMid;
import org.usfirst.frc.team709.robot.commands.ArmUp;
import org.usfirst.frc.team709.robot.commands.ArmUpKickUp;
import org.usfirst.frc.team709.robot.commands.BackCamUSB;
import org.usfirst.frc.team709.robot.commands.CameraPanHome;
import org.usfirst.frc.team709.robot.commands.CameraPanLeft;
import org.usfirst.frc.team709.robot.commands.CameraPanRight;
import org.usfirst.frc.team709.robot.commands.CameraPivotIn;
import org.usfirst.frc.team709.robot.commands.CameraPivotOut;
import org.usfirst.frc.team709.robot.commands.DuckTilt;
import org.usfirst.frc.team709.robot.commands.FrontCamUSB;
import org.usfirst.frc.team709.robot.commands.Kick;
import org.usfirst.frc.team709.robot.commands.KickForwardBack;
//import org.usfirst.frc.team709.robot.commands.Kick;
import org.usfirst.frc.team709.robot.commands.LiftContract;
import org.usfirst.frc.team709.robot.commands.LiftExtend;
import org.usfirst.frc.team709.robot.commands.LiftPivotIn;
import org.usfirst.frc.team709.robot.commands.LiftPivotOut;
import org.usfirst.frc.team709.robot.commands.LowBarDuck;
import org.usfirst.frc.team709.robot.commands.ToggleTilt;
import org.usfirst.frc.team709.robot.commands.USBCameraToggle;
import org.usfirst.frc.team709.robot.commands.WinchFlap;
import org.usfirst.frc.team709.robot.commands.WinchUnwind;
import org.usfirst.frc.team709.robot.commands.WinchWind;
import org.usfirst.frc.team709.robot.commands.WinchWindLiftContract;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

/*import org.usfirst.frc.team709.robot.commands.DuckUpperServo;
import org.usfirst.frc.team709.robot.commands.ExampleCommand;
import org.usfirst.frc.team709.robot.commands.HookArmIn;
import org.usfirst.frc.team709.robot.commands.HookArmOut;
import org.usfirst.frc.team709.robot.commands.PunchBackward;
import org.usfirst.frc.team709.robot.commands.PunchForward;
import org.usfirst.frc.team709.robot.commands.ToggleUpperServo;
*/
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExamplesCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	Joystick stick = new Joystick(1);
	Joystick xbox = new Joystick(2);
	
	Button xbox1 = new JoystickButton(xbox,1);
	Button xbox2 = new JoystickButton(xbox,2);
	//Button xbox9 = new JoystickButton(xbox,9);
	Button xbox10 = new JoystickButton(xbox,10);
	Button xbox5 = new JoystickButton(xbox,5);
	Button xbox6 = new JoystickButton(xbox,6);
	Button xbox7 = new JoystickButton(xbox,7);
	Button xbox8 = new JoystickButton(xbox,8);
	Button xbox9 = new JoystickButton(xbox,9);
	Button button1 = new JoystickButton(stick,1);
	Button button2 = new JoystickButton(stick,2);
	Button button3 = new JoystickButton(stick,3);
	Button button4 = new JoystickButton(stick,4);
	Button button5 = new JoystickButton(stick,5);
	//Button button6 = new JoystickButton(stick,6);
	Button button7 = new JoystickButton(stick,7);
	Button button8 = new JoystickButton(stick,8);
	Button button9 = new JoystickButton(stick,9);
	Button button10 = new JoystickButton(stick,10);
	Button button11 = new JoystickButton(stick,11);


	
	
	public OI() {
		//green
		xbox1.whileHeld(new WinchUnwind());
		//red
		xbox2.whileHeld(new WinchWindLiftContract());
		
		//Left joystick click
		xbox9.whileHeld(new WinchWind());
		
		//Right joystick click
		//xbox4.whenPressed(new KickForwardBack());
		xbox10.whenPressed(new WinchFlap());
		
		//left back
		xbox5.whileHeld(new LiftContract());
		//right back
		xbox6.whileHeld(new LiftExtend());
		
		//back
		xbox7.whileHeld(new LiftPivotIn());
		//start
		xbox8.whileHeld(new LiftPivotOut());

		
		button1.whenPressed(new ArmDown());
		button3.whenPressed(new ArmMid());
		button2.whenPressed(new ArmUp());
		
		button4.whenPressed(new USBCameraToggle());
		button5.whenPressed(new FrontCamUSB());
		button7.whenPressed(new BackCamUSB());
		
		//button3.whenPressed(new LowBarDuck());
		
		//button4.whenPressed(new DuckTilt());
		//button5.whenPressed(new ToggleTilt());
		
		/*button7.whenPressed(new CameraPanHome());
		button10.whenPressed(new CameraPanLeft());
		button11.whenPressed(new CameraPanRight());

		button8.whenPressed(new CameraPivotIn());
		button9.whenPressed(new CameraPivotOut());*/

	}
	
	public Joystick getJoystick() {
		return stick;
	}
	
}



