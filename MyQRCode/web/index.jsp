<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

  <head>
    <link rel="stylesheet" href="css/indexStyle.css">
    <title>二维码生成器 by Infinitewish</title>
  </head>

  <body>
    <div class="main">

      <div class="box">
        <h2>基于谷歌的zxing生成二维码</h2>
      </div>

      <div class="box">
        <div>输入要生成二维码的文本内容：</div>
        <div>
          <input class="generateText" type="text" id="url" />
        </div>
        <div>
          <button class="generateButton" onclick="generateQRCode()">生成</button>
        </div>
      </div>

      <div class="box">
        <img id="QRCodeImg" />
      </div>

    </div>
  </body>

  <script>
    function generateQRCode() {
      var url = document.getElementById("url").value;
      var QRCodeImg = document.getElementById("QRCodeImg");
      QRCodeImg.src = "/MyQRCode/generate?url=" + url;
    }
  </script>

</html>
