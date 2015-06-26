package app.Code;

import java.io.*;
import java.util.Date;

import java.awt.*;

import java.awt.image.*;

import javax.imageio.*;

import com.swetake.util.Qrcode;

public class QRCodeEncoderTest
{
	
	public QRCodeEncoderTest()
	{
		
	}
	
	public static void create_image(String sms_info) throws Exception
	{
		
		try
		{
			
			Qrcode testQrcode = new Qrcode();
			
			testQrcode.setQrcodeErrorCorrect('M');
			
			testQrcode.setQrcodeEncodeMode('B');
			
			testQrcode.setQrcodeVersion(20);
			
			String testString = sms_info;
			
			byte[] d = testString.getBytes("gbk");
			
			System.out.println(d.length);
			
			BufferedImage bi = new BufferedImage(98, 98,

			BufferedImage.TYPE_BYTE_BINARY);
			
			Graphics2D g = bi.createGraphics();
			
			g.setBackground(Color.WHITE);
			
			g.clearRect(0, 0, 98, 98);
			
			g.setColor(Color.BLACK);
			
			// 限制最大字节数为120
			
			if (d.length > 0 && d.length < 300)
			{
				
				boolean[][] s = testQrcode.calQrcode(d);
				
				for (int i = 0; i < s.length; i++)
				{
					
					for (int j = 0; j < s.length; j++)
					{
						
						if (s[j][i])
						{
							
							g.fillRect(j * 2 + 3, i * 2 + 3, 2, 2);
							
						}
						
					}
					
				}
				
			}
			
			g.dispose();
			
			bi.flush();
			
			File f = new File("D:\\QRCodeTest\\" + sms_info + ".jpg");
			
			if (!f.exists())
			{
				
				f.createNewFile();
				
			}
			
			// 创建图片
			
			ImageIO.write(bi, "jpg", f);
			
		} // end try
		
		catch (Exception e)
		{
			
			e.printStackTrace();
			
		} // end catch
		
	}
	
	public static void main(String[] args) throws Exception
	{
		
		System.out.println(new Date());
		
		QRCodeEncoderTest.create_image("QRCode");
		
		System.out.println(new Date());
		
	}
	
}
