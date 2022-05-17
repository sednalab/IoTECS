#!/bin/bash 
rm -rf 1.pcap 
rm -rf 2.pcap 
rm -rf results 
rm -rf pcap.txt 
tsharkpid1=$(tshark -i en0 -f udp -w 1.pcap &>/dev/null & echo $!) 
tsharkpid2=$(tshark -i en0 -f tcp -w 2.pcap &>/dev/null & echo $!) 
old=$[ $(date +%s%N) / 1000000 ]   
time=0 
while [ $time -lt 10000 ]  
do 
{ 
sleep 10 
new=$[ $(date +%s%N) / 1000000 ]   
let time="$new - $old" 
} 
done 
sleep 10 
sudo kill -9 $tsharkpid1 
sudo kill -9 $tsharkpid2 
ip=$(ifconfig en0 | grep inet | grep -v inet6 | awk '{print $2}') 
sendUDP=$(tshark -r 1.pcap  -T fields -e frame.time -e ip.src -Y "ip.src==$ip  and udp"| wc -l) 
sendTCP=$(tshark -r 2.pcap  -T fields -e frame.time -e ip.src -Y "ip.src==$ip  and tcp"| wc -l) 
receiveUDP=$(tshark -r 1.pcap  -T fields -e frame.time -e ip.dst -Y "ip.dst==$ip  and udp"| wc -l) 
receiveTCP=$(tshark -r 2.pcap  -T fields -e frame.time -e ip.dst -Y "ip.dst==$ip  and tcp"| wc -l) 
echo sendUDP: $sendUDP >> results 
echo sendTCP: $sendTCP >> results 
echo receiveUDP: $receiveUDP >> results 
echo receiveTCP: $receiveTCP >> results 
tshark -T fields -e frame.time_delta -e data -r 1.pcap >> pcap.txt 
echo delayUDP: >> results 
python3 getDelay.py 
rm -rf pcap.txt 
tshark -T fields -e frame.time_delta -e data -r 2.pcap >> pcap.txt 
echo delayTCP: >> results 
python3 getDelay.py 
rm -rf pcap.txt 
mv results Platfrom_localhost_Result 
echo done!