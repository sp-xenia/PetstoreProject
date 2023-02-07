# Petstore server

Questo server è stato generato automaticamente usando un descrittore swagger. Il descrittore viene usato per descrivere i servizi offerti da un modulo. L'applicazione 

* https://editor.swagger.io 

mette a disposizione un editor capace di creare descrittori di servizi REST.

Questo server è stato generato dal progetto [swagger-codegen](https://github.com/swagger-api/swagger-codegen).
Utilizzando [OpenAPI-Spec](https://github.com/swagger-api/swagger-core), si puoi facilmente generare uno stub del server nel linguaggio o framework che si preferisce.

## Descrizione dell'attività
L'applicazione può essere avviata eseguendo la classe PetstoreApplication. 
Ad avvio ultimato, le API offerte dal modulo saranno descritte ai seguenti indirizzi:

* http://localhost:8080/api/v3/swagger-ui/: visualizzazione della API mediante interfaccia grafica Swagger. Da questa interfaccia sarà anche possibile richiamare i servizi offerti dal modulo
* http://localhost:8080/api/v3/api-docs: visualizzazione del descrittore OpenApi dei servizi offerti. Questo descrittore può essere utilizzato per la creazione automatica di client

Puoi cambiare i parametri di configurazione intervenendo sul file di configurazione chiamato application.properties.

Estendi questo servizio per creare una versione funzionante delle API con tag
* PET
* STORE

ingnora, invece, la sezione USER.

Per creare una versione funzionante di queste API devi:
* Configurare l'accesso a un database
	* Se utilizzi H2, allora abilita anche la console così puoi consultare il contenuto del DB. Attenzione, visto che il context path viene sovrascritto, nell'esempio la console sarà disponibile al seguente indirizzo: http://localhost:8080/api/v3/h2-console
* Creare il modello dati modificando gli oggetti attualmente presenti nel package it.xenia.petstore.model
* Creare i repository
* Creare i servizi che fanno uso dei repository e consentono l'esecuzione delle operazioni CRUD sul DB
* Abilitare la ricerca di Entità, Repository e Servizi modificando le annotazioni nella classe PetstoreApplication
* Utilizzare i servizi nei controller per implementarne le funzionalità

Dopo aver creato le parti necessarie per far funzionare il tuo sistema, puoi fare dei test utilizzando l'interfaccia grafica disponibile al link http://localhost:8080/api/v3/swagger-ui/

Infine, prova ad utilizzare Postman per accedere ai servizi offerti dalla tua applicazione. Per poter usare Postman:
* scaricalo e installalo
* accedi al link http://localhost:8080/api/v3/api-docs e salva su file il descrittore
* carica il descrittore in Postman, così avrai già tutti gli stub di chiamata ai tuoi servizi
* fai qualche chiamata di prova per capire come funziona il tutto

