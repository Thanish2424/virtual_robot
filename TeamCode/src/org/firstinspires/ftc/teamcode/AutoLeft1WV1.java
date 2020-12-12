package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Left1WobbleTarget", group="Motion")
public class AutoLeft1WV1 extends LinearOpMode {
    // This program starts on the right line, drops off a wobble goal in it's target,
    // Goes to shoot at the center shooting spot, grabs second wobble goal and drops in it's target,
    // than drives to center shooting spot to park at the end.
    char ringAt = 'A';
    ProgrammingFrame robot   = new ProgrammingFrame();
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        robot.init(hardwareMap, this);
        waitForStart();
        // Have method(s) that shoot 3 rings here, find out if the team want the 3 rings shot in
        // the Tower Goal, Power Shot Targets, or some mixture of both
        // Driving to the starter stack
        robot.GoDistanceCM(59, .8, this);
        System.out.println("forward 59");
        robot.StrafeCM(35, .8, this);
        System.out.println("strafe 35");
        // Detect the rings here and return A, B, C, or E for Error
        //ringAt = robot.ringFinder();
        if (ringAt == 'E') {  // Top saw a ring but bottom didn't somehow, taking C path is safest
            ringAt = 'C';
        }

        // Gets us to the target zone
        robot.StrafeCM(59, 0.8, this);
        System.out.println("strafe 59");

        if (ringAt == 'A') {
            robot.GoDistanceCM(59, .8, this);
            System.out.println("forward 59");
        }
        else if (ringAt == 'B') {
            robot.GoDistanceCM(118, .8, this);
            System.out.println("forward 118");
            robot.StrafeCM(-59, .8, this);
            System.out.println("B");
        }
        else {
            robot.GoDistanceCM(177, .8, this);
        }
        // Add function that drops a wobble goal
        // Move to the launch line

        if (ringAt == 'A') {
            robot.StrafeCM(-59, .8, this);
            System.out.println("back 59");
            robot.GoDistanceCM(27, .8, this);
            System.out.println("forward 27");
        }
        else if (ringAt == 'B') {
            robot.GoDistanceCM(-27, .8, this);
        }
        else {
            robot.GoDistanceCM(-86, .8, this);
            robot.StrafeCM(-59, .8, this);
        }

        // Comment out the below if we don't have time!!!
        // Use our sensor to make sure we are on the line
        // Backup to make sure we are behind the line
        robot.GoDistanceCM(-15, .8, this);
        System.out.println("backward 15");
        // Line up to the line
       // robot.findLine(.5);
        // Go forward a tiny bit that way we are more centered on the line
        robot.GoDistanceCM(5, .8, this);
        System.out.println("forward 5");
    }
}
