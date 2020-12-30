<html><head></head><body>
		<div align="center">
			<h1>Before continuing</h1>
			<h2>Please read the following instructions carefully.</h2>
			<br>
						<p>• BackToMac will give the best results if ran natively(either installed on your system,or through a live distro).
				<br>Running the program through a VM will most likely result in a non-working USB installation.
			</p>
			<p>• If you haven't inserted your USB drive,it would be a good time to do so.</p>
			<p>• Format the USB drive.I recommend you format it as NTFS with the partition table set as GPT.
				<br>BackToMac will automatically change the file system to the one required once the flashing process begins.(HFS+)
			</p>
			<p>• After you hit the \"Proceed\" button,BackToMac will ask you which patcher you want to use.</p>
			<p>The patchers are created for unsupported Macs.
				<br>If you are on a supported machine,the patcher you choose will not affect the way your Mac works.
				</p>
				<p>Special thanks go to 
					<b>dosdude1</b> and 
					<b>RMC</b>(See \"Attribution\" for more info.)
				</p>
				<p>• After the download has been finished,BackToMac will show you a list of connected USB devices.</p>
				<p>If you don't know which one is your USB 
					<b>disk</b>,open a new terminal window and use 
					<b>lsblk</b>.
				</p>
				<img alt="Drive label example" src="https://raw.githubusercontent.com/datcuandrei/BackToMac/master/resources/lsblk.jpg">
					<p>As you can see,in my case 
						<b>sdc</b> is the label of my USB drive.Note that the label is 
						<b>disk</b> and not the 
						<b>part</b>.
					</p>
					<p>• The process will take a a long time,so let the program run.It will let you know when it is done.</p>
					<p>• BackToMac will safely unmount your drive and ask you if you want to delete the OS image after the process is done.</p>
		</div>
	
</body></html>
