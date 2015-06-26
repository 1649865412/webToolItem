package app.Code;

import java.awt.image.BufferedImage;

import jp.sourceforge.qrcode.data.QRCodeImage;


/**
 *  ��ά��bean��
 *  <code>CodeImage.java</code>
 *  <p>
 *  <p>Copyright  2015 All right reserved.
 *  @author admin ʱ�� 2015-6-8 ����11:11:40	
 *  @version 1.0 
 *  </br>����޸��� ��
 */
public class CodeImage implements QRCodeImage{
	 BufferedImage bufImg;
     public CodeImage(BufferedImage bufferedImage){
    	 this.bufImg=bufferedImage;
     }
	
	public int getHeight() {
		// TODO Auto-generated method stub
		return bufImg.getHeight();
	}

	public int getPixel(int x, int y) {
		// TODO Auto-generated method stub
		return bufImg.getRGB(x, y);
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return bufImg.getWidth();
	}
     
}
