
# PrivateChat Server


Server for the PrivateChat Client application 💬

## Basic information

All is builded on native java methods (you don't need external libraries) 📚

#### Required
- Java 17+
- Ngrok **(Recommended)**
- or any application hosting with public ip

#### How to run server on ngrok
- Download ngrok from **https://ngrok.com**
- Register your account and get your own token
- Set your token in ngrok app in cmd by
```
ngrok authtoken <token>
```
- Run **PrivateChat Server** and run ngrok server by
```
ngrok tcp 8888
```

#### How to change port
- Run server using this
```
java -jar PrivateChatServer.jar <port>
```
- Set **<port>** to value on which you want to run the server (if you leave <port> empty then the server will start on port **8888**)

## Authors

- [@0WhiteDev](https://github.com/0WhiteDev)

