package frc.robot;

public final class Constants {

    public static final class Buttons {
        // Mấy cái này sẽ phải thay lại theo số của Game Controller
        public static int speedUpButton = 7;
        public static int driveRight = 1; // nút di chuyển các bánh bên phải về phía trước
        public static int driveLeft = 3;  // nút di chuyển các bánh bên trái về phía trước
    }
    public static final class Motors { // tên class đặt CamelCase đi
        // Mấy cái này cũng sẽ phải đặt lại theo ID mỗi cái Talon trên Driver Station
        public static int rightMaster = 1;
        public static int leftMaster = 2;
        public static int rightFollow1 = 3;
        public static int leftFollow1 = 4;
        public static int rightFollow2 = 5;
        public static int leftFollow2 = 6;

        public static int intaker1 = 7;
        public static int intaker2 = 8;
        public static int intaker3 = 9;
    }

    public static final class Joystick {
        public static int stickPort = 1; // stick 1 để chạy thẳng
        public static final class Buttons {
            // Deprecate driveRightBind và driveLeftBind, nên dùng rotateBind
            // Thay theo controller
            public static int driveStraightBind = 1;
            public static int rotateBind = 2;
            public static int speedUpBind = 3;
            public static int driveRightBind = 4;
            public static int driveLeftBind = 5;
        }
        
        public static final class Axes {
            public static int HIDYawAxis = 0; // Thay theo controller
        }
    }

    public static final class Speed {
        public static double speed1 = 0.4;
        public static double speed2 = 0.5;
        public static double driveScrew = 0.2;
    }

    public static final class SuckerWheel {
        public static int sucker = 1;
    }

    public static final class PID {
        public static double kP = 1.0 / 180;
        public static double kD = 1.0 / 180;
        public static double kI = 1.0 / 180;
        public static double kCollisionThreshold_DeltaG = 1.0 / 180;
        public static double kToleranceDegress = 2.0f;
        public static double kToleranceAngularVelocity = 0.08f;
    }

    public static final class Angles {
        public static final class Autonomous {
            public static double startingAngle = 50;
        }
    }
}
