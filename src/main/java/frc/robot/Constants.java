package frc.robot;

public final class Constants {
    public final static class Motors { // tên class đặt CamelCase đi
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

    public final static class Joysticks {
        // why are these 2 separate sticks again?
        public static int driveStick = 1; // stick 1 để chạy thẳng
        public static int turnStick = 2; // stick 2 để điều chỉnh tốc độ và rẽ

        public static final class Buttons {
            // Thay theo controller
            public static int driveStraightBind = 1;
            public static int turnBind = 2;
            public static int driveRightBind = 3; // nút di chuyển các bánh bên phải về phía trước
            public static int driveLeftBind = 4; // nút di chuyển các bánh bên trái về phía trước
            public static int speedUpBind = 5;
            // Add buttons here
        }

        public static final class Axes {
            // Thay theo controller
            public static int xAxis = 0; // should we just use .getX() and .getY() instead?
            public static int yAxis = 1;
        }
    }

    public static final class AutoParams {
        public static final class Angles {
            public static double initialAngle = 50;
        }

        public static final class Speeds {
            public static double driveSpeed = 0.8;
        }
    }

    public final static class Speed {
        public static double speed1 = 0.4;
        public static double speed2 = 0.5;
        public static double driveScrew = 0.2;
        public static final double maxSpeed = 1500;
    }

    public final static class SuckerWheel {
        public static int sucker = 1;
    }

    public static final class PID {
        public static double kP = 1.0 / 180;
        public static double kD = 1.0 / 180;
        public static double kI = 1.0 / 180;
        public static double kCollisionThreshold_DeltaG = 1.0 / 180;
        public static double kToleranceDegress = 2.0f;
        public static double kToleranceAngularVelocity = 0.08f;
        public static final double kToleranceStraight = 0.1f;
        public static final double kStraightConstant = 0.08;
    }

    public static final class WheelDiameter {
        public static final double diameter = 2.56;
    }
}
