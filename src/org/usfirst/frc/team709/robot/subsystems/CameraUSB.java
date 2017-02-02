package org.usfirst.frc.team709.robot.subsystems;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.USBCamera;

/**
 *
 */
public class CameraUSB extends Subsystem {
	
	CameraServer frontserver = CameraServer.getInstance();
	//CameraServer backserver = CameraServer.getInstance();
	
	USBCamera frontcam = new USBCamera("cam2");
	USBCamera backcam = new USBCamera("cam1");

	boolean fcam = false;
	boolean bcam = false;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void streamFrontCam() {
    	//backcam.stopCapture();
    	//frontcam.openCamera();
        //frontcam.startCapture();
    	frontserver.startAutomaticCapture(frontcam);
    	
    	
        fcam = true;
        bcam = false;
    }

    public void streamBackCam() {
    	frontcam.stopCapture();
        backcam.startCapture();
    	//server.startAutomaticCapture("cam1");
    	frontserver.startAutomaticCapture(backcam);
    	
    	
        fcam = false;
        bcam = true;
    }
    
    public void toggleFrontBack() {

    	if (!fcam && !bcam) {
    		//frontcam.startCapture();
    	}
    	else if (fcam && !bcam){
    		//frontcam.stopCapture();
    		//backcam.startCapture();
    	}
    	else if (!fcam && bcam){
    		//backcam.stopCapture();
    		//frontcam.startCapture();
    	}
    }
}

