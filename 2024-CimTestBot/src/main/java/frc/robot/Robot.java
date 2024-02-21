package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {


  private Command m_autonomousCommand;

  private RobotContainer robotContainer;
  
  private DifferentialDrive myRobot;


  
   //This function is run when the robot is first started up and should be used for any initialization code.
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    robotContainer = new RobotContainer();
    
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *    leftMotor1= new CANSparkMax(1, MotorType.kBrushless);
    rightMotor1 = new CANSparkMax(2, MotorType.kBrushless);
    leftMotor2= new CANSparkMax(3, MotorType.kBrushless);
    rightMotor2 = new CANSparkMax(4, MotorType.kBrushless);

    MotorControllerGroup leftMotors = new MotorControllerGroup(leftMotor1, leftMotor2);
    MotorControllerGroup rightMotors = new MotorControllerGroup(rightMotor1, rightMotor2);

    leftMotor1.restoreFactoryDefaults();
    rightMotor1.restoreFactoryDefaults();
    leftMotor2.restoreFactoryDefaults();
    rightMotor2.restoreFactoryDefaults();

    myRobot = new DifferentialDrive(leftMotors, rightMotors);
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  
  // This function is called once each time the robot enters Disabled mode.
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  
   //This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
  @Override
  public void autonomousInit() {
    m_autonomousCommand = robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  
  // This function is called periodically during autonomous. 
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  
  // This function is called periodically during operator control.
  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  //This function is called periodically during test mode.   
  @Override
  public void testPeriodic() {
  }
}
