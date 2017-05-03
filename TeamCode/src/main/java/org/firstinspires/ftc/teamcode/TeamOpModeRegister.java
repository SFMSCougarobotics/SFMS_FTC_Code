package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpModeManager;
import com.qualcomm.robotcore.eventloop.opmode.OpModeRegistrar;

import org.firstinspires.ftc.robotcontroller.external.samples.PushbotTeleopPOV_Linear;
import org.firstinspires.ftc.robotcontroller.external.samples.PushbotTeleopTank_Iterative;
import org.firstinspires.ftc.teamcode.teleop.TOp_Basic;
import org.firstinspires.ftc.teamcode.teleop.TeleOp4947;
import org.firstinspires.ftc.teamcode.teleop.TeleOp5498;
import org.firstinspires.ftc.teamcode.teleop.TeleOpKiwi;
import org.firstinspires.ftc.teamcode.teleop.TOp_Learner;


public class TeamOpModeRegister
{

    @OpModeRegistrar
    public static void registerMyOpModes(OpModeManager manager) {


        // TeleOp Codes to show on the Driver station as options. You must also add the 'import' line above that corresponds to the op mode being added.
        manager.register("Teleop POV",             PushbotTeleopPOV_Linear.class);
        manager.register("Teleop Tank",            PushbotTeleopTank_Iterative.class);
        manager.register("TeleOp5498", TeleOp5498.class);
        manager.register("TeleOp4947", TeleOp4947.class);
        manager.register("TeleOpKiwi", TeleOpKiwi.class);
        manager.register("TOp Basic", TOp_Basic.class);
        manager.register("TOp Learner", TOp_Learner.class);
    }
}