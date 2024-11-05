all:
	javac *.java
	
run-server: all
	java admServidor.java

run-agencia:
	java AgenciaCliente.java

	$(MAKE) clean

run-caixa: 
	java CaixaAutoCliente.java $(id)

	$(MAKE) clean

run-concorrencia:
	java TesteConcorrencia.java

run-falhas:
	java InjecaoFalhas.java

clean:
	rm -f *.class
	
	clear