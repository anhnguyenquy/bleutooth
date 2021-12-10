package frc.robot;

public final class Constants {

    public final static class Buttons {
        // Mấy cái này sẽ phải thay lại theo số của Game Controller
        public static int speedUpButton = 7;
        public static int driveRight = 1; // nút di chuyển các bánh bên phải về phía trước
        public static int driveLeft = 3;  // nút di chuyển các bánh bên trái về phía trước
    }
    public final static class Motors { // tên class đặt CamelCase đi
        // Mấy cái này cũng sẽ phải đặt lại theo ID mỗi cái Talon trên Driver Station
        public static int rightMaster = 1;
        public static int leftMaster = 2;
        public static int rightFollow = 3;
        public static int leftFollow = 4;

        public static int intaker1 = 7;
        public static int intaker2 = 8;
        public static int intaker3 = 9;
    }

    public final static class Joystick {
        public static int stick = 1; // stick 1 để chạy thẳng
        public static int stick2 = 2; // stick 2 để điều chỉnh tốc độ và rẽ
    }

    public final static class Speed {
        public static double speed1 = 0.4;
        public static double speed2 = 0.5;
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
    public static final class speed {
        public static final double maxSpeed = 1500;
    }
    public static final class WheelDiameter{
        public static final double diameter = 2.56;
    }
}
