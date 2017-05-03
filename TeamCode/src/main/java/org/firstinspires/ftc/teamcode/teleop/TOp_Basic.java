/*
Copyright (c) 2016 Robert Atkinson

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Robert Atkinson nor the names of his contributors may be used to
endorse or promote products derived from this software without specific prior
written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESSFOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Hardware.HW_Basic;

/**
 * This OpMode uses the common Pushbot hardware class to define the devices on the robot.
 * All device access is managed through the HardwarePushbot class.
 * The code is structured as a LinearOpMode
 *
 * This particular OpMode executes a POV Game style Teleop for a PushBot
 * In this mode the left stick moves the robot FWD and back, the Right stick turns left and right.
 * It raises and lowers the claw using the Gampad Y and A buttons respectively.
 * It also opens and closes the claws slowly using the left and right Bumper buttons.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="Basic Drive", group="TeleOp")
@Disabled
public class TOp_Basic extends LinearOpMode {

    /* Declare OpMode members. */
    HW_Basic robot           = new HW_Basic();   // Use our Basic hardware

    @Override
    public void runOpMode() {
        double left;
        double right;
        double shift = 0;
        double spd;
        double max;

        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Driver");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
        //Shift allows you to change driving modes in the same code
            if (gamepad1.left_bumper)
            {
                shift = shift + 1;
                if (shift == 3)
                {
                    shift = 0;
                }
            }
            //Speed shifter allows a 'slow mode' for fine tuned movements
            if (gamepad1.right_bumper)
            {
                spd = 0.15;
            }
            else
            {
                spd = 1;
            }
            if (shift == 0) {
                // Run wheels in POV mode (note: The joystick goes negative when pushed forwards, so negate it)
                // In this mode the Left stick moves the robot fwd and back, the Right stick turns left and right.
                left = (gamepad1.left_stick_y - gamepad1.right_stick_x) * spd;
                right = (gamepad1.left_stick_y + gamepad1.right_stick_x) * spd;
            }
            else if (shift == 1)
            {
                // Tank mode
                left = (gamepad1.left_stick_y) * spd;
                right = (gamepad1.right_stick_y) * spd;
            }
            else if (shift == 2)
            {
                // Tank mode
                left = (gamepad1.left_stick_y) * spd;
                right = (gamepad2.right_stick_y) * spd;
            }
            else
            {
                //Just in case to prevent getting stuck
                left = (gamepad1.left_stick_y - gamepad1.right_stick_x) * spd;
                right = (gamepad1.left_stick_y + gamepad1.right_stick_x) * spd;
            }
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
            telemetry.addData("shift", "%.2f", shift);
            telemetry.addData("speed", "%.2f", spd);
            telemetry.update();

            // Pause for metronome tick.  40 mS each cycle = update 25 times a second.
            robot.waitForTick(40);
        }
    }
}
