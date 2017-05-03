package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Hardware.HardwareKiwi;

@TeleOp(name="TeleKiwi", group="TeleOp")
@Disabled
public class TeleOpKiwi extends LinearOpMode {

         public  void runOpMode()
         {   
			 //Establish and initialize variables to be used in the code
			 double left;
             double right;
             double back = 0;
             double max;
             double shift = 0;
             double adj;
			 //Define the proper hardware file to be used with thsi code
             HardwareKiwi robot = new HardwareKiwi();
             /* Initialize the hardware variables. * The init() method of the hardware class does all the work here */
             robot.init(hardwareMap);
             // Send telemetry message to signify robot waiting;
             telemetry.addData("Say", "Hello Driver");
             telemetry.update();

             waitForStart();
             while (opModeIsActive())
             {
                 if (gamepad1.left_bumper)
                 {
                     //Shift variable for changing the drive scheme. Pressing right bumper increases
                     //the Shift value by 1 until it gets to 3, and then it's reset to 0.
                     shift = shift + 1;
                     sleep(500);
                     if (shift == 3)
                     {
                         shift = 0;
                     }
                 }
                 if (gamepad1.right_bumper)
                 {
                     //adj changes motor power for all movements. Speed reduction.
                     adj = 0.15;
                 }
                 else
                 {
					 //if the bumper is not being pressed, motors operate at full power
                     adj = 1;
                 }
				// DPad control for precise forward, backward, and lateral movements
                 if (gamepad1.dpad_up)
                 {
                     left = 1*adj;
                     right = -1*adj;
                     back = 0;
                 }
                 else if (gamepad1.dpad_down)
                 {
                     left = -1*adj;
                     right = 1*adj;
                     back = 0;
                 }
                 else if (gamepad1.dpad_right)
                 {
                     left = 1*adj;
                     right = 1*adj;
                     back = -1*adj;
                 }
                 else if (gamepad1.dpad_left)
                 {
                     left = -1*adj;
                     right = -1*adj;
                     back = 1*adj;
                 }
				 //Shift 'cases' allow driver to change between different drive modes on the fly. 
                 else if (shift == 0)
                 {
                     telemetry.addLine()
                        .addData("shift", "%.2f", shift)
                        .addData("say", "Kiwi Drive");
					 //Kiwi standard drive
                     left = ((gamepad1.left_stick_x - gamepad1.left_stick_y) + (gamepad1.right_stick_x)) * adj;
                     right = ((gamepad1.left_stick_x + gamepad1.left_stick_y) + (gamepad1.right_stick_x)) * adj;
                     back = ((-gamepad1.left_stick_x) + (gamepad1.right_stick_x)) * adj;
                 }
                 else if (shift == 1)
                 {
                     telemetry.addLine()
                             .addData("shift", "%.2f", shift)
                             .addData("say", "POV Drive");
					 // POV drive 2 wheel
                     left = (-gamepad1.left_stick_y + gamepad1.right_stick_x) * adj;
                     right = (gamepad1.left_stick_y + gamepad1.right_stick_x) * adj;
                 }
                 else if (shift == 2)
                 {
                     telemetry.addLine()
                             .addData("shift", "%.2f", shift)
                             .addData("say", "Tank Drive");
					 //Tank Drive
                     left = -gamepad1.left_stick_y * adj;
                     right = gamepad1.right_stick_y * adj;
                 }
                 else
                 {
					 //Else case is to prevent any hangups and default to the standard kiwi drive. This is more for testing, may be unnecessary once the code is proven
                     left = ((gamepad1.left_stick_x - gamepad1.left_stick_y) + (gamepad1.right_stick_x)) * adj;
                     right = ((gamepad1.left_stick_x + gamepad1.left_stick_y) + (gamepad1.right_stick_x)) * adj;
                     back = ((-gamepad1.left_stick_x) + (gamepad1.right_stick_x)) * adj;
                 }
                 //Prevents left or right variables from exceeding max input value of 1.
				 max = Math.max(Math.abs(left), Math.abs(right));
                 if (max > 1.0)
                 {
                     left /= max;
                     right /= max;
                 }
				//Sets the motors to the power setting of the corresponding variable
                 robot.leftMotor.setPower(left);
                 robot.rightMotor.setPower(right);
                 robot.backMotor.setPower(back);
				//Telemetry provides feedback to the driver at the driver station
                 telemetry.addData("left", "%.2f", left);
                 telemetry.addData("right", "%.2f", right);
                 telemetry.addData("back", "%.2f", back);
                 telemetry.addData("adj", "%.2f", adj);

                 telemetry.update();
            }
        }
}





