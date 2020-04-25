package helper;

public class Helper {
    
    /**
     * Usage : Helper.AreAllEqual(x1, x2, x3, x4, x5)
     * @param int... values
     * @return boolean
     */
    public static boolean AreAllEqual(int... values) {
        if (values.length == 0) {
            return true;
        }

        int checkValue = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] != checkValue) {
                return false;
            }
        }

        return true;
    }

}