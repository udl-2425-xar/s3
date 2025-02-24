# Sessió 3 (24/02)

## Part 1

### Example1.java
Fer un exemple de threads concurrents en què es disparin 5 threads.
Cadascun ha de fer un bucle de 5 passades en que imprimerix qui és + el número de segon que és i espera 1 segon.
Fer la creació del thread passant-li el nom del thread.

### Example2.java
Modificació: enviar-li al thread el seu identificador com a paràmetre via constructor.

## Part 2

Modificar el xat client-servidor de la sessió 2 perquè el servidor sigui concurrent.

El client no cal adaptar-lo.

El servidor es pot dir `ConcurrentServer.java` i ha de:
- Partir de l’`interactive server` (clonar-lo i refactoritzar-lo).
- Cada vegada que rebi una nova connexió, crear un thread nou.
- Moure el codi d’atenció al client dins del thread.
- Controlar que acaba bé.

Assegura’t de controlar els errors tant en el client com en el servidor (`try-catch`).
