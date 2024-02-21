/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.VictorSPXConfiguration;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Drivetrain extends SubsystemBase {

  //define Spark Maxes with IDs and as brushless controllers
  private VictorSP backLeft = new VictorSP(Constants.BACK_LEFT_VICTORSPX_ID);
  private VictorSP frontLeft = new VictorSP(Constants.FRONT_LEFT_VICTORSPX_ID);
  private VictorSP backRight = new VictorSP(Constants.BACK_RIGHT_VICTORSPX_ID);
  private VictorSP frontRight = new VictorSP(Constants.FRONT_RIGHT_VICTORSPX_ID);


	// define drive
	private final DifferentialDrive drive = new DifferentialDrive(frontLeft, frontRight);

	public Drivetrain() {
		backLeft.addFollower(frontLeft);
		backRight.addFollower(backLeft);
	}

	public void arcadeDrive(double fwd, double rot) {
		drive.arcadeDrive(fwd, rot);
	}

	public void curvatureDrive(double fwd, double rot, boolean isQuickTurn) {
		drive.curvatureDrive(fwd, rot, isQuickTurn);
	}

	public void setMaxOutput(double maxOutput) {
		drive.setMaxOutput(maxOutput);
	}

	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}
}
