package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;


import org.firstinspires.ftc.teamcode.Hardware.OuttakeHardware;
import org.firstinspires.ftc.teamcode.Utils.RobotTelemetry;

public class Outtake {
    public final DcMotor outtakeMotor;

    private final RobotTelemetry robotTelemetry;




    public boolean outtakeMode; //false = stop, true = start

    public Outtake(OuttakeHardware hardware, RobotTelemetry robotTelemetry){
        outtakeMotor = hardware.outtakeMotor;
        this.robotTelemetry = robotTelemetry;


        outtakeMode = false;
    }

    public void setOuttakeMode(boolean start){
        if (start) startOuttake();
        else stopOuttake();
    }

    public void startOuttake(){
        outtakeMotor.setPower(1);
        outtakeMode = true;
    }
    public void stopOuttake(){
        outtakeMotor.setPower(0);
        outtakeMode = false;
    }

    public void addTelemetry(){
        robotTelemetry.add(
                "Outtake Mode",
                outtakeMode
        );
    }


}
