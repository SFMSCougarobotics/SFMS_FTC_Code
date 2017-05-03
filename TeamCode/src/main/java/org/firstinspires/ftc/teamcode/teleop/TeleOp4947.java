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
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Hardware.Hardware5498;

/**
 * This file illustrates the concept of calibrating a MR Compass
 * It uses the common Push
 *
 *
 * bot hardware class to define the drive on the robot.
 * The code is structured as a LinearOpMode
 *
 *   This code assumes there is a compass configured with the name "compass"
 *
 *   This code will put the compass into calibration mode, wait three seconds and then attempt
 *   to rotate two full turns clockwise.  This will allow the compass to do a magnetic calibration.
 *
 *   Once compete, the program will put the compass back into measurement mode and check to see if the
 *   calibration was successful.
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@Autonomous(name="TeleOp5498", group="Concept")
@Disabled
public class TeleOp4947 extends LinearOpMode {

    //import com.qualcomm.robotcore.util.ElapsedTime;
    //@TeleOp(name="TeleOp5498") public abstract class TeleOp5498 extends LinearOpMode {
        //this will allow us to time events
        // private ElapsedTime runtime = new ElapsedTime();
         public  void runOpMode()
         { double left;
             double right;
             double max;
             Hardware5498 robot = new Hardware5498();
             /* Initialize the hardware variables. * The init() method of the hardware class does all the work here */
             robot.init(hardwareMap);
             // Send telemetry message to signify robot waiting; telemetry.addData("Say", "Hello Driver");
             // telemetry.update();
             waitForStart();
             while (opModeIsActive())
             { left = -gamepad1.left_stick_y + gamepad1.right_stick_x;
                 right = -gamepad1.left_stick_y - gamepad1.right_stick_x;
                 // Normalize the values so neither exceed +/- 1.0
                 // max = Math.max(Math.abs(left), Math.abs(right));
                 // /* if (max > 1.0) { left /= max; right /= max; }*/
                 robot.leftMotor.setPower(left);
                 robot.rightMotor.setPower(right);
                 telemetry.addData("left", "%.2f", left);
                 telemetry.addData("right", "%.2f", right);
                 /* if (gamepad1.right_bumper)
                 { robot.fire1Motor.setPower(robot.ARM_UP_POWER);
                  }
                   else { robot.fire1Motor.setPower(0.0); } */
        if (gamepad2.right_bumper)
        { robot.intake.setPower(-0.9); }
        else { robot.intake.setPower(0.0);
        }
        if (gamepad2.left_bumper) {
            robot.flicker.setPower(-0.7);
        }
        else {
            robot.flicker.setPower(0.0);
        }
        telemetry.update();
        idle();
    }
}

        }



