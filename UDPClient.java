package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * ���Ͷ�
 * 1��ʹ��DatagramSocket ָ���˿ڣ��������Ͷˡ�
 * 2��׼�����ݣ���װ��DatagramPacket��������ָ��Ŀ�ĵ�
 * 3�����Ͱ���send(DatagramPacket)
 * 4���ͷ���Դ
 * @author dell
 *
 */

public class UDPClient {
	public static void main(String[] args) throws Exception {
		System.out.println("���ͷ�������....");
		//ʹ��DatagramSocket ָ���˿ڣ��������Ͷˡ�
		DatagramSocket client=new DatagramSocket(8888);
		//׼�����ݣ���װ��DatagramPacket��������ָ��Ŀ�ĵ�
		String data="hello ����";
		byte[] datas=data.getBytes();
		DatagramPacket packet=new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",9999));
		//���Ͱ���send(DatagramPacket)
		client.send(packet);
		//�ͷ���Դ
		client.close();
	}

}
