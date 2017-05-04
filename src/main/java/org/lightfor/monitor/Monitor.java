package org.lightfor.monitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.Properties;
import java.util.Set;

/**
 * 监控
 * Created by Light on 2017/5/2.
 */
public class Monitor {

    public static void main(String[] args) throws IOException {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().totalMemory());

        OperatingSystemMXBean osb = ManagementFactory.getOperatingSystemMXBean();
        System.out.println(osb.getArch());
        System.out.println(osb.getVersion());
        Properties properties = System.getProperties();
        Set<String> propertyNames = properties.stringPropertyNames();
        for(String propertyName : propertyNames){
            System.out.print(propertyName);
            System.out.print(":");
            System.out.println(properties.getProperty(propertyName));
        }


        Process process = Runtime.getRuntime().exec("wmic  process get Caption,KernelModeTime,ReadOperationCount,ThreadCount,UserModeTime,WriteOperationCount");
        //CommandLine,
        BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = input.readLine()) != null){
            System.out.println(line);
        }
    }
}
