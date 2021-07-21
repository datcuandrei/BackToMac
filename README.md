# <div align = center><h1>BackToMac</h1></div>
An automated utility for Linux that creates bootable macOS USB sticks.

Table of Contents
=================

* [Features](#features)
    * [Graphical User Interface](#graphical-user-interface)
    * [Patchers](#patchers)
    * [Original macOS Images](#original-macos-images)
    * [Custom OS Images](#custom-os-images)
* [LICENSE](#license)
* [Requirements](#requirements)
* [Download](#download)
* [How to install](#how-to-install)
    * [Portable use](#portable-use)
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

### Original macOS Images
By default, BackToMac automatically uses images that are patched to work on both supported and unsupported Macs. If, however, the user wants to use an original, untouched image of macOS, they can be easily downloaded using the link below:
<br/>
<b>macOS Catalina</b> : *through app store* <br>
<b>macOS Mojave</b> : *through app store* <br>
<b>macOS High Sierra</b> : *through app store* <br>
<b>macOS Sierra</b> : http://updates-http.cdn-apple.com/2019/cert/061-39476-20191023-48f365f4-0015-4c41-9f44-39d3d2aca067/InstallOS.dmg <br>


Not included with BackToMac, but can be flashed with ease : <br>
<b>OS X El Capitan</b> : http://updates-http.cdn-apple.com/2019/cert/061-41424-20191024-218af9ec-cf50-4516-9011-228c78eda3d2/InstallMacOSX.dmg <br>
<b>OS X Yosemite</b> : http://updates-http.cdn-apple.com/2019/cert/061-41343-20191023-02465f92-3ab5-4c92-bfe2-b725447a070d/InstallMacOSX.dmg <br>
*taken from the [HT211683](https://support.apple.com/en-us/HT211683) support page.*

These images can be flashed using the `Custom OS Images` option.

### Custom OS Images
With the release of version 1.2.0,BackToMac supports flashing custom OS images.Users can now create USB sticks with their own image files.(thanks to @Minh-Ton for the idea.).

The flashing process is based on `dd`, so all formats that `dd` supports will work with BackToMac.

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

# How to install
- To install the application,open terminal,``cd path/to/extracted/app``,and then run :
```bash
$ sudo sh installbacktomac
```

After the installation is done,simply run `backtomac`,or search for it using an application finder.
If the app doesn't launch,use `sudo java -jar /opt/BackToMac/BackToMac.jar` in the terminal instead.

- To uninstall the application,open terminal,``cd path/to/extracted/app``,and then run :
```bash
$ sudo sh uninstallbacktomac
```

## Portable use
To use BackToMac without installing it,after extracting it,open terminal and
```bash
$ cd path/to/extracted/app
$ sudo java -jar BackToMac.jar
```

## Step by step instructions
For step-by-step instructions on how to successfully create a bootable USB,see [INSTRUCTIONS](https://github.com/datcuandrei/BackToMac/blob/master/INSTRUCTIONS.md).

## Permission denied 
This error occures when the user does not have enough privileges to access the program.
In this case,we need to get ownership of the app by typing :
```bash
$ chmod +x /bin/backtomac
$ chmod +x /opt/BackToMac/BackToMac.jar
```
or if you run BackToMac as portable :
```bash
$ cd path/to/extracted/app
$ chmod +x BackToMac.jar
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
