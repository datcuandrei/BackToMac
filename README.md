
## Under maintenance.
Currently,BackToMac is facing some issues related to the OS downloading phase.Those issues will be fixed as soon as possible and an update will be pushed.

## Update
The issues have been identified and will be solved in the shortest time.

# BackToMac
An automated utility for Linux that creates bootable macOS USB sticks.
<img src="https://raw.githubusercontent.com/datcuandrei/BackToMac/master/captures/default.png" width="700" height="391">
<img src="https://raw.githubusercontent.com/datcuandrei/BackToMac/master/captures/dark.png" width="700" height="391">

See [captures](https://github.com/datcuandrei/BackToMac/tree/master/captures) for more images.Please note that *captures* doesn't contain all the images of the program.It only includes the important ones.You will encounter other GUI elements as you use it.(errors,cancel,notifications,etc.)Also,when you set the program to use dark-mode,the whole program will be in dark-mode,not just the main window.

## LICENSE
This project is licensed under the Apache 2.0 license. View LICENSE.md to learn more.

## Requirements:
- Latest Java version.

## Download/How to use : 
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
- To start the application,open terminal,``cd path/to/extracted/app``,and then run :
```bash
$ sh backtomac.sh
```
It can also run under dark mode :
```bash
$ sh backtomac.sh d
```

## Permission denied : 
This error occures when the user does not have enough privileges to access the program.
In this case,we need to get ownership of the app by typing :
```bash
$ chmod +x backtomac.sh
```
After that you can run the app using the commands provided above.

## Issues : 
If you find issues while running the app,please report them in the [issues](https://github.com/datcuandrei/BackToMac/issues) section.

## Thank you, [**dosdude1**](https://www.dosdude1.com/)!
Every version of macOS that is included with BackToMac is patched to work both on officially supported Macs and unsupported Macs.That is thanks to dosdude1's macOS Patchers.

## Attribution : 
BackToMac was made possible thanks to the following technologies and people :
- [**dosdude1**](https://www.dosdude1.com/) - responsible for macOS Patchers.
- [**FlatLaf**](https://www.formdev.com/flatlaf/) - library responsible for the look and feel.
- [**Apache Commons IO**](https://commons.apache.org/proper/commons-io/) - library responsible for downloading files and status.
- Special thanks to the [**Unsupported Macs**](https://discord.gg/XbbWAsE) community.
