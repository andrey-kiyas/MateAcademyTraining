package MateAcademy.code_test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Files {
    public static String modifyData(String data, String program, String version) {
        Pattern validPhone = Pattern.compile("(Phone: \\+1-\\d{3}-\\d{3}-\\d{4})\\n");
        Matcher phoneChecker = validPhone.matcher(data);
        Pattern validVersion = Pattern.compile("(Version: \\d+\\.\\d+)\\n");
        Matcher versionChecker = validVersion.matcher(data);
        if ((!phoneChecker.find()) || (!versionChecker.find())) {
            return "ERROR: VERSION or PHONE";
        }
        String phone = "+1-503-555-0090";
        String ver = "";
        String matched = versionChecker.group(1);
        if (matched.equals("Version: 2.0")) {
            ver = "2.0";
        } else {
            ver = version;
        }
        return String.format("Program: %s Author: g964 Phone: %s Date: 2019-01-01 Version: %s", program, phone, ver);
    }
}
