package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Constants.IntakeConstants;

public class IntakeHardware {

    public final DcMotor intakeFrontMotor;
    public final DcMotor intakeBackMotor;



    public IntakeHardware(HardwareMap hardwareMap){

        intakeFrontMotor = hardwareMap.get(DcMotor.class, "intakeFrontMotor");
        intakeBackMotor = hardwareMap.get(DcMotor.class, "intakeBackMotor");

    }

}
