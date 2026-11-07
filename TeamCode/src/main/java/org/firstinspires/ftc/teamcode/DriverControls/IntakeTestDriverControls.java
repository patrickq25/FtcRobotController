package org.firstinspires.ftc.teamcode.DriverControls;

import com.qualcomm.robotcore.hardware.Gamepad;

public class IntakeTestDriverControls {

    private final Gamepad gamepad;

    public IntakeTestDriverControls(Gamepad gamepad) {
        this.gamepad = gamepad;
    }

    public boolean intakeStart() {
        return gamepad.leftBumperWasPressed();
    }
    public boolean intakeReverse() { return gamepad.rightBumperWasPressed();}
    public boolean intakeStartFront() {return gamepad.aWasPressed();}
    public boolean intakeStartBack() {return gamepad.bWasPressed();}
    public boolean intakeStopFront() {return gamepad.circleWasPressed();}
    public boolean intakeStopBack() {return gamepad.squareWasPressed();}
    public boolean intakeReverseFront() {return gamepad.dpadDownWasPressed();}
    public boolean intakeReverseBack() {return gamepad.dpadUpWasPressed();}

}
