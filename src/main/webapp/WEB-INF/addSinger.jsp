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
    <title>註冊</title>
    <link rel="stylesheet" type="text/css" href="../style/css.css"/>
    <style type="text/css">
        .floatLeft {
            float: left;
        }

        .floatRight {
            float: right;
        }

        .clear {
            clear: both;
        }

        #progressIndicator {
            font-size: 10pt;
            height: 40px;
        }

        #fileInfo {
            font-size: 10pt;
            font-style: italic;
            color: #aaa;
            margin-top: 10px;
        }

        #progressBar {
            height: 14px;
            border: 1px solid #cccccc;
            display: none;
            border-radius: 10px;
            -moz-border-radius: 10px;
            margin-top: 12px;
            background-image: -moz-linear-gradient(top, #66cc00, #4b9500);
            background-image: -webkit-gradient(linear, left top, left bottom, from(#66cc00), to(#4b9500));
            background-color: #4b9500;
        }

    </style>
    <script type="application/javascript" language="JavaScript">
        function choose() {
            var a = document.createEvent("MouseEvents");//FF的處理
            a.initEvent("click", true, true);
            document.getElementById("file").dispatchEvent(a);
        }

        function valid2() {
            var nickname = document.getElementById("nickname").value;
            if (nickname == null || nickname == '') {
                document.getElementById("nicknamemessage").style.display = "";
            } else {
                document.getElementById("nicknamemessage").style.display = "none";
            }
        }
        function fileSelected() {
            var file = document.getElementById('file').files[0];
            if (file) {
                var fileSize = 0;
                if (file.size > 1024 * 1024)
                    fileSize = (Math.round(file.size * 100 / (1024 * 1024)) / 100).toString() + 'MB';
                else
                    fileSize = (Math.round(file.size * 100 / 1024) / 100).toString() + 'KB';
                document.getElementById('fileName').innerHTML = 'Name: ' + file.name;
                document.getElementById('fileSize').innerHTML = 'Size: ' + fileSize;
                document.getElementById('fileType').innerHTML = 'Type: ' + file.type;
            }
        }
        function uploadFile() {

            var nickname = document.getElementById("nickname").value;
            var file = document.getElementById("file").value;
            if (nickname == null || nickname == '') {
                document.getElementById("nicknamemessage").style.display = "";
            } else {
//                if (file == null || file == '') {
//                    alert("頭像不能為空");
//                } else {
//                    document.getElementById("form1").submit();
//                }
                var fd = new FormData();
                var tempid = document.getElementById('tempid').value;
                var nickname = document.getElementById('nickname').value;
                var obj = document.getElementById('gender');
                var index = obj.selectedIndex;
                var gender = obj.options[index].value;
                fd.append("file", document.getElementById('file').files[0]);
                fd.append("tempid", tempid);
                fd.append("nickname", nickname);
                fd.append("gender", gender);
                var xhr = new XMLHttpRequest();
                xhr.upload.addEventListener("progress", uploadProgress, false);
                xhr.addEventListener("load", uploadComplete, false);
                xhr.addEventListener("error", uploadFailed, false);
                xhr.addEventListener("abort", uploadCanceled, false);
                xhr.open("POST", "/pk/addSinger");//修改成自己的接口
//                document.getElementById("form1").submit();
                xhr.send(fd);
                document.getElementById('addBtn').disabled=true;
            }
        }
        function uploadProgress(event) {
            if (event.lengthComputable) {
                var percentComplete = Math.round(event.loaded * 100 / event.total);
                document.getElementById('progressNumber').innerHTML = percentComplete.toString() + '%';
                document.getElementById('progressBar').style.display = 'block';
                document.getElementById('progressBar').style.width = percentComplete.toString() * 2.55 + 'px';
                ;
            }
            else {
                document.getElementById('progressNumber').innerHTML = 'unable to compute';
                document.getElementById('progressBar').style.display = 'none';
            }
        }
        function uploadComplete(evt) {
            /* 服务器端返回响应时候触发event事件*/
//            if(confirm(evt.target.responseText)){
//              document.getElementById('progressIndicator').style.display='none';
//              document.getElementById('message').innerHTML=evt.target.responseText;
//            };
            var json = eval('(' + evt.target.responseText + ')');
            var result = json['result'];
            if(result=="success"){
                document.getElementById('progressNumber').innerHTML = '';
                document.getElementById('progressBar').style.display = 'none';
//                window.location.href='/pk/ok?singerid='+json['singerid'];
                window.location.href='../ok.jsp';
//                var xhr = new XMLHttpRequest();
//                var fd = new FormData();
//                fd.append('singerid',json['singerid']);
//                xhr.open('POST','/pk/ok')
//                xhr.send(fd);
            }else if(result == "failure"){
                document.getElementById('progressNumber').innerHTML = '';
                document.getElementById('progressBar').style.display = 'none';
                alert("尺寸小於600 X 800，請重新上傳");
            }else if(result == "notempid"){
                document.getElementById('progressNumber').innerHTML = '';
                document.getElementById('progressBar').style.display = 'none';
                alert("註冊失敗");
            }


        }
        function uploadFailed(evt) {
            alert("上傳頭像失敗");
        }
        function uploadCanceled(evt) {
            alert("上傳被用戶中斷或者瀏覽器失去連接");
        }
    </script>
</head>
<body>


<div class="top" name="top">
    <div class="index_citybg">
        <div class="upload">
            <div>
            </div>
            <div><a class="up_img" href="javascript:choose();">上傳頭像</a></div>
        </div>
        <div class="search floleft">
            <div class="form1">
                <form id="form1" name="form1" enctype="multipart/form-data" method="post" action="/pk/addSinger">
                    <input id="file" class="up_load" name="file" type="file"/>
                    <%--<progress id="progressBar" value="" max="100"></progress>--%>
                    <div id="progressIndicator">
                        <div id="progressBar" class="floatLeft"></div>
                        <div id="progressNumber" class="floatRight"></div>
                    </div>
                    <div id="message">

                    </div>


                    <span id="filemessage" style="font-size:12;color:red;display: none">頭像不能為空</span>
                    <input type="hidden" id="tempid" name="tempid" value=${tempid} />

                    <div class="p_1">
                        <label>昵稱：</label>
                        <%--<input class="sinput_1" id="nickname" name="nickname" size="10" type="text" value="不能超過10個字"--%>
                        <%--onfocus="this.value='';" onblur="if(this.value==''){this.value='不能超過10個字'}">--%>
                        <input class="sinput_1" id="nickname" name="nickname" size="10" type="text"
                               onblur="valid2();">
                        <span id="nicknamemessage"
                              style="font-size:12;color:red;display: none">暱稱不能為空</span>
                    </div>
                    <div>
                        <label>性別：</label>
                        <select id="gender" name="gender" class="sinput_2">
                            <option value="0" selected="selected">男</option>
                            <option value="1">女</option>
                        </select>
                    </div>
                    <div class="p_2">
                        <input id="addBtn" name="" class="button left button_1" type="button" onclick="this.disabled=true;uploadFile();" value="註冊"/>
                        <input name="" class="button left" type="button" value="取消"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>