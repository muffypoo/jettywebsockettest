# jettywebsockettest
Sample jetty server using websocket for communication.

** Some features
-- specify port number from command line startup (default 8080)

# NOTES

Based on article by Amri Shodiq (https://itnext.io/@amrishodiq)

Source: https://itnext.io/writing-a-web-socket-server-with-embedded-jetty-46fe9ab1c435 

Since I've tried but unable to locate a git equivalent of what he'd 
prepared, this is it. Some amendments were made to suit the MVC structure 
which I'm familiar with, minimally.

A simulated Repository is built-in for demonstration simplicity.

# PREREQUISITES

1. Simple WebSocket Client (Chrome WebStore)
2. Java Runtime Environment 1.8

# TEST

1. Run JAR file using command prompt: "java -jar jettywebsocket-test.jar"
2. Connect Simple WebSocket Client to "ws://localhost:8080/messaging" on Browser Window Alice
3. Connect Simple WebSocket Client to "ws://localhost:8080/messaging" on Browser Window Bob
4. Send test message using Alice: {"operation": 1,"user": {"username": "alice","password": "123456"}}
    1. Receive server reply: {"operation":1,"session":"SOMEVALIDSESSION"}
5. Send test message using Alice: {"operation": 101,"session": "SOMEVALIDSESSION","message": {"from": "alice","to": "bob","body": "Hello Bob","sent": 1234567}}
    1. Server log outputs: "User is offline"
6. Send test message using Bob: {"operation": 1,"user": {"username": "bob","password": "654321"}}
    1. Receive server reply: {"operation":1,"session":"SOMEVALIDSESSION"}
7. Send test message using Bob: {"operation": 101,"session": "SOMEVALIDSESSION","message": {"from": "bob","to": "alice","body": "Hello Alice","sent": 1234567}}
    1. Receive server reply: {"from":"bob","to":"alice","body":"Hello Alice","sent":1234567}
