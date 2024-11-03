all:
	javac *.java
	
run-server: all
	java admServidor.java

run-agencia:
	java agenciaCliente.java

	$(MAKE) clean

run-caixa: 
	java caixaAutoCliente.java $(id)

	$(MAKE) clean

run-concorrencia:
	java TesteConcorrencia.java

run-falhas:
	java injecaoFalhas.java

clean:
	rm -f *.class
	
	clear