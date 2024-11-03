<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>生成二维码</title>
  </head>
  <body>
    <div>
      <h1>使用谷歌的zxing生成</h1>
      <hr />
      文本内容：<input type="text" id="url" /><button onclick="generateQRCode()">生成</button>
      <hr />
      <img id="QRCodeImg" />
      <hr />
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
