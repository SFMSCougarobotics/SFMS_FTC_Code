package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by sfmsc on 1/13/2017.
 */

public abstract class AutoBase4947 extends LinearOpMode{

    public DcMotor leftMotor = null;
    public DcMotor  rightMotor = null;
    public DcMotor  intake = null;
    public DcMotor  flicker = null;
    private HardwareMap hwMap =  null;

    public boolean right = true;
    public boolean left = false;


    public void init(HardwareMap ahwMap) {
        leftMotor = hwMap.dcMotor.get("m_1");
        rightMotor = hwMap.dcMotor.get("m_2");
        intake = hwMap.dcMotor.get("m_3");
        flicker = hwMap.dcMotor.get("m_4");
    }

    protected void setMotorPowers(double lpwr, double rpwr) throws InterruptedException{
        leftMotor.setPower(lpwr);
        rightMotor.setPower(rpwr);
    }
    protected void drivePowerMilliseconds(double lpwr, double rpwr, long tim) throws InterruptedException{
        long t0 = System.currentTimeMillis();
        setMotorPowers(lpwr, rpwr);
        while(opModeIsActive() && tim < (System.currentTimeMillis()) - t0){
            idle();
        }
        setMotorPowers(0, 0);
        stp();
    }
    protected void stp() throws InterruptedException{
        long t0 = System.currentTimeMillis();
        setMotorPowers(0,0);
        flicker.setPower(0);
        while(opModeIsActive() && 700 < (System.currentTimeMillis()) - t0){
            idle();
        }
    }
    protected void shootOnce()throws InterruptedException{
        long t0 = System.currentTimeMillis();
        flicker.setPower(1);
        while(opModeIsActive() && 2 < (System.currentTimeMillis()) - t0){
            idle();
        }
    }
    protected void intakeTime(long timn) throws InterruptedException{
        long t0 = System.currentTimeMillis();
        intake.setPower(-0.5);
        while(opModeIsActive() && timn < (System.currentTimeMillis()) - t0){
            idle();
        }
    }
    //-----------------------------------------------------------
    protected void driveToShoot() throws InterruptedException{
        drivePowerMilliseconds(0.5, 0.5, 900);
    }
    protected void shootBalls() throws InterruptedException{
        shootOnce();
        intakeTime(3000);
        shootOnce();
    }
    protected void pushBall() throws InterruptedException{
        drivePowerMilliseconds(0.5, 0.5, 2200);
    }
    //---------------------------------------------------------
    protected void gitToDaRampMawn() throws InterruptedException{
        drivePowerMilliseconds(0.4, 0.8, 3000);
        drivePowerMilliseconds(0.5, 0.5, 1000);
    }

}
