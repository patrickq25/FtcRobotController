package org.firstinspires.ftc.teamcode.DriverControls;

import com.qualcomm.robotcore.hardware.Gamepad;

public class IntakeTestDriverControls {

    private final Gamepad gamepad;
    public IntakeTestDriverControls(Gamepad gamepad) {
        this.gamepad = gamepad;
    }

    public boolean intakeToggle() {
        return gamepad.leftBumperWasPressed();
    }

}
