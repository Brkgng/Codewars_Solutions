public class Int32ToIPv4 {
    public static String longToIP(long ip) {
        if (ip == 0)
            return "0.0.0.0";

        int bitCount = 0;
        int octetCount = 1;
        int dec2BinFor8Bit = 0;
        String ipv4 = "";

        while (ip > 0) {
            // Convert dec to bin
            // Ex: 1101 -> (2^0)x1 + (2^1)x0 + (2^2)x1 + (2^1)x1
            if (ip % 2 != 0)
                dec2BinFor8Bit += Math.pow(2, bitCount);
            ip /= 2;
            bitCount++;
            // 8 bits represents one octet
            if (bitCount == 8 || ip == 0) {
                // dont append "." after last octet
                if (ipv4.isEmpty())
                    ipv4 = String.valueOf(dec2BinFor8Bit);
                else {
                    ipv4 = String.valueOf(dec2BinFor8Bit) + "." + ipv4;
                    octetCount += 1;
                }
                bitCount = 0;
                dec2BinFor8Bit = 0;
            }
        }

        // ipv4 must have 4 octet
        if (octetCount == 3)
            return "0." + ipv4;
        return ipv4;
    }
}
