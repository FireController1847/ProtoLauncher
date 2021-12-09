package net.protolauncher.util;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;

/**
 * Provides various utilities regarding file validation.
 */
public class Validation {

    // An array of hex characters.
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    /**
     * Creates a SHA1 code from the given path.
     *
     * @param path The file to generate a SHA1 from.
     * @return The SHA1 as a string.
     * @throws Exception Thrown if any part of the SHA1 process goes wrong.
     */
    public static String createSha1(Path path) throws Exception  {
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        InputStream fis = Files.newInputStream(path);
        int n = 0;
        byte[] buffer = new byte[8192];
        while (n != -1) {
            n = fis.read(buffer);
            if (n > 0) {
                digest.update(buffer, 0, n);
            }
        }
        return bytesToHex(digest.digest());
    }

    /**
     * Converts the given byte array to a hexadecimal string.
     *
     * @param bytes The bytes to convert.
     * @return A hexadecimal string representing the given bytes.
     */
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars).toLowerCase();
    }

}
