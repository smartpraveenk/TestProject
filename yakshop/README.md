Problem Statement:
YAK-1: As a Yak Shepherd, I want to be able to read in a XML file that contains data
about my herd so that I can query it.
Input herd.xml:
<herd>
<labyak name="Betty-1" age="4" sex="f"/>
<labyak name="Betty-2" age="8" sex="f"/>
<labyak name="Betty-3" age="9.5" sex="f"/>
</herd>
N.B. The age is given in standard Yak years
Your program should take 2 parameters:
1. The XML file to read
2. An integer T, representing the elapsed time in days.
N.B. T=13 means that day 12 has elapsed, but day 13 has yet to begin

Solution:
This a Maven project.
Please import it as a Maven project in Eclipse.
This application contains a  MainApp class with a main method which can be directly run from command prompt or from Eclipse.
Please change parameters of process method to run with different datasets.

This application also contains a Junit class MainAppTest for various methods testing.

The design of this application uses design pattern like Factory and Singleton.
Also it uses the code to interface approach whereas possible to make it extensible for further use cases.

