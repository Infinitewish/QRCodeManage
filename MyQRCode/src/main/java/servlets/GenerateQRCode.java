package servlets;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/generate")
public class GenerateQRCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            // 获取输入的文本
            String url = request.getParameter("url");

            // 设置二维码属性
            Map map = new HashMap();
            map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H); // 误差校正级别
            map.put(EncodeHintType.CHARACTER_SET, "UTF-8"); // 字符集
            map.put(EncodeHintType.MARGIN, 1); // 四周留白

            // 创建MultiFormatWriter
            MultiFormatWriter writer = new MultiFormatWriter();
            BitMatrix bitMatrix = writer.encode(url, BarcodeFormat.QR_CODE, 800, 800, map);
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();

            // 生成二维码图片
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
                }
            }

            // 相应图片到浏览器
            ServletOutputStream outputStream = response.getOutputStream();
            ImageIO.write(image, "png", outputStream);
            outputStream.flush();
            outputStream.close();

        } catch (Exception exception) {

            exception.printStackTrace();

        }


    }
}
