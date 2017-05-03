package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Hardware.Hardware5498;

//import com.qualcomm.robotcore.eventloop.opmode.Disabled;
//import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous(name="Auto_5498_Left")
public class Auto_5498_Left extends LinearOpMode {

    /* Declare OpMode members. */
    private Hardware5498 robot   = new Hardware5498();   // Use a Pushbot's hardware

    private void rolln(double lpw, double rpw, long tm) {
        robot.leftMotor.setPower(lpw);
        robot.rightMotor.setPower(rpw);
        sleep(tm);
    }
    private void stp(){
        robot.leftMotor.setPower(0);
        robot.rightMotor.setPower(0);
        sleep(700);

    }
   // private void intk(double pw, long timn){
     //   robot.intake.setPower(pw);
     //   sleep(timn);
   // }
   // private void shoot(){
    //}

    @Override
    public void runOpMode() {

        robot.init(hardwareMap);
        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();


        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Step through each leg of the path, ensuring that the Auto mode has not been stopped along the way

        rolln(0.25, 0.25, 1100);

        stp();

        robot.flicker.setPower(-60);
        sleep(1800);
        robot.flicker.setPower(0);
        sleep(200);

        robot.intake.setPower(-50);
        sleep(3000);
        robot.intake.setPower(0);
        sleep(200);

        robot.flicker.setPower(-60);
        sleep(1800);
        robot.flicker.setPower(0);
        sleep(200);

        rolln(-0.5, 0.5, 450);
        stp();
        rolln(0.5, 0.5, 750);
        stp();
        rolln(-0.5, 0.5, 780);
        stp();
        rolln(1, 1, 1300);
    }

    }
