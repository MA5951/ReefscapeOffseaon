// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.MAutils.CanBus.StatusSignalsRunner;
import com.MAutils.Logger.MALog;
import com.MAutils.PoseEstimation.PoseEstimator;
import com.MAutils.Simulation.SimulationManager;
import com.MAutils.Utils.ConvUtil;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private final RobotContainer m_robotContainer;
  private double  i = 0;

  public Robot() {
    m_robotContainer = new RobotContainer();
    PoseEstimator.resetPose(new Pose2d(2, 2, new Rotation2d()));

    MALog.log("/Simulation/Robot/Elevator 1", new Pose3d(0, 0, i, new Rotation3d()));
    MALog.log("/Simulation/Robot/Gripper", new Pose3d(0, 0, i * 2, new Rotation3d()));
    MALog.log("/Simulation/Robot/Gripper Arm", new Pose3d(0, 0, i * 2, new Rotation3d(0,-i*100,0)));

  }

  @Override
  public void robotPeriodic() {
    StatusSignalsRunner.refreshAll();
    CommandScheduler.getInstance().run();

    PoseEstimator.update();

  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void disabledExit() {
  }

  @Override
  public void autonomousInit() {
    if (!Robot.isReal()) {
      SimulationManager.autoInit();
    }

    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void autonomousExit() {
  }

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    i += 0.015;

    if (i > 0.75) {
      i = 0.75;
    }

    MALog.log("/Simulation/Robot/Elevator 1", new Pose3d(0, 0, i, new Rotation3d()));
    MALog.log("/Simulation/Robot/Gripper", new Pose3d(0, 0, i * 2, new Rotation3d()));
    MALog.log("/Simulation/Robot/Gripper Arm", new Pose3d(0.3, 0, i * 2 + 0.47, new Rotation3d(0,ConvUtil.DegreesToRadians(-i*100 * 1.5),0)));

  }

  @Override
  public void teleopExit() {
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }

  @Override
  public void testExit() {
  }

  @Override
  public void simulationInit() {
    SimulationManager.simulationInit();
  }

  @Override
  public void simulationPeriodic() {
    SimulationManager.updateSimulation();
  }
}
