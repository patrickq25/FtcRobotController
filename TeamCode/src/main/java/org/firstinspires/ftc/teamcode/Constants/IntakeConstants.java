package org.firstinspires.ftc.teamcode.Constants;

public class IntakeConstants {

    public static final double START_FRONT_INTAKE_POWER = 0.5;
    public static final double START_BACK_INTAKE_POWER = 0.5;
    public static final double STOP_FRONT_INTAKE_POWER = 0;
    public static final double STOP_BACK_INTAKE_POWER = 0;
    public static final double REVERSE_FRONT_INTAKE_POWER = -0.5;
    public static final double REVERSE_BACK_INTAKE_POWER = -0.5;

    public enum IntakeMode {
        Start,
        Stop,
        Reverse
    }

}
