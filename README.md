
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
- Go to src and find
```
ServerSocket serverSocket = new ServerSocket(8888);
```
- Change **"8888"** to your own port and run application
_Now you can run ngrok server on your own port!_

## Authors

- [@0WhiteDev](https://github.com/0WhiteDev)

