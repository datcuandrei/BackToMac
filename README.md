# <div align = center><h1>BackToMac</h1></div>
An automated utility for Linux that creates bootable macOS USB sticks.

Table of Contents
=================

* [Features](#features)
    * [Graphical User Interface](#graphical-user-interface)
    * [Patchers](#patchers)
* [LICENSE](#license)
* [Requirements](#requirements)
* [Download](#download)
* [How to use](#how-to-use)
    * [Permission denied](#permission-denied)
    * [Step by step instructions](#step-by-step-instructions)
* [Issues](#issues)
* [Attribution](#attribution)

# Features
### Graphical User Interface
BackToMac is the only application on Linux that was made specifically for creating bootable macOS USBs.And it also has a GUI.

<img src="https://raw.githubusercontent.com/datcuandrei/BackToMac/master/captures/mainmenu.png" width=70% height=70% />

*also has dark mode*

<img src="https://raw.githubusercontent.com/datcuandrei/BackToMac/master/captures/dark.png" width=70% height=70% />

> For more images,go to the `captures` folder found in this repo.

### Patchers
BackToMac was created with both supported and unsupported Macs in mind.After going through the instructions,the user can choose between two patchers from two different developers : dosdude1 and RMC.
For users that have a supported Mac,their choice won't make a difference,since no patches will be applied to their system.

Special thanks go to [**dosdude1**](https://www.dosdude1.com/) and [**RMC Team**](https://rmc-team.github.io).Without their contribution,this feature would not have been possible.

> The program is pretty straight forward and easy to use.It only requires a few clicks to get the job done!

# LICENSE
This project is licensed under the Apache 2.0 license. View LICENSE.md to learn more.

# Requirements
- Latest Java version.

# Download
- Installing the latest version of Java is as simple as opening the terminal and typing :

##### Debian,Ubuntu-based :
```bash
$ sudo apt-get update
$ sudo apt install default-jdk
```

##### Arch-based :
```bash
$ sudo pacman -S jdk-openjdk
```

##### Fedora, Oracle Linux, Red Hat Enterprise Linux, etc. : 
```bash
$ sudo dnf search openjdk
```
Choose the desired JDK and then install it :

```bash
$ sudo dnf install java-11-openjdk.x86_64
```

- After installing Java,download the latest version available in [releases](https://github.com/datcuandrei/BackToMac/releases).
- Extract it where you want the application to be installed.

# How to use
- To start the application,open terminal,``cd path/to/extracted/app``,and then run :
```bash
$ sh backtomac.sh
```
It can also run under dark mode :
```bash
$ sh backtomac.sh d
```

## Step by step instructions
For step-by-step instructions on how to successfully create a bootable USB,see [INSTRUCTIONS](https://github.com/datcuandrei/BackToMac/blob/master/INSTRUCTIONS.md)

## Permission denied 
This error occures when the user does not have enough privileges to access the program.
In this case,we need to get ownership of the app by typing :
```bash
$ chmod +x backtomac.sh
```
After that you can run the app using the commands provided above.

# Issues
If you find issues while running the app,please report them in the [issues](https://github.com/datcuandrei/BackToMac/issues) section.

# Attribution 
BackToMac was made possible thanks to the following technologies and people :
- [**dosdude1**](https://www.dosdude1.com/) - responsible for macOS Patchers.
- [**RMC Team**](https://rmc-team.github.io) - responsible for macOS Patchers.
- [**FlatLaf**](https://www.formdev.com/flatlaf/) - library responsible for the look and feel.
- [**Apache Commons IO**](https://commons.apache.org/proper/commons-io/) - library responsible for downloading files and status.
- Special thanks to the [**Unsupported Macs**](https://discord.gg/XbbWAsE) community.
