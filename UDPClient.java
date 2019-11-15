package UDP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
		/*ByteArrayOutputStream bos=new ByteArrayOutputStream();
		DataOutputStream ts=new DataOutputStream(new BufferedOutputStream(bos));
		ts.write(1);
		ts.writeBytes("aaaa");
		ts.writeBoolean(false);
		ts.flush();*/
		/*File file=new File("E:\\workspace-java\\���߳�\\g.jpg");
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
			//���Ͱ���send(DatagramPacket)
			client.send(packet);
			if(bos.equals("bye")) {
				break;
			}
		}
		System.out.println("���ͽ���");
		client.close();
	}

}
