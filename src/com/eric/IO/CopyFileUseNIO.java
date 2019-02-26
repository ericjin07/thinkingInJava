package com.eric.IO;

import net.mindview.util.RandomGenerator;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 02/20/2019 11:24 AM
 */
public class CopyFileUseNIO {

    public static void main(String[] args) throws Exception {
        String src = "C:\\Users\\lanse\\Downloads\\金志斌_java开发_18574561771_3年经验.txt";
        String dest = "C:\\Users\\lanse\\Downloads\\testNio.txt";
        copyFileWithNio(src,dest);
//        BufferedReader reader = new BufferedReader(new FileReader(dest));
//        String line = "";
//        while ( (line = reader.readLine()) != null){
//            System.out.println(line);
//        }
//        reader.close();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        RandomAccessFile af = new RandomAccessFile(dest,"rw");
        FileChannel fc = af.getChannel();
        int byteRem = 0;
        while ((byteRem = fc.read(buffer)) != -1) {
            System.out.println(" read --" + byteRem);
            buffer.flip();
            while (buffer.hasRemaining())
                System.out.print((char) buffer.get());
            buffer.clear();
        }
        fc.close();
        af.close();
    }

    private static void copyFileWithNio(String src, String dest) throws Exception {
        FileChannel inChannel = new FileInputStream(src).getChannel();
        FileChannel outChannel = new FileOutputStream(dest).getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true){
            if (inChannel.read(buffer) <= 0)
                break;
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }
        inChannel.close();
        outChannel.close();

    }
}
