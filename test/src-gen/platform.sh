#!/bin/bash 
cd SN1 
mvn compile 
mvn package assembly:single
cd .. 
cp -r SN1 SN1_1 
cp -r SN1 SN1_2 
cp -r SN1 SN1_3 
cp -r SN1 SN1_4 
mv SN1 SN1_0 
cd SN2 
mvn compile 
mvn package assembly:single
cd .. 
mv SN2 SN2_0 
echo done!