# IoTECS -- IoT Edge-to-Cloud Simulation
-----------------------------------------------------------------
IoTECS (IoT Edge-to-Cloud Simulation) is an Domain Specific Language (DSL) for Simulation-Based Testing of IoT Edge-to-Cloud Solutions. Building on the conceptual model shown below, IoTECS adapts Xtext`s grammar language to define its grammar. Then, Xtend is used to retrieve all the objects defined in a IoTECS specification; these objects in turn drive the instantiation of a number of a-priori-defined Xtend templates in order to generate executable simulators as the output of IoTECS.

<p align="center">
  <img src="https://github.com/JiaLi123456/IoTECS/blob/main/ConceptualModel.png" width="719" height="472" class="centerImage" />
</p>

License 
--------------------------------------------
add license here

Content Description
----------------------------------------------
Folders:
* ```IoTECS```: contains the code of IoTECS and the files we need to build the DSL.
* ```Demonstration```: contains the demonstration project of how to use the IoTECS DSL.
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


Installation Instructions
--------------------------------------------
The following steps show how to use IoTECS to generate code for performing simulation-based testing for IoT Cloud applications.
