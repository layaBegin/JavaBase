package com.heima.code;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 这个Servlet是一张图片
 * 在会话域中有一个键叫code，可以取出值
 */
@WebServlet("/code")
public class PicCodeServlet extends HttpServlet {

    //随机类
    private Random random = new Random();

    /**
     * 随机获取一种颜色
     */
    private Color getRandomColor() {
        //随机得到r,g,b的取值，范围是0~255
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r, g, b);  //red红 green绿 blue蓝
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置MIME类型
        response.setContentType("image/jpeg");
        //定义宽和高的值
        int width = 90;
        int height = 30;
        //1. 创建一张图片，参数：宽，高，图片模式
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //获取画笔对象
        Graphics graphics = image.getGraphics();
        //整个图片填充白色
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0,width,height);

        //2. 随机绘制4个验证码
        char[] arr = { 'A', 'B', 'C', 'D', 'N', 'E', 'W', 'b', 'o', 'y', '1', '2', '3', '4','5','6','7','8' };

        //设置字体，字体对象有三个参数：字体名字，字体样式(加粗，斜体), 大小
        graphics.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD + Font.ITALIC, 19));

        //创建一个StringBuilder
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            //随机获取1个索引号
            int index = random.nextInt(arr.length);
            //随机获取字符数组的一个字符
            char c = arr[index];
            //添加到字符串中
            sb.append(c);
            //每个字符的颜色不同
            graphics.setColor(getRandomColor());
            //写字符，参数：文字内容,x,y坐标  (把字符转成字符串)
            graphics.drawString(String.valueOf(c),10+(i*20), 20);
        }

        //将字符串放在会话域中
        HttpSession session = request.getSession();
        session.setAttribute("code", sb.toString());
        System.out.println("验证码：" + sb);

        //3. 绘制8条干扰线
        for (int i = 0; i < 8; i++) {
            //指定颜色
            graphics.setColor(getRandomColor());
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            //画线，起点和终点
            graphics.drawLine(x1,y1,x2,y2);
        }

        //4. 把图片输出到浏览器，参数：输出的图片对象，图片格式，响应输出流
        ImageIO.write(image,"jpg", response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
