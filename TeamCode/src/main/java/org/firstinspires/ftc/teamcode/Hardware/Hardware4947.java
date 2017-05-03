package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This is NOT an opmode.
 *
 * This class can be used to define all the specific hardware for a single robot.
 * In this case that robot is a Pushbot.
 * See PushbotTeleopTank_Iterative and others classes starting with "Pushbot" for usage examples.
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note:  All names are lower case and some have single spaces between words.
 *
 * Motor channel:  Left  drive motor:        "left_drive"
 * Motor channel:  Right drive motor:        "right_drive"
 * Motor channel:  Manipulator drive motor:  "left_arm"
 * Servo channel:  Servo to open left claw:  "left_hand"
 * Servo channel:  Servo to open right claw: "right_hand"
 */
public class Hardware4947
{
    /* Public OpMode members. */
    public DcMotor  leftMotor   = null;
    public DcMotor  rightMotor  = null;
    //public DcMotor  fire1Motor  = null;
    //public DcMotor  fire2Motor  = null;
    //public DcMotor  lift1Motor  = null;
    //public DcMotor  lift2Motor  = null;
    public DcMotor  intake      = null;
    public DcMotor  flicker   = null;
    //public Servo    liftR1      = null;
    //public Servo    liftR2      = null;
    //public Servo    liftL1      = null;
    //public Servo    liftL2      = null;
    //public Servo    button      = null;



    //public static final double L1Pos  =  1 ;
    //public static final double L2Pos  =  0 ;
    //public static final double R1Pos  =  1 ;
    //public static final double R2Pos  =  0 ;
    //public static final double ARM_POWER_UP  =  1 ;
    //public static final double FORKS_OUT       =  0.5 ;
    //public static final double FLIPPER_IN      =  0.0;
    //public static final double FLIPPER_OUT     =  0.5;

    /* local OpMode members. */
   private HardwareMap hwMap           =  null;
   // private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public Hardware4947(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftMotor    = hwMap.dcMotor.get("m_1");
        rightMotor   = hwMap.dcMotor.get("m_2");
        intake       = hwMap.dcMotor.get("m_3");
        flicker      = hwMap.dcMotor.get("m_4");
        //lift1Motor   = hwMap.dcMotor.get("m_5");
        //lift2Motor   = hwMap.dcMotor.get("m_6");

        leftMotor.setDirection(DcMotor.Direction.REVERSE); // Set to REVERSE if using AndyMark motors
        rightMotor.setDirection(DcMotor.Direction.FORWARD);// Set to FORWARD if using AndyMark motors

        // Set all motors to zero power
        leftMotor.setPower(0);
        rightMotor.setPower(0);
        intake.setPower(0);
        flicker.setPower(0);
        //lift1Motor.setPower(0);
        //lift2Motor.setPower(0);

        leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        flicker.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //fire1Motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //fire2Motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //lift1Motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //lift2Motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        // Define and initialize ALL installed servos.
        //liftL1 = hwMap.servo.get("s_1");//left up-down
        //liftL2 = hwMap.servo.get("s_2");//left in-out
        //liftR1 = hwMap.servo.get("s_3");//right up-down
        //liftR2 = hwMap.servo.get("s_4");//right in-out
        //button = hwMap.servo.get("s_5");//presses the button on the beacon
        //liftL1.setPosition(L1Pos);
        //liftL2.setPosition(L2Pos);
        //liftR1.setPosition(R1Pos);
        //liftR2.setPosition(R2Pos);
       // button.setPosition(FLIPPER_IN);
    }


   /* public void waitForTick(long periodMs) {

        long  remaining = periodMs - (long)period.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0) {
            try {
                Thread.sleep(remaining);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Reset the cycle clock for the next pass.
        period.reset();
    }*/
}

