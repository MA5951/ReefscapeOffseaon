// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.MAutils.RobotControl.DeafultRobotContainer;
import com.MAutils.RobotControl.StateTrigger;

import edu.wpi.first.wpilibj.PS5Controller;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Commands.IntakeCommand;
import frc.robot.Subsystem.Intake.Intake;
import frc.robot.Subsystem.Intake.IntakeConstants;

public class RobotContainer extends DeafultRobotContainer {
 
  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
// need to add distance from reef
    T(StateTrigger.T(() -> getDriverController().getMiddle() || currentRobotState.getStateName() == RobotConstants.EJECT.getStateName() && !Intake.isGamePiece() || currentRobotState.getStateName() == RobotConstants.PRESCORING.getStateName(), RobotConstants.IDLE));
    
   T(StateTrigger.T(() -> (getDriverController().getR1() || getDriverController().getL1()) && !Intake.isGamePiece(), RobotConstants.INTAKE));

   T(StateTrigger.T(() -> Intake.isCoral() && IntakeCommand.i == IntakeConstants.SORTING_NUM,RobotConstants.CORAL_HOLD).withInRobotState(RobotConstants.SORTING));

   T(StateTrigger.T(() -> getDriverController().getActionsDown() && Intake.isCoral(), RobotConstants.PRESCORING ));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
