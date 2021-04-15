package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@Autonomous
public class OpenLoopDrivetrainExample extends LinearOpMode {

    // we only have two motors for the sake of keeping the example simple but you are free to add as many as you need!
    DcMotorEx left;
    DcMotorEx right;

    @Override
    public void runOpMode() throws InterruptedException {
        // configure your motors and other hardware stuff here
        // make sure the strings match the names that you have set on your robot controller configuration
        left = hardwareMap.get(DcMotorEx.class,"left");
        right = hardwareMap.get(DcMotorEx.class,"right");

        // reverse the appropriate motor
        left.setDirection(DcMotorSimple.Direction.REVERSE);

        // wait until the start button is pressed
        waitForStart();

        // start motors at 100% power
        left.setPower(1);
        right.setPower(1);

        // leave motors running for one second
        sleep(1000);

        // stop motors after one second
        left.setPower(0);
        right.setPower(0);

    }

}
