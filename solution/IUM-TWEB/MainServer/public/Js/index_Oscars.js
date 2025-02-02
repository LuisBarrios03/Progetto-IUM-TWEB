let currentPage = 0;
async function loadOscarsData(){
    try{
        // if(oscars.length === 0){
        //     document.getElementById("carica20Os").disabled = true;
        //     document.getElementById("OscarsContainer").innerHTML = `<div class="alert alert-warning" role="alert">Nessun Oscar trovato.</div>`;
        // }else{


        //const response = await axios.get("http://localhost:3001/api/20dataOscar");
        const response = await axios.get(`http://localhost:3001/api/20dataOscar?page=${currentPage}`);
        const oscars = response.data.data;
        console.log(oscars);
        oscars.forEach(oscars => {
            document.getElementById("movie-name").innerHTML = oscars.film;
            document.getElementById("movie-year").innerHTML = oscars.year_film;
            document.getElementById("nominato").innerHTML = oscars.category;
            document.getElementById("nome-nom").innerHTML = oscars.name;
            document.getElementById("vincitore").innerHTML = oscars.winner;
            document.getElementById("anno-nom").innerHTML = oscars.year_ceremony;
            document.getElementById("ncer").innerHTML = oscars.ceremony;
        });
        currentPage++;
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
