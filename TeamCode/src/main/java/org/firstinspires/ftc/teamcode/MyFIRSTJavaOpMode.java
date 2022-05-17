/*

SECAO DE IMPORTACAO

O primeiro passo no desenvolvimento da nossa programacao e importar todas as bibliotecas de codigo que utilizaremos
como apoio para o nosso codigo. Fazemos isso atraves do comando package que ira selecionar e organizar as
classes que utilizaremos, a partir de um arquivo selecionado pelos nossos usuarios e importados pelo comando
import, que funciona como um auxilio para "chamar" os nossos codigos.  

 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp // Indica o inicio do codigo teleoperado
public class MyFIRSTJavaOpMode extends LinearOpMode {
    private Blinker control_Hub;
    private Blinker expansion_Hub_2;
    private Gyroscope imu;
    private DcMotor Motor_FD;
    private DcMotor Motor_TD;
    private DcMotor Motor_FE;
    private DcMotor Motor_TE;
    private DcMotor Garra_A;
    private DcMotor Garra_B;

    @Override
    public void runOpMode() {

        /*
        SECAO DE DECLARACAO DE NOMES DOS HARDWARES
        
        Nesta secao nomeamos cada componente utilizado ao longo da nossa programacao, 
        utilizando a funcao hardwareMap, que captura os dados vindos dos hardwares do
        nosso robo. 
        */

        control_Hub = hardwareMap.get(Blinker.class, "Control Hub");
        expansion_Hub_2 = hardwareMap.get(Blinker.class, "Expansion Hub 2");
        imu = hardwareMap.get(Gyroscope.class, "Imu");
        Motor_FD = hardwareMap.get(DcMotor.class, "Motor_FD");
        Motor_TD = hardwareMap.get(DcMotor.class, "Motor_TD");
        Motor_FE = hardwareMap.get(DcMotor.class, "Motor_FE");
        Motor_TE = hardwareMap.get(DcMotor.class, "Motor_TE");
        Garra_A = hardwareMap.get(DcMotorEx.class, "Garra_A");
        Garra_B = hardwareMap.get(DcMotor.class, "Garra_B");

        telemetry.addData("Status", "Initialized"); //avisa ao usuário que ele pode pressionar o start
        telemetry.update();
        waitForStart();// Esperar o inicio do jogo (usuario pressionar START)

        Garra_A.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Garra_A.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        Garra_A.setTargetPosition(250);
        Garra_A.setPower(1);

        while(Garra_A.isBusy()) {
            telemetry.addData("Status", "waiting fo motor to reach its target");
            telemetry.addData("a", gamepad1.a);
            telemetry.update();
        }

        Garra_A.setPower(0);
    }
}