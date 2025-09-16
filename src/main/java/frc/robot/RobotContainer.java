// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.MAutils.RobotControl.DeafultRobotContainer;
import com.MAutils.RobotControl.StateTrigger;
import com.MAutils.Swerve.SwerveSystem;
import com.MAutils.Utils.DriverStationUtil;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Commands.IntakeCommand;
import frc.robot.Commands.SwerveTeleopController;
import frc.robot.RobotControl.Field;
import frc.robot.RobotControl.SuperStructure;
import frc.robot.Subsystem.Arm.Arm;
import frc.robot.Subsystem.Climb.Climb;
import frc.robot.Subsystem.Elevator.Elevator;
import frc.robot.Subsystem.Intake.Intake;
import frc.robot.Subsystem.Intake.IntakeConstants;
import frc.robot.Subsystem.Swerve.SwerveConstants;
import frc.robot.Subsystem.Vision.Vision;

public class RobotContainer extends DeafultRobotContainer {

   public static final SwerveSystem swerve = SwerveSystem.getInstance(SwerveConstants.SWERVE_CONSTANTS);
   public static final Elevator elevator = Elevator.getInstance();
   public static final Arm arm = Arm.getInstance();
   public static final Intake intake = Intake.getInstance();
   public static final Climb climb = Climb.getInstance();
   
   public RobotContainer() {
      new Field();
      new Vision();
      Field.setAllianceReefFaces(DriverStationUtil.getAlliance());
      configureBindings();


      CommandScheduler.getInstance().setDefaultCommand(swerve, new SwerveTeleopController());
      
   }

   private void configureBindings() {
      // need to add distance from reef

      T(StateTrigger.T(() -> getDriverController().getMiddle()
            || getRobotState() == RobotConstants.EJECT && !SuperStructure.isGamePiece()
            || getRobotState() == RobotConstants.SCORING && !SuperStructure.isGamePiece()
            || getRobotState() == RobotConstants.BALL_SCORING && !SuperStructure.isAlgea(), RobotConstants.IDLE));

      T(StateTrigger.T(
            () -> (getDriverController().getR1() || getDriverController().getL1()) && !SuperStructure.isGamePiece(),
            RobotConstants.INTAKE));

      T(StateTrigger.T(() -> SuperStructure.isCoral(), RobotConstants.SORTING).withInRobotState(RobotConstants.INTAKE));

      T(StateTrigger.T(() -> SuperStructure.isCoral() && IntakeCommand.sortingCount == IntakeConstants.SORTING_NUM,
            RobotConstants.CORAL_HOLD).withInRobotState(RobotConstants.SORTING));

      T(StateTrigger.T(() -> getDriverController().getActionsDown() && SuperStructure.isCoral(),
            RobotConstants.SCORING));
      // need to add arm robot and eleavtor at point
      T(StateTrigger.T(() -> getDriverController().getActionsLeft(), RobotConstants.EJECT));

      T(StateTrigger.T(() -> getDriverController().getActionsRight() && !SuperStructure.isGamePiece(),
            RobotConstants.BALL_INTAKE));

      // need to add distance from reef
      T(StateTrigger.T(() -> SuperStructure.isAlgea(), RobotConstants.BALL_HOLDING)
            .withInRobotState(RobotConstants.BALL_INTAKE));

      T(StateTrigger.T(() -> getDriverController().getActionsDown() && SuperStructure.isAlgea(),
            RobotConstants.BALL_PRESCORING));
      // need to add arm robot and eleavtor at point, has ball?
      T(StateTrigger
            .T(() -> getDriverController().getActionsDown() && SuperStructure.isAlgea(), RobotConstants.BALL_SCORING)
            .withInRobotState(RobotConstants.BALL_PRESCORING));
      // need to add 30sec left for match
      T(StateTrigger.T(() -> getDriverController().getActionsUp() && DriverStation.getMatchTime() <= 30,
            RobotConstants.PRECLIMBING));
      // need to add open climber and servo open
      T(StateTrigger.T(() -> getDriverController().getActionsUp(), RobotConstants.CLIMBING)
            .withInRobotState(RobotConstants.PRECLIMBING));
   }

   public Command getAutonomousCommand() {
      return Commands.print("No autonomous command configured");
   }
}
