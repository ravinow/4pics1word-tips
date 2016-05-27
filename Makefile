.ONESHELL:
all:
	cd bin
	cp ../dictionaries/chn.txt .
	jar cfe ../guess-word-1.0.jar com.sshwind.Main *
	rm chn.txt
clean:
	rm guess-word-1.0.jar