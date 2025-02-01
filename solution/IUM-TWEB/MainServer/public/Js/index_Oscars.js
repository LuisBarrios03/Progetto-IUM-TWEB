

async function loadOscarsData(){
    try{
        const response = await axios.get("http://localhost:3001/api/20dataOscar");
        const oscars = response.data;
        console.log(oscars);

        if(oscars.length === 0){
            document.getElementById("carica20Os").disabled = true;
        }else{
            document.getElementById("movieName").innerText = (oscars.film) ? oscars.film : "unknown";
            document.getElementById("movieYear").innerText = "Anno di rilascio del film: " + (oscars.year_film) ? oscars.year_film : "unknown";
            document.getElementById("nominato").innerText = "Categoria del nominato: " + (oscars.category) ? oscars.category : "unknown";
            document.getElementById("nomeNom").innerText = "Nome del nominato: " + (oscars.name) ? oscars.name : "unknown name";
            document.getElementById("vincitore").innerText = "Vincitore? " + (oscars.winner) ? "sì" : "no";
            document.getElementById("annoNom").innerText = "Anno nomina: " + (oscars.year_ceremony) ? oscars.year_ceremony : "unknown";
            document.getElementById("nCer").innerText = "Numero totale delle cerimonie svolte: " + (oscars.ceremony) ? oscars.ceremony : "unknown";
        }

    }catch(error){
        console.error("Errore nel recupero degli oscar: ", error);
        document.getElementById("OscarsContainer").innerHTML = `<div class="alert alert-danger" role="alert">Errore nel caricamento degli oscars. Riprova più tardi.</div>`;
    }

}
function init() {
    loadOscarsData();
}

// Carica i primi 20 Oscar al caricamento della pagina
document.addEventListener("DOMContentLoaded", loadOscarsData);

// Aggiungi evento per il bottone "Carica Altro"
document.querySelector(".btn-primary").addEventListener("click", loadOscarsData);
