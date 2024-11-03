all:
	javac *.java

run-server: all
	java admServidor.java

clear:
	rm *.class

	clear