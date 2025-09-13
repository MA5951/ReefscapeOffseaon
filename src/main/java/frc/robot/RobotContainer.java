// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import com.MAutils.RobotControl.DeafultRobotContainer;
import com.MAutils.RobotControl.StateTrigger;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Commands.IntakeCommand;
import frc.robot.RobotControl.SuperStructure;
import frc.robot.Subsystem.Intake.Intake;
import frc.robot.Subsystem.Intake.IntakeConstants;

public class RobotContainer extends DeafultRobotContainer {

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
   T(StateTrigger.T(() -> getDriverController().getMiddle() || getRobotState() == RobotConstants.EJECT && !SuperStructure.isGamePiece()  , RobotConstants.IDLE)); //Add current robot state scoring and dosent haev game piece (both for coral and ball), distance from reef were needed
    

   //Coral
   T(StateTrigger.T(() -> (getDriverController().getR1() || getDriverController().getL1()) && !SuperStructure.isGamePiece(), RobotConstants.INTAKE));//V

   T(StateTrigger.T(() -> SuperStructure.isCoral(), RobotConstants.SORTING).withInRobotState(RobotConstants.INTAKE));//V

   T(StateTrigger.T(() -> SuperStructure.isCoral() && IntakeCommand.i == IntakeConstants.SORTING_NUM, RobotConstants.CORAL_HOLD).withInRobotState(RobotConstants.SORTING));//V

   T(StateTrigger.T(() -> getDriverController().getActionsDown() && SuperStructure.isCoral(), RobotConstants.SCORING ));//Add not in sorting, chnage to L1 R1

   T(StateTrigger.T(() -> getDriverController().getActionsLeft(), RobotConstants.EJECT));//V


   //Alge
   T(StateTrigger.T(() -> getDriverController().getActionsRight() && !SuperStructure.isGamePiece(), RobotConstants.BALL_INTAKE));//V

   T(StateTrigger.T(() -> Intake.getInstance().getBallSensor(), RobotConstants.BALL_SORTING).withInRobotState(RobotConstants.BALL_INTAKE));//Chnage to superstructure

   T(StateTrigger.T(() -> SuperStructure.isAlgea(), RobotConstants.BALL_HOLDING).withInRobotState(RobotConstants.BALL_SORTING));//Add disatnce from reef and finished sorting

   T(StateTrigger.T(() -> getDriverController().getActionsDown() && SuperStructure.isAlgea(), RobotConstants.BALL_SCORING));//Add in ball holding


   //Climb
   T(StateTrigger.T(() -> getDriverController().getActionsUp() && DriverStation.getMatchTime() <= 30, RobotConstants.PRECLIMBING));

   T(StateTrigger.T(() -> getDriverController().getActionsUp(), RobotConstants.CLIMBING).withInRobotState(RobotConstants.PRECLIMBING));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
