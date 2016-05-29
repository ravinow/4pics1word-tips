all:
	cd target/classes && jar cfe ../../guess-word-1.0.jar com.sshwind.Main *
clean:
	rm guess-word-1.0.jar