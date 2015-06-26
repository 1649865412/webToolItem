package com.dcecSupplyWEB.servlet;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.swetake.util.Qrcode;


public class PrintTwoBarCodeServlet extends HttpServlet{


/**
* 专门用来生成二维码图片的servlet
*/
private static final long serialVersionUID = 1L;


@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
throws ServletException, IOException {
doPost(req, resp);
}


@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
                                         throws ServletException, IOException {
		String code = request.getParameter("code");
		
		Qrcode testQrcode =new Qrcode();
		testQrcode.setQrcodeErrorCorrect('M');
		testQrcode.setQrcodeEncodeMode('B');
		testQrcode.setQrcodeVersion(7);
		byte[] d = code.getBytes("gbk");
		BufferedImage image = new BufferedImage(98, 98, BufferedImage.TYPE_BYTE_BINARY);
		Graphics2D g = image.createGraphics();
		g.setBackground(Color.WHITE);
		g.clearRect(0, 0, 98, 98);
		g.setColor(Color.BLACK);
		if (d.length>0 && d.length <120){
		boolean[][] s = testQrcode.calQrcode(d);
		for (int i=0;i<s.length;i++){
		for (int j=0;j<s.length;j++){
		if (s[j][i]) {
		g.fillRect(j*2+3,i*2+3,2,2);
		}
		}
		}
		}
      g.dispose();
     image.flush();
     ImageIO.write(image, "jpg", response.getOutputStream());
}
}
