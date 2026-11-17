package org.firstinspires.ftc.teamcode.Opmodes.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Hardware.DrivetrainHardware;
import org.firstinspires.ftc.teamcode.Hardware.IntakeHardware;
import org.firstinspires.ftc.teamcode.Hardware.OuttakeHardware;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;
import org.firstinspires.ftc.teamcode.Subsystems.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.Subsystems.Outtake;
import org.firstinspires.ftc.teamcode.Types.MotorPowers;
import org.firstinspires.ftc.teamcode.Utils.RobotTelemetry;

@Autonomous(name = "Start position 1", group = "Autonomous")
public class StartPos1 extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        RobotTelemetry robotTelemetry = new RobotTelemetry(telemetry);

        DrivetrainHardware drivetrainHardware = new DrivetrainHardware(hardwareMap);
        IntakeHardware intakeHardware = new IntakeHardware(hardwareMap);
        OuttakeHardware outtakeHardware = new OuttakeHardware(hardwareMap);

        MecanumDrivetrain drivetrain = new MecanumDrivetrain(drivetrainHardware, robotTelemetry);
        Intake intake = new Intake(intakeHardware, robotTelemetry);
        Outtake outtake = new Outtake(outtakeHardware, robotTelemetry);

        robotTelemetry.add(
                "Status",
                "Initialized"
        );
        robotTelemetry.update();
        waitForStart();
        runtime.reset();

        if (opModeIsActive()) {
            drivetrain.setMotorPowers(new MotorPowers(0.2, 0.2, 0.2, 0.2));
            while (opModeIsActive() && runtime.seconds() < 1.5) {
                telemetry.addData("Runtime", runtime.seconds());
                telemetry.update();
            }

            // Stop motors
            drivetrain.stop();
        }
    }
}