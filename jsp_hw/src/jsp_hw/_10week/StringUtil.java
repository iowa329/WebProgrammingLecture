package jsp_hw._10week;

public class StringUtil {

    public static boolean isEmptyOrBlank(String s) {
        return s == null ||
               s.isEmpty() ||
               s.trim().length() == 0;
    }

}