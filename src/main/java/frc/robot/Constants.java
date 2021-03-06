package frc.robot;

public final class Constants {

    public final static class Buttons {
        public static int speedUpButton = 7;
        public static int driveRight = 1;
        public static int driveLeft = 3;
    }
    public final static class Motors { 
        // Mấy cái này cũng sẽ phải đặt lại theo ID mỗi cái Talon trên Driver Station
        public static int rightMaster = 1;
        public static int leftMaster = 3; 
        public static int rightFollow = 2; 
        public static int leftFollow = 4;

        public static int grabber = 5;
        public static int spinner = 6;
        public static int slider = 7;
        public static int latch = 8;
    }

    public final static class DIO {
        public static int upper = 0;
        public static int lower = 1;
    }

    public final static class Relays { // 0->3
        public static int latch = 3;
    }

    public final static class Controllers {
        public static int movementController = 0; 
        public static int intakeController = 2; 
        public static double sensitivity = 1; // 0 -> 1
        public static double deadzone = 0.01; // 0 -> 1, recommended around .01 -> .05
        public static int driveSwapButton = 1; // Change between legacy and new driving system
    }

    public final static class Speed {
        public static double defaultIntakerSpeed = 0.4;
        public static double defaultMoveSpeed = 0.4;
        public static double safetyThreshold = .375; // Maximum manual speed cap
        public static double grabberSpeed = 0.15;
    }
    
    public final static class Time {
        public static int timeToMove1MeterAtDefaultSpeed = 12345; // in milliseconds 
        public static int timeToRotate90AtDefaultSpeed = 165; // in milliseconds
    }

    public static final class PID {
        public static double kP = 1.0 / 180;
        public static double kD = 0;
        public static double kI = 0;
        public static double kCollisionThreshold_DeltaG = 1.0 / 180;
        public static double kToleranceDegress = 2.0f;
        public static double kToleranceAngularVelocity = 0.08f;
        public static final double kToleranceStraight = 0.1f;
        public static final double kStraightConstant = 0.08;
    }
}
