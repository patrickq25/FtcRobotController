package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class OuttakeHardware {

    public final DcMotor outtakeMotor;
    public OuttakeHardware(HardwareMap hardwareMap){

        outtakeMotor = hardwareMap.get(DcMotor.class, "intakeFrontMotor");

    }
}
