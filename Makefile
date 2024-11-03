all:
	javac *.java
	
run-server: all
	java admServidor.java

run-agencia: all
	java agenciaCliente.java

	$(MAKE) clean

run-caixa: all
	java caixaAutoCliente.java $(id)

	$(MAKE) clean

clean:
	rm -f *.class
	
	clear