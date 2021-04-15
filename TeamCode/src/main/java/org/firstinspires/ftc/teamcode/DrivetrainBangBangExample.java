package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class DrivetrainBangBangExample extends LinearOpMode {

    DcMotorEx left;
    DcMotorEx right;

    // target in encoder ticks for each motor
    double targetLeft = 1000;
    double targetRight = 1000;

    @Override
    public void runOpMode() throws InterruptedException {


        // configure your motors and other hardware stuff here
        // make sure the strings match the names that you have set on your robot controller configuration
        left = hardwareMap.get(DcMotorEx.class,"left");
        right = hardwareMap.get(DcMotorEx.class,"right");


        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // reverse the appropriate motor
        left.setDirection(DcMotorSimple.Direction.REVERSE);

        // wait until the start button is pressed
        waitForStart();

        /**
         * warning, this code will definitely oscillate back and forth and is used purely as an example and should not be used
         */
        while (opModeIsActive()) {

            // independent bang bang controllers that work on each motor
            if (left.getCurrentPosition() < targetLeft) {
                left.setPower(1);
            } else if (left.getCurrentPosition() > targetLeft) {
                left.setPower(-1);
            } else {
                left.setPower(0);
            }


            if (right.getCurrentPosition() < targetRight) {
                right.setPower(1);
            } else if (right.getCurrentPosition() > targetRight) {
                right.setPower(-1);
            } else {
                right.setPower(0);
            }



        }

    }
}
