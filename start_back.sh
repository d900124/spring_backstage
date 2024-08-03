#linux
nohup java -Xms512m -Xmx1024m -jar ./target/spring_backstage-0.0.1-SNAPSHOT.jar --server.port=8080 > output.log 2>&1 &

#windows
Start-Process cmd.exe -ArgumentList "/c java -Xms512m -Xmx1024m -jar ./target/spring_backstage-0.0.1-SNAPSHOT.jar --server.port=8080 > output.log 2>&1" -NoNewWindow
