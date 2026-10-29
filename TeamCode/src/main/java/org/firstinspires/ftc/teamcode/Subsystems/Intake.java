package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Constants.IntakeConstants;
import org.firstinspires.ftc.teamcode.Hardware.IntakeHardware;
import org.firstinspires.ftc.teamcode.Utils.RobotTelemetry;

public class Intake {

    private final DcMotor intakeMotor;
    private final RobotTelemetry robotTelemetry;

    public Intake(IntakeHardware hardware, RobotTelemetry robotTelemetry){
        intakeMotor = hardware.intakeMotor;
        this.robotTelemetry = robotTelemetry;
    }

    public void startIntake(){
        intakeMotor.setPower(IntakeConstants.START_INTAKE_POWER);
    }
    public void stopIntake(){
        intakeMotor.setPower(IntakeConstants.STOP_INTAKE_POWER);
    }
    public void reverseIntake(){
        intakeMotor.setPower(IntakeConstants.REVERSE_INTAKE_POWER);
    }





}
