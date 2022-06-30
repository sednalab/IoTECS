# IoTECS -- IoT Edge-to-Cloud Simulation
-----------------------------------------------------------------
IoTECS (IoT Edge-to-Cloud Simulation) is an Domain Specific Language (DSL) for Simulation-Based Testing of IoT Edge-to-Cloud Solutions. Building on the conceptual model shown below, IoTECS adapts Xtext`s grammar language to define its grammar. Then, Xtend is used to retrieve all the objects defined in a IoTECS specification; these objects in turn drive the instantiation of a number of a-priori-defined Xtend templates in order to generate executable simulators as the output of IoTECS.

<p align="center">
  <img src="https://github.com/JiaLi123456/IoTECS/blob/main/conceptualModel.png" width="719" height="472" class="centerImage" />
</p>

The concepts in the above conceptual model are arranged under two packages:
* ```Edge Layer```: contains simulation time management, Simulation Architecture Management and Simulated Devices.
* ```Cloud Layer```: contains cloud applications under stress testing. The information required by IoTECS about these clouds are their IP addresses and port numbers. IoTECS can help to create a baseline cloud application which simply receives packets sending from edge devices and sends them back. Name of the network adapter is required because wireshark will be working to capture the packets coming in and out the network adapter.

License 
--------------------------------------------
GPL 2.0+

Content Description
----------------------------------------------
Folders:
* ```IoTECS.zip```: contains the code of IoTECS DSL and the files we need to build the DSL. Grammar of IoTECS is in IoTECS.zip->iotecs->src->iotecs->IoTECS.xtext.
* ```Demonstration```: contains the demonstration IoTECS project.
* ```Analyzation```: contains the scripts to analyse the results of the simulations.
* ```Results```: contains two subfolders: ```RQ1``` and ```RQ2```. These folders contain the results of each research question.

Prerequisite
---------------------------------------------
* Eclipse 2021-12
* Virtual Box 6.1
* Docker 20.10.11
* Xtext 2.25.0 (https://www.eclipse.org/Xtext/)
* Xtend 2.25.0 (https://www.eclipse.org/Xtend/)
* Ubuntu 20.04 disc image (https://ubuntu.com/download/desktop)
* TShark (Wireshark) 3.4.9
* Python 3.8.8


Installation Instructions
--------------------------------------------
The following steps show how to use IoTECS to generate code for performing simulation-based testing for IoT Cloud applications.
1. Open all the five projects in IoTECS.zip in Eclipse. 
2. Go to iotecs->src->iotecs->IoTECS.xtext, run as generate Xtext artifacts. 
3. Go to iotecs->src->iotecs->GenerateIoTECS.mwe2, run as MWE2 workflow.
5. Run the DLS project (iotecs) as Eclipse Applications and launch runtime Eclipse.
6. Create linux-based (Ubuntu 20.04) virtual machines for each platform whose type is "VM".
7. Install python and tshark on the local machine and all remote platforms.
8. Create a java project on the runtime Eclipse Platform and new a file with a suffix of "iot" (e.g., test.iot). Choose "yes" when a window called "Congifure Xtext" popped out asking "Do you want to convert 'test' to an Xtext project?". Input the specific instance of conceptual model for IoTECS according to the grammar. Or use the demonstration IoTECS project provided in Demonstration.
9. Save the file in step 8 and the code and scripts are generated in a directory called "src-gen" of the project in step 8 (e.g., test->src-gen).
10. Go to the generated directory of the IoTECS project (src-gen/) and run main.sh.
