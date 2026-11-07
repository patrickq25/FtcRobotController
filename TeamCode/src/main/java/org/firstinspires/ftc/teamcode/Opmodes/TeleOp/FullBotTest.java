package org.firstinspires.ftc.teamcode.Opmodes.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Constants.IntakeConstants;
import org.firstinspires.ftc.teamcode.DriverControls.FullBotDriverControls;
import org.firstinspires.ftc.teamcode.DriverControls.MecanumTestDriverControls;
import org.firstinspires.ftc.teamcode.Hardware.DrivetrainHardware;
import org.firstinspires.ftc.teamcode.Hardware.IntakeHardware;
import org.firstinspires.ftc.teamcode.Hardware.OuttakeHardware;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;
import org.firstinspires.ftc.teamcode.Subsystems.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.Subsystems.Outtake;
import org.firstinspires.ftc.teamcode.Utils.RobotTelemetry;

@TeleOp(name="Full Robot Test", group="LinearOpMode")
public class FullBotTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException{


        // Initialize

        RobotTelemetry robotTelemetry = new RobotTelemetry(telemetry);

        DrivetrainHardware drivetrainHardware = new DrivetrainHardware(hardwareMap);
        IntakeHardware intakeHardware = new IntakeHardware(hardwareMap);
        OuttakeHardware outtakeHardware = new OuttakeHardware(hardwareMap);

        MecanumDrivetrain drivetrain = new MecanumDrivetrain(drivetrainHardware, robotTelemetry);
        Intake intake = new Intake(intakeHardware, robotTelemetry);
        Outtake outtake = new Outtake(outtakeHardware, robotTelemetry);

        FullBotDriverControls driverControls = new FullBotDriverControls(gamepad1);

        robotTelemetry.add(
                "Status",
                "Initialized"
        );
        robotTelemetry.update();


        //Start
        waitForStart();

        intake.startIntake();
        while (opModeIsActive()) {




            drivetrain.drive(
                    driverControls.driveX(),
                    driverControls.driveY(),
                    driverControls.turn()
            );



            if (driverControls.toggleSlowMode()){
                drivetrain.setSlowMode(!drivetrain.isSlowMode);
            }

            if (driverControls.frontIntakeStart()) {
                intake.startIntakeFront();
            } else if (driverControls.frontIntakeReverse()){
                intake.startIntakeFront();
            } else {
                intake.stopIntakeFront();
            }

            if (driverControls.backIntakeStart()){
                intake.startIntakeBack();
            } else if (driverControls.backIntakeReverse()){
                intake.reverseIntakeBack();
            } else {
                intake.stopIntakeBack();
            }


            if (driverControls.toggleOuttake()){
                outtake.setOuttakeMode(!outtake.outtakeMode);
            }



            intake.addTelemetry();
            drivetrain.addTelemetry();
            outtake.addTelemetry();

            robotTelemetry.update();

        }
    }
}
