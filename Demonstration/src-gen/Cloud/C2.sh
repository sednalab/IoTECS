#!/bin/bash 
rm -rf 1.pcap 
rm -rf results 
tsharkpid=$(tshark -i null -f udp -w 1.pcap &>/dev/null & echo $!) 
old=$[ $(date +%s%N) / 1000000 ]   
while true 
do 
{ 
if !(ps -aux | grep C2 | grep -v grep) 
then 
sudo kill -9 $tsharkpid 
send=$(tshark -r 1.pcap  -T fields -e frame.time -e ip.src -Y "ip.src==192.168.0.3 and udp"| wc -l) 
receive=$(tshark -r 1.pcap  -T fields -e frame.time -e ip.dst -Y "ip.dst==192.168.0.3 and udp"| wc -l) 
echo wiresharkSend: $send >> results 
echo wiresharkReceive: $receive >> results 
readarray -t linesCount < C2_output.csv 
echo sendCountAndReceiveCount  ${#linesCount[@]} >> results 
echo finished 
break 
else 
duration=10000
new=$[ $(date +%s%N) / 1000000 ]  
let time="$now - $old " 
if $time -lt 10000 
 then 
sleep 10 
else 
sleep 10 
sudo kill -9 $(ps -a | grep C2 | grep -v grep | awk '{print $2}') 
fi 
fi 
} 
done 
mv results Cloud_C2_Result 
