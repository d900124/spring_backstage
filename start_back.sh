#linux
nohup java -Xms512m -Xmx1024m -jar ./target/spring_backstage-0.0.1-SNAPSHOT.jar --server.port=8080 > output.log 2>&1 &



#windows
#起背景服務
Start-Process cmd.exe -ArgumentList "/c java -Xms512m -Xmx1024m -jar ./target/spring_backstage-0.0.1-SNAPSHOT.jar --server.port=8080 > output.log 2>&1" -NoNewWindow

#查詢port號 服務
netstat -aon | findstr :8080

#kill 服務
taskkill /PID 8080 /F

#查看log
Get-Content -Path ".\output.log" -Tail 200 -Wait

