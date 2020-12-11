package util;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {

    public static String bytesSizeToString(long size){
        final long K_BYTE = 1024L;
        final long M_BYTE = 1024L * 1024L;
        final long G_BYTE = 1024L * 1024L * 1024L;
        final long T_BYTE = 1024L * 1024L*  1024L * 1024L;

        if(size < K_BYTE)
            return String.format("%d bytes", size);

        if(size < M_BYTE)
            return String.format("%.1f Kb", (double)size / K_BYTE);

        if(size < G_BYTE)
            return String.format("%.1f Mb", (double)size / M_BYTE);

        if(size < T_BYTE)
            return String.format("%.1f Gb", (double)size / G_BYTE);

        return String.format("%.1f Tb", (double)size / T_BYTE);
    }

    public static long stringToSizeInBytes(String text) {
        Scanner scan = new Scanner(text.toLowerCase());

        long result = -1;

        try {
            double temp = scan.nextDouble();

            if (scan.hasNext()) {
                String suffix = scan.next().trim();
                if (suffix.equals("bytes") | suffix.equals("b")) {
                    result = (long) temp;
                }
                else if (suffix.equals("kb")) {
                    result = (long) (temp * 1024);
                }
                else if (suffix.equals("mb")) {
                    result = (long) (temp * 1024 * 1024);
                }
                else if (suffix.equals("gb")) {
                    result = (long) (temp * 1024 * 1024 * 1024);
                }
                else if (suffix.equals("tb")) {
                    result = (long) (temp * 1024 * 1024 * 1024 * 1024);
                }
            }
        }
        catch (InputMismatchException | NumberFormatException e) { }

        return result;
    }

    public static boolean checkNamePattern(Pattern pattern, File file){
        Matcher matcher = pattern.matcher(file.getName());
        return matcher.find();
    }
}
