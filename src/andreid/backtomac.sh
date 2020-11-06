#!/bin/bash

#
# backtomac.sh
#
# Copyright 2020 Andrei Datcu <@datcuandrei>
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
#
#


echo "BackToMac will now ask you for your password.
This is required for the program in order to run properly.If you have already entered it,the program will run without prompting it again."

sudo su <<HERE

echo "Running BackToMac..."

if [ "$1" = "d" ]; then 
    java -jar dark.jar
else
    java -jar light.jar    
fi

HERE
