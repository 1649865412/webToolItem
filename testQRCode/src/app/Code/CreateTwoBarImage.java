package app.Code;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import com.swetake.util.Qrcode;


/**
 *  ��ά��ͼ������
 *  <code>CreateTwoBarImage.java</code>
 *  <p>
 *  <p>Copyright  2015 All right reserved.
 *  @author admin ʱ�� 2015-6-8 ����11:13:23	
 *  @version 1.0 
 *  </br>����޸��� ��
 */
public class CreateTwoBarImage
{
	public void creatTxm(String param) throws Exception
	{
		Qrcode qrcode = new Qrcode();
		qrcode.setQrcodeErrorCorrect('M');
		qrcode.setQrcodeEncodeMode('B');
		qrcode.setQrcodeVersion(7);
		
		byte[] bstr = param.getBytes("UTF-8");
		BufferedImage bi = new BufferedImage(139, 139, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bi.createGraphics();
		g.setBackground(Color.WHITE); // ������ɫ
		g.clearRect(0, 0, 139, 139);
		g.setColor(Color.BLACK); // ������ɫ
		if (bstr.length > 0 && bstr.length < 123)
		{
			boolean[][] b = qrcode.calQrcode(bstr);
			for (int i = 0; i < b.length; i++)
			{
				for (int j = 0; j < b.length; j++)
				{
					if (b[j][i])
					{
						g.fillRect(j * 3 + 2, i * 3 + 2, 3, 3);
					}
				}
				
			}
		}
		g.dispose();
		bi.flush();
		String FilePath = "d:/images/" + param + ".jpg";
		File f = new File(FilePath);
		ImageIO.write(bi, "jpg", f);
	}
	
	public static void main(String args[])
	{
		try
		{
			new CreateTwoBarImage().creatTxm("bar");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}