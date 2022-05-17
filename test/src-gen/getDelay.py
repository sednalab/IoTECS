import os
file1=open("pcap.txt","r")
lines=file1.readlines()
file2=open("pcap.txt","r")
delay=0.0
lines2=file2.readlines()
count=0
for line in lines:

	lineSplit=line.split("\t")[1]
	if (lineSplit.strip()!=""):
		for line2 in lines2:
			if (line2!=line):
				line2Split=line2.split("\t")[1]
				if (lineSplit==line2Split):
					delay=delay+abs(float(line.split("\t")[0])-float(line2.split("\t")[0]))
					count=count+1
					lines2.pop(lines2.index(line))
					lines2.pop(lines2.index(line2))
file1.close()
file2.close()
fileOut=open("results","a")
fileOut.write(str(delay/count)+"\n")
fileOut.close()
