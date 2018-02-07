var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

var stompFailureCallback = function (error) {
    console.log('STOMP: ' + error);
    setTimeout(connect, 5000);
    console.log('STOMP: Reconecting in 5 seconds');
};


function connect() {
    var socket = new SockJS('http://127.0.0.1:8080/websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        //注册打印请求函数
        //chatId需要从url上获取
        stompClient.subscribe('/wsSend/chat_1514431868889', function (greeting) {
            showGreeting(greeting.body);
        });
        //发送一条空信息表示可以开始接受请求
        stompClient.send("/ws/chat_1514431868889", {}, "");
    },stompFailureCallback);
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
});

