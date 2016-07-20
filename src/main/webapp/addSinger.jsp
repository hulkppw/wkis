<!DOCTYPE HTML>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta content="width=device-width,user-scalable=no" name="viewport">
    <meta name="keywords" content=""/>
    <meta name="viewport" content="width=device-width; initial-scale=1.0;  minimum-scale=1.0; maximum-scale=1.0"/>
    <meta name="MobileOptimized" content="320"/>
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="style/css.css"/>
    <script type="application/javascript" language="JavaScript">
        var t = setTimeout("display()", 5000);
        function choose() {
            document.getElementById("file").click();
        }
        function display() {
//            if (document.getElementById("file").value.length > 0) {
//                alert(document.getElementById("file").value);
//                document.getElementById("displayImg").src = document.getElementById("file");
//            }
        }
        function upload() {
            var img = document.getElementsByTagName('img')[0]
            var width = getWH(img, 'width') // 690
            var height = getWH(img, 'height');
            if (width < 600 || height < 800) {
                alert("尺寸太小");
                return;
            }
        }

        function getWH(el, name) {
            var val = name === "width" ? el.offsetWidth : el.offsetHeight,
                    which = name === "width" ? ['Left', 'Right'] : ['Top', 'Bottom'];

            // display is none
            if (val === 0) {
                return 0;
            }

            for (var i = 0, a; a = which[i++];) {
                val -= parseFloat(getStyle(el, "border" + a + "Width")) || 0;
                val -= parseFloat(getStyle(el, "padding" + a)) || 0;
            }

            return val + 'px';
        }
        function getStyle(el,name) {
            if(window.getComputedStyle) {
                return window.getComputedStyle(el, null)[name];
            }else{
                return el.currentStyle[name];
            }
        }
    </script>
</head>
<body>


<div class="top" name="top">
    <div class="index_citybg">
        <div class="upload">
            <div><a class="photo" href="javascript:choose();"><img id="displayImg" src="images/photo.jpg" alt=""/></a>
            </div>
            <div><a class="up_img" href="javascript:choose();">上传头像</a></div>
        </div>
        <div class="search floleft">
            <div class="form1">
                <form id="form1" name="form1" enctype="multipart/form-data" method="post" action="/pk/addSinger">
                    <input id="file" name="file" type="file" style="display: none"/>

                    <div class="p_1">
                        <label>昵称：</label>
                        <input class="sinput_1" id="nickname" name="nickname" size="10" type="text" value="不能超过10个字"
                               onfocus="this.value='';" onblur="if(this.value==''){this.value='不能超过10个字'}">
                    </div>
                    <div>
                        <label>性别：</label>
                        <select name="searchType" class="sinput_2">
                            <option value="man" selected="selected">男</option>
                            <option value="woman">女</option>
                        </select>
                    </div>
                    <div class="p_2">
                        <input name="" class="button left button_1" type="button" onclick="upload();" value="上传"/>
                        <input name="" class="button left" type="submit" value="取消"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>