
async function loadOscarsData(){
    try{

        // if(oscars.length === 0){
        //     document.getElementById("carica20Os").disabled = true;
        //     document.getElementById("OscarsContainer").innerHTML = `<div class="alert alert-warning" role="alert">Nessun Oscar trovato.</div>`;
        // }

        const response = await axios.get(`http://localhost:3001/api/20dataOscar`);
        const oscars = response.data.data;
        console.log(oscars);

        oscars.forEach(oscar => {
            const card = document.createElement("div");
            card.className = "OscarsContainer";
            card.innerHTML = `
        <div class="container card mt-2 pt-3 px-3 mb-5 d-flex flex-row">
            <div class="col">
                <div class="row mb-2">
                    <div class="col span-5"><strong>Nome del film:</strong><text>${oscar.film}</text></div>
                    <div class="movie-year col span-5"><strong>Anno di rilascio del film:</strong><text>${oscar.year_film}</text></div>
                    <div class="col span-2"><strong>Vincitore?</strong><text>${oscar.winner}</text></div>
                </div>
                <div class="row mb-2">
                    <div class="col span-6"><strong>Categoria del nominato:</strong><text>${oscar.category}</text></div>
                    <div class="col span-6"><strong>Nome del nominato:</strong><text>${oscar.name}</text></div>
                </div>
                <div class="row mb-2">
                    <div class="col span-4"><strong>Anno nomina:</strong><text>${oscar.year_ceremony}</text></div>
                    <div class="col span-4"><strong>Numero cerimonie:</strong><text>${oscar.ceremony}</text></div>
                    <div class="col span-4"></div>
                </div>
            </div>
        </div>
    `;
            document.getElementById("OscarsContainer").appendChild(card);
        });

    }catch(error){
        console.error("Errore nel recupero degli oscar: ", error);
        document.getElementById("OscarsContainer").innerHTML = `<div class="alert alert-danger" role="alert">Errore nel caricamento degli oscars. Riprova più tardi.</div>`;
    }

}
function init() {
    loadOscarsData();
}


// Aggiungi evento per il bottone "Carica Altro"
document.querySelector(".btn-primary").addEventListener("click", loadOscarsData);
