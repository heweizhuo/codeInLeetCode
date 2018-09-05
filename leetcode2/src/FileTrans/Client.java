package FileTrans;

import java.io.*;

import java.net.*;


public class Client{

    public static void main(String[] args)throws Exception{

        //使用本地文件系统接受网络数据并存为新文件

        File file=new File("/Users/heweizhuo/spring/stopData.zip");

        file.createNewFile();

        RandomAccessFile raf=new RandomAccessFile(file,"rw");


        // 通过Socket连接文件服务器

        ServerSocket server=new ServerSocket(3108);

        System.out.println("等待");

        Socket socket=server.accept();



        //创建网络接受流接受服务器文件数据

        FileInputStream in=(FileInputStream)socket.getInputStream();


        //创建缓冲区缓冲网络数据

        byte[] buf=new byte[2048];

        int num=in.read(buf);

        while(num!=(-1)){//是否读完所有数据

            raf.write(buf,0,num);//将数据写往文件

            raf.skipBytes(num);//顺序写文件字节

            num=in.read(buf);//继续从网络中读取文件

        }

        in.close();

        raf.close();

    }

}
