package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.util.ElapsedTime;


public class Hardware5498
{
    /* Public OpMode members. */
    public DcMotor  leftMotor   = null;
    public DcMotor  rightMotor  = null;
    public DcMotor  intake  = null;
    public DcMotor  flicker  = null;
    //public DcMotor  intakeMotor = null;
    //public DcMotor  flipperMotor= null;
    //public Servo    liftR1      = null;
    //public Servo    liftR2      = null;
    //public Servo    liftL1      = null;
    //public Servo    liftL2      = null;
    //public Servo    button      = null;

    //public static final double ARM_UP_POWER    =  0.45 ;
    //public static final double ARM_DOWN_POWER  = -0.45 ;
    public static final double FORKS_UP        =  0.5 ;
    //public static final double FORKS_DOWN      =  1;
    public static final double FLIPPER_IN      =  0.0;
    //public static final double FLIPPER_OUT     =  0.5;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    // private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public Hardware5498(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftMotor    = hwMap.dcMotor.get("m_1");
        rightMotor   = hwMap.dcMotor.get("m_2");
        flicker      = hwMap.dcMotor.get("m_3");
        intake       = hwMap.dcMotor.get("m_4");
        //fire1Motor   = hwMap.dcMotor.get("m_5");
        //fire2Motor   = hwMap.dcMotor.get("m_6");
        leftMotor.setDirection(DcMotor.Direction.REVERSE); // Set to REVERSE if using AndyMark motors
        rightMotor.setDirection(DcMotor.Direction.FORWARD);// Set to FORWARD if using AndyMark motors

        // Set all motors to zero power
        leftMotor.setPower(0);
        rightMotor.setPower(0);
        intake.setPower(0);
        flicker.setPower(0);
        //intakeMotor.setPower(0);

        leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        flicker.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        /*intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        // Define and initialize ALL installed servos.
        liftL1 = hwMap.servo.get("s_1");//left up-down
        liftL2 = hwMap.servo.get("s_2");//left in-out
        liftR1 = hwMap.servo.get("s_3");//right up-down
        liftR2 = hwMap.servo.get("s_4");//right in-out
        button = hwMap.servo.get("s_5");//presses the button on the beacon
        liftL1.setPosition(FORKS_UP);
        liftL2.setPosition(0);
        liftR1.setPosition(FORKS_UP);
        liftR2.setPosition(0);
        button.setPosition(FLIPPER_IN);
        */
    }

    /**
     *
     * waitForTick implements a periodic delay. However, this acts like a metronome with a regular
     * periodic tick.  This is used to compensate for varying processing times for each cycle.
     * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
     *
     * @param periodMs  Length of wait cycle in mSec.
     */

  /*  public void waitForTick(long periodMs) {

        long  remaining = periodMs - (long)period.milliseconds();
/*
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

