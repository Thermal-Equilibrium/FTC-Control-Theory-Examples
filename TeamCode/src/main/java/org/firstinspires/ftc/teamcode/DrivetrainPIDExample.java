package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class DrivetrainPIDExample extends LinearOpMode {
    DcMotorEx left;
    DcMotorEx right;

    // target in encoder ticks for each motor
    double targetLeft = 1000;
    double targetRight = 1000;


    // initialize error
    double leftError = 1000;
    double rightError = 1000;

    // proportional gain
    double Kp = 0.1;

    // pid controllers set with arbitrary values, use at your own risk
    PIDController leftController = new PIDController(0.5,0.1,0.2);
    PIDController rightController = new PIDController(0.5,0.1,0.2);

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


        /*
         * use proportional feedback to move drive train to reference
         */
        while (opModeIsActive()) {

            left.setPower(leftController.output(targetLeft,left.getCurrentPosition()));
            right.setPower(rightController.output(targetRight,right.getCurrentPosition()));

        }


    }

}
