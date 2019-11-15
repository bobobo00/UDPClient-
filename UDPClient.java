package UDP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 发送端
 * 1，使用DatagramSocket 指定端口，创建发送端。
 * 2，准备数据，封装成DatagramPacket包裹，需指定目的地
 * 3，发送包裹send(DatagramPacket)
 * 4，释放资源
 * @author dell
 *
 */

public class UDPClient {
	public static void main(String[] args) throws Exception {
		System.out.println("发送方启动中....");
		//使用DatagramSocket 指定端口，创建发送端。
		DatagramSocket client=new DatagramSocket(8888);
		//准备数据，封装成DatagramPacket包裹，需指定目的地
		/*ByteArrayOutputStream bos=new ByteArrayOutputStream();
		DataOutputStream ts=new DataOutputStream(new BufferedOutputStream(bos));
		ts.write(1);
		ts.writeBytes("aaaa");
		ts.writeBoolean(false);
		ts.flush();*/
		/*File file=new File("E:\\workspace-java\\多线程\\g.jpg");
		InputStream is=new BufferedInputStream(new FileInputStream(file));
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		byte[] flush=new byte[1024];
		while(is.read(flush)!=-1) {
			bos.write(flush);
		}
		bos.flush();*/
		BufferedReader bar=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String bos=bar.readLine();
			byte[] datas=bos.getBytes();
			DatagramPacket packet=new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",6666));
			//发送包裹send(DatagramPacket)
			client.send(packet);
			if(bos.equals("bye")) {
				break;
			}
		}
		System.out.println("发送结束");
		client.close();
	}

}
