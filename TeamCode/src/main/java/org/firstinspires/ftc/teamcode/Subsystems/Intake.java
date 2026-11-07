package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Constants.IntakeConstants;
import org.firstinspires.ftc.teamcode.Hardware.IntakeHardware;
import org.firstinspires.ftc.teamcode.Utils.RobotTelemetry;

public class Intake {

    private final DcMotor intakeFrontMotor;
    private final DcMotor intakeBackMotor;
    private final RobotTelemetry robotTelemetry;

    public IntakeConstants.IntakeMode intakeModeFront;
    public IntakeConstants.IntakeMode intakeModeBack;



    public Intake(IntakeHardware hardware, RobotTelemetry robotTelemetry){
        intakeFrontMotor = hardware.intakeFrontMotor;
        intakeBackMotor = hardware.intakeBackMotor;
        this.robotTelemetry = robotTelemetry;

        intakeModeFront = IntakeConstants.IntakeMode.Stop;
        intakeModeBack = IntakeConstants.IntakeMode.Stop;
    }


    public void startIntakeFront(){
        intakeFrontMotor.setPower(IntakeConstants.START_FRONT_INTAKE_POWER);
        intakeModeFront = IntakeConstants.IntakeMode.Start;
    }
    public void startIntakeBack(){
        intakeBackMotor.setPower(IntakeConstants.START_BACK_INTAKE_POWER);
        intakeModeBack = IntakeConstants.IntakeMode.Start;
    }
    public void startIntake(){
        startIntakeFront();
        startIntakeBack();
    }

    public void stopIntakeFront(){
        intakeFrontMotor.setPower(IntakeConstants.STOP_FRONT_INTAKE_POWER);
        intakeModeFront = IntakeConstants.IntakeMode.Stop;
    }
    public void stopIntakeBack(){
        intakeBackMotor.setPower(IntakeConstants.STOP_BACK_INTAKE_POWER);
        intakeModeBack = IntakeConstants.IntakeMode.Stop;
    }


    public void stopIntake(){
        stopIntakeFront();
        stopIntakeBack();


    }

    public void reverseIntakeFront(){
        intakeFrontMotor.setPower(IntakeConstants.REVERSE_FRONT_INTAKE_POWER);
        intakeModeFront = IntakeConstants.IntakeMode.Reverse;
    }

    public void reverseIntakeBack(){
        intakeBackMotor.setPower(IntakeConstants.REVERSE_BACK_INTAKE_POWER);
        intakeModeBack = IntakeConstants.IntakeMode.Reverse;
    }
    public void reverseIntake(){

        reverseIntakeFront();
        reverseIntakeBack();

    }



    public void addTelemetry(){

        String modeStrFront;
        if (intakeModeFront == IntakeConstants.IntakeMode.Start) modeStrFront = "Start";
        else if (intakeModeFront == IntakeConstants.IntakeMode.Stop) modeStrFront = "Stop";
        else modeStrFront = "Reverse";

        String modeStrBack;
        if (intakeModeBack == IntakeConstants.IntakeMode.Start) modeStrBack = "Start";
        else if (intakeModeBack == IntakeConstants.IntakeMode.Stop) modeStrBack = "Stop";
        else modeStrBack = "Reverse";



        robotTelemetry.add(
                "Intake Mode Front",
                modeStrFront
        );
        robotTelemetry.add(
                "Intake Mode Back",
                modeStrBack
        );
    }





}
