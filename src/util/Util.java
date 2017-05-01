/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


/**
 *
 * @author owo
 */
public class Util {

    public static final int LEN_LOGIN_REQUEST = 23;
    public static final int LEN_LOGIN_RESPOND_HEADER = 5;
    public static final int LEN_LOGIN_RESPOND_RECORD = 26;

    public static final int C_LOGIN = 0x01;
    public static final int C_CLI_LIST = 0x02;
    public static final int C_CLI_LIST_UPDATE = 0x05;
    public static final int C_QUIT = 0x03;
    public static final int C_QUIT_ACK = 0x04;
    public static final int C_UNRECOGNIZED = 0x10;


    public static byte[] concat(byte[] a, byte[] b) {
        byte[] ret = new byte[a.length + b.length];
        System.arraycopy(a, 0, ret, 0, a.length);
        System.arraycopy(b, 0, ret, a.length, b.length);
        return ret;
    }

    public static short string2short(String s) {
        return (short)Integer.parseInt(s);
    }

    public static byte[] short2byte(short x) {
        byte[] ret = new byte[2];
        ret[0] = (byte)(x & 0xff);
        ret[1] = (byte)((x>>8) & 0xff);
        return ret;
    }
    
    public static short byte2short(byte[] buf) {
        assert(buf.length == 2);
        int low = ((int)buf[0]) & 0xff;
        int high = ((int)buf[1]) & 0xff;
        int ret =(high<<8) | (low);
        return (short)ret;
    }
    
    public static int byte2int(byte[] buf) {
        assert(buf.length == 4);
        int v4 = ((int)buf[0]) & 0xff;
        int v3 = ((int)buf[1]) & 0xff;
        int v2 = ((int)buf[2]) & 0xff;
        int v1 = ((int)buf[3]) & 0xff;
        int ret = (v1<<24) | (v2<<16) | (v3<<8) | (v4);
        return ret;
    }
    
    public static String byte2ip(byte[] buf) {
        assert(buf.length == 4);
        StringBuilder sb = new StringBuilder();
        int v1 = ((int)buf[0]) & 0xff;
        int v2 = ((int)buf[1]) & 0xff;
        int v3 = ((int)buf[2]) & 0xff;
        int v4 = ((int)buf[3]) & 0xff;
        sb.append(v4); sb.append('.');
        sb.append(v3); sb.append('.');
        sb.append(v3); sb.append('.');
        sb.append(v1);
        return sb.toString();
    }

    public static byte[] extend(byte[] arr, int len) {
        if (len <= arr.length) {
            System.out.println("[extend] The source array has satisfied the length");
            return arr;
        }
        byte[] ret = new byte[len - arr.length];
        return concat(arr, ret);
    }
    
    public static byte[] slice(byte[] arr, int start, int end){
        int len = end - start;
        byte[] ret = new byte[len];
        System.arraycopy(arr, start, ret, 0, len);
        return ret;
    }
    
    public static String slice(String s, int start, int end) {
        return s.substring(start, end);
    }
    
    public static void error(String s) {
        String msg = "";
        msg += "\033[1;31m";
        msg += s;
        msg += "\033[0m\n";
        System.out.println(msg);
    }
    
    public static void info(String s) {
        String msg = "";
        msg += "\033[1;32m";
        msg += s;
        msg += "\033[0m\n";
        System.out.println(msg);
    }
}
