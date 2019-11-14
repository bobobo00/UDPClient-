package UDP;

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
		String data="hello 明天";
		byte[] datas=data.getBytes();
		DatagramPacket packet=new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",9999));
		//发送包裹send(DatagramPacket)
		client.send(packet);
		//释放资源
		client.close();
	}

}
