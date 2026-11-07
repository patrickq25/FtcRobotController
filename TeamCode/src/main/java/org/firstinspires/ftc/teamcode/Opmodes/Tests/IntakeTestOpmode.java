package org.firstinspires.ftc.teamcode.Opmodes.Tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Constants.IntakeConstants;
import org.firstinspires.ftc.teamcode.DriverControls.IntakeTestDriverControls;
import org.firstinspires.ftc.teamcode.DriverControls.MecanumTestDriverControls;
import org.firstinspires.ftc.teamcode.Hardware.DrivetrainHardware;
import org.firstinspires.ftc.teamcode.Hardware.IntakeHardware;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;
import org.firstinspires.ftc.teamcode.Subsystems.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.Utils.RobotTelemetry;

@TeleOp(name="Intake Test", group="LinearOpMode")
public class IntakeTestOpmode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException{


        // Initialize

        RobotTelemetry robotTelemetry = new RobotTelemetry(telemetry);

        IntakeHardware intakeHardware = new IntakeHardware(hardwareMap);

        Intake intake = new Intake(intakeHardware, robotTelemetry);

        IntakeTestDriverControls intakeTestDriverControls = new IntakeTestDriverControls(gamepad1);

        robotTelemetry.add(
                "Status",
                "Initialized"
        );
        robotTelemetry.update();

        waitForStart();

        while (opModeIsActive()) {


            if (intakeTestDriverControls.intakeStart()){
                if (intake.intakeModeFront == IntakeConstants.IntakeMode.Start) intake.stopIntakeFront();
                else intake.startIntakeFront();
            }
            else if (intakeTestDriverControls.intakeReverse()){
                if (intake.intakeModeFront == IntakeConstants.IntakeMode.Reverse) intake.stopIntakeFront();
                else intake.reverseIntakeFront();
            }


            intake.addTelemetry();


            robotTelemetry.update();

        }
    }
}
