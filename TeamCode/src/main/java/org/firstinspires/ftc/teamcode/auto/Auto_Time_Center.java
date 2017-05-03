package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import android.media.MediaPlayer;
import org.firstinspires.ftc.teamcode.Hardware.Hardware5498;

//import com.qualcomm.robotcore.eventloop.opmode.Disabled;
//import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous(name="Auto_Time_Center")
public class Auto_Time_Center extends LinearOpMode {

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

        sleep(10000);
        // Step through each leg of the path, ensuring that the Auto mode has not been stopped along the way
        /*they see me*/
        rolln(0.5, 0.5, 1300);
        /*they hat'n*/
        stp();

        robot.flicker.setPower(-60);
        sleep(2000);
        robot.flicker.setPower(0);
        sleep(200);

        robot.intake.setPower(-50);
        sleep(3000);
        robot.intake.setPower(0);
        sleep(200);

        robot.flicker.setPower(-60);
        sleep(2000);
        robot.flicker.setPower(0);
        sleep(200);

        rolln(0.5, 0.5, 2100);

    }

    }
