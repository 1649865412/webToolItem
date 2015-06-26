package app.Code;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.exception.DecodingFailedException;

import com.swetake.util.Qrcode;

/**
 *  生成二维码类
 *  <code>QRCode.java</code>
 *  <p>
 *  <p>Copyright  2015 All right reserved.
 *  @author admin 时间 2015-6-8 上午11:11:18	
 *  @version 1.0 
 *  </br>最后修改人 无
 */
public class QRCode
{
	
	public void encoderQRCode(String content, String imgPath)
	{
		this.encoderQRCode(content, imgPath, "png", 7);
	}
	
	public void encoderQRCode(String content, OutputStream output)
	{
		this.encoderQRCode(content, output, "png", 7);
	}
	
	public void encoderQRCode(String content, String imgPath, String imgType)
	{
		this.encoderQRCode(content, imgPath, imgType, 7);
	}
	
	public void encoderQRCode(String content, OutputStream output, String imgType)
	{
		this.encoderQRCode(content, output, imgType, 7);
	}
	
	public void encoderQRCode(String content, String imgPath, String imgType, int size)
	{
		try
		{
			BufferedImage bufImg = this.qRCodeCommon(content, imgType, size);
			
			File imgFile = new File(imgPath);
			ImageIO.write(bufImg, imgType, imgFile);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 功能:生成二维码封装方法
	 * <p>作者 杨荣忠 2015-6-8 上午11:10:59
	 * @param content
	 * @param output
	 * @param imgType
	 * @param size
	 */
	public void encoderQRCode(String content, OutputStream output, String imgType, int size)
	{
		try
		{   
			//具体的生成方法
			BufferedImage bufImg = this.qRCodeCommon(content, imgType, size);
			ImageIO.write(bufImg, imgType, output);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 功能:具体生成图片方法
	 * <p>作者 杨荣忠 2015-6-8 上午11:10:02
	 * @param content
	 * @param imgType
	 * @param size
	 * @return
	 */
	private BufferedImage qRCodeCommon(String content, String imgType, int size)
	{
		BufferedImage bufImg = null;
		try
		{
			Qrcode qrcodeHandler = new Qrcode();
			qrcodeHandler.setQrcodeErrorCorrect('M');
			qrcodeHandler.setQrcodeEncodeMode('B');
			qrcodeHandler.setQrcodeVersion(size);
			byte[] contentBytes = content.getBytes("utf-8");
			int imgSize = 67 + 12 * (size - 1);
			bufImg = new BufferedImage(imgSize, imgSize, BufferedImage.TYPE_INT_RGB);
			Graphics2D gs = bufImg.createGraphics();
			gs.setBackground(Color.WHITE);
			gs.clearRect(0, 0, imgSize, imgSize);
			
			gs.setColor(Color.BLACK);
			int pixoff = 2;
			if (contentBytes.length > 0 && contentBytes.length < 800)
			{
				boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);
				for (int i = 0; i < codeOut.length; i++)
				{
					for (int j = 0; j < codeOut.length; j++)
					{
						if (codeOut[j][i])
						{
							gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
						}
					}
				}
			}
			else
			{
				throw new Exception("QRCode content bytes length = " + contentBytes.length + " not in [0, 800].");
			}
			gs.dispose();
			bufImg.flush();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return bufImg;
	}
	
	
	/**
	 * 功能:编码二维码，返回图片路径
	 * <p>作者 杨荣忠 2015-6-8 上午11:08:42
	 * @param imgPath
	 * @return
	 */
	public String decoderQRCode(String imgPath)
	{
		File imageFile = new File(imgPath);
		BufferedImage bufImg = null;
		String content = null;
		try
		{
			bufImg = ImageIO.read(imageFile);
			QRCodeDecoder decoder = new QRCodeDecoder();
			content = new String(decoder.decode(new CodeImage(bufImg)), "utf-8");
		}
		catch (IOException e)
		{
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
		catch (DecodingFailedException dfe)
		{
			System.out.println("Error: " + dfe.getMessage());
			dfe.printStackTrace();
		}
		return content;
	}
	
	
	/**
	 * 功能:编码二维码，返回图片路径
	 * <p>作者 杨荣忠 2015-6-8 上午11:08:55
	 * @param input
	 * @return
	 */
	public String decoderQRCode(InputStream input)
	{
		BufferedImage bufImg = null;
		String content = null;
		try
		{
			bufImg = ImageIO.read(input);
			QRCodeDecoder decoder = new QRCodeDecoder();
			content = new String(decoder.decode(new CodeImage(bufImg)), "utf-8");
		}
		catch (IOException e)
		{
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
		catch (DecodingFailedException dfe)
		{
			System.out.println("Error: " + dfe.getMessage());
			dfe.printStackTrace();
		}
		return content;
	}
	
	
	/**
	 * 功能:二维码生成测试方法
	 * <p>作者 杨荣忠 2015-6-8 上午11:01:34
	 * @param args
	 */
	public static void main(String[] args)
	{
		String imgPath = "F:/company.png";
		String encoderContent = "http://www.sifangstreet.com/";
		QRCode handler = new QRCode();
		handler.encoderQRCode(encoderContent, imgPath, "png");
		// try {
		// OutputStream output = new FileOutputStream(imgPath);
		//handler.encoderQRCode(content, output);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		
		String decoderContent = handler.decoderQRCode(imgPath);
		System.out.println(decoderContent);
	}
}