package org.firstinspires.ftc.teamcode.DriverControls;

import com.qualcomm.robotcore.hardware.Gamepad;

public class IntakeTestDriverControls {

    private final Gamepad gamepad;

    public IntakeTestDriverControls(Gamepad gamepad) {
        this.gamepad = gamepad;
    }

    public boolean intakeStart() {
        return gamepad.left_bumper;
    }
    public boolean intakeReverse() { return gamepad.right_bumper;}

}
