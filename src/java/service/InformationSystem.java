/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author pakutsing
 */
public class InformationSystem {

    public static String GetComputerName() throws UnknownHostException {
        String ComputerName = InetAddress.getLocalHost().getHostName();
        return ComputerName;
    }

    public static String GetIp() throws UnknownHostException {
        String Ip = InetAddress.getLocalHost().getHostAddress();
        return Ip;
    }

    public static String GetUserPc() {
        String userpc = System.getProperty("user.name");
        return userpc;
    }

    public static String GetProgramFiles() throws IOException {
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "cd \"C:\\Program Files\" && dir /b");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        String ProgramFiles = "";
        while (true) {
            line = r.readLine();
            if (line == null) {
                break;
            }
            ProgramFiles += line + "<br>";
        // System.out.println(line);
        }
        return ProgramFiles;
    }

    public static String GetProgramFilesx86() throws IOException {
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "cd \"C:\\Program Files (x86)\" && dir /b");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        String ProgramFilesx86 = "";
        while (true) {
            line = r.readLine();
            if (line == null) {
                break;
            }
            ProgramFilesx86 += line + "<br>";
        // System.out.println(line);
        }
        return ProgramFilesx86;
    }

    public static String GetOs(String pcuser) {
        HashMap<String, String> OS = new HashMap<String, String>();
        OS.put("windows nt 6.3", "Windows 8.1");
        OS.put("windows nt 6.2", "Windows 8");
        OS.put("windows nt 6.1", "Windows 7");
        OS.put("windows nt 6.0", "Windows Vista");
        OS.put("windows nt 5.2", "Windows Server 2003/XP x64");
        OS.put("windows nt 5.1", "Windows XP");
        OS.put("windows xp", "Windows XP");
        OS.put("windows nt 5.0", "Windows 2000");
        OS.put("windows me", "Windows ME");
        OS.put("win98", "Windows 98");
        OS.put("win95", "Windows 95");
        OS.put("win16", "Windows 3.11");
        OS.put("mac_powerpc", "Mac OS 9");
        OS.put("macintosh|mac os x", "Mac OS X");
        OS.put("linux", "Linux");
        OS.put("ubuntu", "Ubuntu");
        OS.put("iphone", "iPhone");
        OS.put("ipod", "iPod");
        OS.put("ipad", "iPad");
        OS.put("android", "Android");
        OS.put("blackberry", "BlackBerry");
        OS.put("webos", "Mobile");

        ArrayList<String> OSList = new ArrayList<String>();
        OSList.add("windows nt 6.3");
        OSList.add("windows nt 6.2");
        OSList.add("windows nt 6.1");
        OSList.add("windows nt 6.0");
        OSList.add("windows nt 5.2");
        OSList.add("windows nt 5.1");
        OSList.add("windows xp");
        OSList.add("windows nt 5.0");
        OSList.add("windows me");
        OSList.add("win98");
        OSList.add("win95");
        OSList.add("win16");
        OSList.add("mac_powerpc");
        OSList.add("macintosh|mac os x");
        OSList.add("linux");
        OSList.add("ubuntu");
        OSList.add("iphone");
        OSList.add("ipod");
        OSList.add("ipad");
        OSList.add("android");
        OSList.add("blackberry");
        OSList.add("webos");

        String outputos = null;

        for (String arr : OSList) {
            if (pcuser.toLowerCase().contains(arr)) {
                outputos = OS.get(arr);
            }

        }
        return outputos;
    }
}
