package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Hardware.HW_Basic;

@TeleOp(name="First Program", group="TeleOp")
@Disabled
public class TOp_Learner extends LinearOpMode {

    /* Declare OpMode members. */
    HW_Basic robot           = new HW_Basic();   // Use our Basic hardware - 2 motors, m_1 & m_2

    @Override
    //runOpMode is a general statement starting the execution of the above stated 'LinearOpMode'
    public void runOpMode() {
        double left;
        double right;
        double max;

        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "This is your first program!");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
        //Shift allows you to change driving modes in the same code

                //Just in case to prevent getting stuck
                left = (gamepad1.left_stick_y - gamepad1.right_stick_x);
                right = (gamepad1.left_stick_y + gamepad1.right_stick_x);

            // Normalize the values so neither exceed +/- 1.0
            max = Math.max(Math.abs(left), Math.abs(right));
            if (max > 1.0)
            {
                left /= max;
                right /= max;
            }

            robot.leftMotor.setPower(left);
            robot.rightMotor.setPower(right);


            telemetry.addData("left",  "%.2f", left);
            telemetry.addData("right", "%.2f", right);

            telemetry.update();

            // Pause for metronome tick.  40 mS each cycle = update 25 times a second.
            robot.waitForTick(40);
        }
    }
}
