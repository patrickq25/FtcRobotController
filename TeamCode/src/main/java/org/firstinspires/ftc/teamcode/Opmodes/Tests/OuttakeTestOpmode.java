package org.firstinspires.ftc.teamcode.Opmodes.Tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Constants.IntakeConstants;
import org.firstinspires.ftc.teamcode.DriverControls.OuttakeTestDriverControls;
import org.firstinspires.ftc.teamcode.Hardware.OuttakeHardware;
import org.firstinspires.ftc.teamcode.Subsystems.Outtake;
import org.firstinspires.ftc.teamcode.Utils.RobotTelemetry;

@TeleOp(name="Outtake Test", group="LinearOpMode")
public class OuttakeTestOpmode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException{


        // Initialize

        RobotTelemetry robotTelemetry = new RobotTelemetry(telemetry);

        OuttakeHardware outtakeHardware = new OuttakeHardware(hardwareMap);

        Outtake outtake = new Outtake(outtakeHardware, robotTelemetry);

        OuttakeTestDriverControls outtakeTestDriverControls = new OuttakeTestDriverControls(gamepad1);

        robotTelemetry.add(
                "Status",
                "Initialized"
        );
        robotTelemetry.update();

        waitForStart();

        while (opModeIsActive()) {


            if (outtakeTestDriverControls.toggleOuttake()){
                outtake.setOuttakeMode(!outtake.outtakeMode);
            }


            outtake.addTelemetry();


            robotTelemetry.update();

        }
    }
}
