// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import com.MAutils.RobotControl.DeafultRobotContainer;
import com.MAutils.Utils.DeafultRobotConstants;
import java.lang.Thread.State;

import com.MAutils.RobotControl.DeafultRobotContainer;
import com.MAutils.RobotControl.StateTrigger;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PS5Controller;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Commands.IntakeCommand;
import frc.robot.Subsystem.Arm.Arm;
import frc.robot.Subsystem.Elevator.Elevator;
import frc.robot.Subsystem.Intake.Intake;
import frc.robot.Subsystem.Intake.IntakeConstants;

public class RobotContainer extends DeafultRobotContainer {

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
// need to add distance from reef


   T(StateTrigger.T(() -> getDriverController().getMiddle() || getRobotState().getStateName() == RobotConstants.EJECT.getStateName() && !Intake.isGamePiece() || currentRobotState.getStateName() == RobotConstants.SCORING.getStateName(), RobotConstants.IDLE));
    
   T(StateTrigger.T(() -> (getDriverController().getR1() || getDriverController().getL1()) && !Intake.isGamePiece(), RobotConstants.INTAKE));

   T(StateTrigger.T(() -> Intake.isCoral(), RobotConstants.SORTING).withInRobotState(RobotConstants.INTAKE));

   T(StateTrigger.T(() -> Intake.isCoral() && IntakeCommand.i == IntakeConstants.SORTING_NUM, RobotConstants.CORAL_HOLD).withInRobotState(RobotConstants.SORTING));

   T(StateTrigger.T(() -> getDriverController().getActionsDown() && Intake.isCoral(), RobotConstants.SCORING ));
// need to add arm robot and eleavtor at point
   T(StateTrigger.T(() -> getDriverController().getActionsLeft(), RobotConstants.EJECT));

   T(StateTrigger.T(() -> getDriverController().getActionsRight() && !Intake.isGamePiece(), RobotConstants.BALL_INTAKE));

   T(StateTrigger.T(() -> Intake.getBallSensor(), RobotConstants.BALL_SORTING).withInRobotState(RobotConstants.BALL_INTAKE));
// need to add distance from reef
   T(StateTrigger.T(() -> Intake.getBallSensor(), RobotConstants.BALL_HOLDING). withInRobotState(RobotConstants.BALL_SORTING));

   T(StateTrigger.T(() -> getDriverController().getActionsDown() && Intake.getBallSensor(), RobotConstants.BALL_PRESCORING));
// need to add arm robot and eleavtor at point, has ball? 
   T(StateTrigger.T(() -> intake.isGamePiece, RobotConstants.BALL_SCORING).withInRobotState(RobotConstants.BALL_PRESCORING));
// need to add 30sec left for match
   T(StateTrigger.T(() -> getDriverController().getActionsUp() && DriverStation.getMatchTime() <= 30, RobotConstants.PRECLIMBING));
// need to add open climber and servo open
   T(StateTrigger.T(() -> getDriverController().getActionsUp(), RobotConstants.CLIMBING).withInRobotState(RobotConstants.PRECLIMBING));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
