BuddyCam
========
This is an Open Source reboot of BuddyCam. A Minecraft-Mod which allows you to see the View of a Buddy...

[Closed Source 1.6.2 (and earlier) Version](http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-mods/wip-mods/1440491-1-6-2-buddycam-minecraft-mod-by-romibi)

## ToDo:
- re-implement everything

## How to help development

###Rules:
- do not implement new functions yet... (I want to make sure most of the old 1.6.2 functionality is re-implemented)
- contact me (I know that's a bit tricky...)

###How to setup and use the workspace:
(I really hope you have already done 1-3...)

1. [Install JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) 
2. [Get eclipse](https://www.eclipse.org/downloads/)
3. [Set up Git](https://help.github.com/articles/set-up-git/)
4. Clone this Repository to where you want
5. Setup Workspace
  - Windows:
    1. Shift-Right-Click in the Folder and "Open Command Window here"
    2. `setup.bat`
  - Linux/Mac:
    1. Open the Terminal
    2. Go to the correct Directory with cd
    3. `./setup.sh`
    4. If it doesn't work: `sudo chmod +x setup.sh` and `sudo chmod +x gradlew` and repeat c
6. Open the eclipse-Folder with Eclipse
7. Develop
8. run `gradlew.bat compile` or `./gradlew compile` (see 5.)
9. Optional: Commit/Pull request
