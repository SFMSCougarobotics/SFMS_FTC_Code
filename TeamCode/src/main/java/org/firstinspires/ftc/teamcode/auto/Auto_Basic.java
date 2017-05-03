package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Hardware.HW_Basic;


//import com.qualcomm.robotcore.eventloop.opmode.Disabled;
//import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous(name="Auto_Basic")
public class Auto_Basic extends LinearOpMode
{

    /* Declare OpMode members. */
    private HW_Basic robot   = new HW_Basic();   // Use Basic hardware

    private void fwd(double lpw, double rpw, long tm) //sub program to drive forward
    {
        robot.leftMotor.setPower(lpw);
        robot.rightMotor.setPower(rpw);
        sleep(tm);
    }
    private void stp() //sub program to stop
    {
        robot.leftMotor.setPower(0);
        robot.rightMotor.setPower(0);
        sleep(500);
    }
    private void turn(int dir)
    {
        if (dir == 0) //Turn Right
        {
            robot.leftMotor.setPower(.5);
            robot.rightMotor.setPower(-.5);
            sleep(700);
        }
        else if (dir == 1) //Turn Left
        {
            robot.leftMotor.setPower(-.5);
            robot.rightMotor.setPower(.5);
            sleep(500);
        }
    }


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
        fwd(0.5, 0.5, 1300);
        stp();
        turn(1);
        fwd(0.5, 0.5, 1300);
        stp();
        turn(1);
        fwd(0.5, 0.5, 1300);
        stp();
        turn(1);
        fwd(0.5, 0.5, 1300);
        stp();
        turn(1);
        fwd(0.5, 0.5, 1300);

        turn(0);
        turn(0);
        turn(0);
        turn(0);
    }

}
