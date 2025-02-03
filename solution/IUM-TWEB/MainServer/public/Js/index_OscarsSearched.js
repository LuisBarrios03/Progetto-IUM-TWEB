async function init(){
    const oscarsContainer = document.getElementById("OscarsContainer");
    const queryString = window.location.search;

    try{
        let response = await axios.get(`http://localhost:3001/api/findOscar${queryString}`);
        let oscars = response.data.data;
        console.log(queryString);

        if(!oscars || oscars.length === 0){
            oscarsContainer.innerHTML = "<p class='m-5 text-danger'>Nessun Oscar trovato.</p>";
            return;
        }

        oscarsContainer.innerHTML = ""; // toglie gli altri container
        oscars.forEach(oscar => {
            const card = document.createElement("div");
            card.className = "OscarsContainer";
            card.innerHTML = `
        <div class="container card mt-2 pt-3 px-3 mb-5 d-flex flex-row">
            <div class="col">
                <div class="row mb-2">
                    <div class="col span-5"><strong>Nome del film: </strong><text>${oscar.film}</text></div>
                    <div class="movie-year col span-5"><strong>Anno di rilascio del film: </strong><text>${oscar.year_film}</text></div>
                    <div class="col span-2"><strong>Vincitore: </strong><text>${oscar.winner ? "Sì" : "No"}</text></div>
                </div>
                <div class="row mb-2">
                    <div class="col span-5"><strong>Categoria del nominato: </strong><text>${oscar.category}</text></div>
                    <div class="col span-5"><strong>Nome del nominato: </strong><text>${oscar.name}</text></div>
                    <div class="col span-2"></div>
                </div>
                <div class="row mb-2">
                    <div class="col span-4"><strong>Anno nomina: </strong><text>${oscar.year_ceremony}</text></div>
                    <div class="col span-4"><strong>Cerimonia numero: </strong><text>${oscar.ceremony}</text></div>
                    <div class="col span-4"></div>
                </div>
            </div>
        </div>
    `;
            document.getElementById("OscarsContainer").appendChild(card);
        });


    }catch(error){
        console.error("Errore nel caricamento degli Oscar:", error);
        if (error.response) {
            // Risposta ricevuta con errore (es. 404, 500)
            console.error("Errore nella risposta del server:", error.response.status);
            oscarsContainer.innerHTML = `<p class='m-5 text-danger'>nessun oscar trovato (status: ${error.response.status}).</p>`;
        } else if (error.request) {
            // La richiesta è stata fatta ma non c'è risposta
            console.error("Errore nella richiesta:", error.request);
            oscarsContainer.innerHTML = "<p class='m-5 text-danger'>Errore nella richiesta al server.</p>";
        } else {
            // Altri errori
            console.error("Errore generale:", error.message);
            oscarsContainer.innerHTML = "<p class='m-5 text-danger'>Errore nel caricamento dei film.</p>";
        }
    }

}