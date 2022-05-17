#!/bin/bash 
bash platform.sh 
bash vm.sh 
bash Cloud/cloudScript.sh 
#compile all 
nohup bash platform_localhost.sh & 
sshpass -p password2 scp -o StrictHostKeyChecking=no platform_192.168.0.4.sh user2@192.168.0.4:/home/user2 
sshpass -p password2 scp -o StrictHostKeyChecking=no getDelay.py user2@192.168.0.4:/home/user2 
sshpass -p password2 ssh user2@192.168.0.4 > /dev/null 2>&1 << finish 
cd /home/user2 
nohup bash platform_192.168.0.4.sh & 
exit 
finish 
bash run_SN1.sh 
bash run_SN2.sh 
old=$[ $(date +%s%N) / 1000000 ]   
let time=0 
while [ $time -lt 10000 ] 
do 
 { 
sleep 2 
new=$[ $(date +%s%N) / 1000000 ]   
let time="$new - $old " 
} 
done 
while true 
do 
sshpass -p password2 scp -o StrictHostKeyChecking=no user2@192.168.0.4:/home/user2/platform_192.168.0.4_Result ./results 
if [ -d "results/platform_192.168.0.4_Result" ]; then 
break 
fi 
done 
