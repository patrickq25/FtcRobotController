package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Constants.IntakeConstants;
import org.firstinspires.ftc.teamcode.Hardware.IntakeHardware;
import org.firstinspires.ftc.teamcode.Utils.RobotTelemetry;

public class Intake {

    private final DcMotor intakeFrontMotor;
    private final DcMotor intakeBackMotor;
    private final RobotTelemetry robotTelemetry;

    public IntakeConstants.IntakeMode intakeMode = IntakeConstants.IntakeMode.Start;

    public Intake(IntakeHardware hardware, RobotTelemetry robotTelemetry){
        intakeFrontMotor = hardware.intakeFrontMotor;
        intakeBackMotor = hardware.intakeBackMotor;
        this.robotTelemetry = robotTelemetry;

        intakeMode = IntakeConstants.IntakeMode.Stop;
    }

    public void startIntake(){
        intakeFrontMotor.setPower(IntakeConstants.START_FRONT_INTAKE_POWER);
        intakeBackMotor.setPower(IntakeConstants.START_BACK_INTAKE_POWER);
        intakeMode = IntakeConstants.IntakeMode.Start;
    }
    public void stopIntake(){
        intakeFrontMotor.setPower(IntakeConstants.STOP_FRONT_INTAKE_POWER);
        intakeBackMotor.setPower(IntakeConstants.STOP_BACK_INTAKE_POWER);
        intakeMode = IntakeConstants.IntakeMode.Stop;
    }
    public void reverseIntake(){
        intakeFrontMotor.setPower(IntakeConstants.REVERSE_FRONT_INTAKE_POWER);
        intakeBackMotor.setPower(IntakeConstants.REVERSE_BACK_INTAKE_POWER);
        intakeMode = IntakeConstants.IntakeMode.Reverse;
    }

    public void addTelemetry(){

        String modeStr;
        if (intakeMode == IntakeConstants.IntakeMode.Start) modeStr = "Start";
        else if (intakeMode == IntakeConstants.IntakeMode.Stop) modeStr = "Stop";
        else modeStr = "Reverse";
        robotTelemetry.add(
                "Intake Mode: ",
                modeStr
        );
    }





}
