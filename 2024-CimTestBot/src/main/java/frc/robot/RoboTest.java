// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.cameraserver.CameraServer;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;


public class RoboTest extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private XboxController m_Stick;
  private VictorSP m_leftMotor1;
  private VictorSP m_leftMotor2;
  private VictorSP m_rightMotor1;
  private VictorSP m_rightMotor2;

  private final Timer m_timer = new Timer();

  

  @Override
  public void robotInit() {

    m_leftMotor1= new VictorSP(1);
    m_rightMotor1 = new VictorSP(3);
    m_leftMotor2= new VictorSP(2);
    m_rightMotor2 = new VictorSP(4);

    //m_shooter = new CANSparkMax(10, MotorType.kBrushless);
    
    m_leftMotor1.addFollower(m_leftMotor2);
    m_rightMotor1.addFollower(m_rightMotor1);
  
    /**
     * The RestoreFactoryDefaults method can be used to reset the configuration parameters
     * in the SPARK MAX to their factory default state. If no argument is passed, these
     * parameters will not persist between power cycles
     */


    m_leftMotor1.setInverted(true);
    m_leftMotor2.setInverted(true);


    m_myRobot = new DifferentialDrive(m_leftMotor1, m_rightMotor1);
    m_Stick = new XboxController(0);



    /*intake = new VictorSPX(5);
    horizontal_feed = new TalonSRX(6);
    turret = new VictorSPX(7);
    hood = new TalonSRX(8);
    vertical_feed = new TalonSRX(9);*/


   /* pcmCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
    leftIntakePiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 3, 2);
    leftIntakePiston.set(kForward);
*/
  }

  public void autonomousInit(){
    m_timer.reset();
    m_timer.start();
  }

  public void autonomousPeriodic() {
 
  }

  @Override
  public void teleopPeriodic() {

    m_myRobot.arcadeDrive(-m_Stick.getLeftY(), -m_Stick.getLeftX());

  }
  public void teleopInit(){
    
  }

  }

