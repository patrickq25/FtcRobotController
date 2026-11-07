package org.firstinspires.ftc.teamcode.DriverControls;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Hardware.OuttakeHardware;

public class OuttakeTestDriverControls {
    private final Gamepad gamepad;
    public OuttakeTestDriverControls(Gamepad gamepad) {this.gamepad = gamepad;}

    public boolean toggleOuttake(){return gamepad.rightBumperWasPressed();}
}
