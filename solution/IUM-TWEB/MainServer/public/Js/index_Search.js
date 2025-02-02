
let currentPage = 0;
const moviesPerPage = 9;
let allMovies = [];





// Mostra/nasconde la barra dei filtri
function toggleFilters() {
    let filters = document.getElementById("filters");
    filters.style.display = (filters.style.display === "none" || filters.style.display === "") ? "block" : "none";
}
document.addEventListener("DOMContentLoaded", async function () {
    const genreSelect = document.getElementById("searchGenre");

    try {
        let response = await fetch("http://localhost:8080/genres/getAllGenres");
        let genres = await response.json(); // Supponendo che la risposta sia un array di stringhe
        console.log(genres);
        // Aggiungi l'opzione di default
        let defaultOption = document.createElement("option");
        defaultOption.value = "";
        defaultOption.textContent = "Tutti i generi";
        genreSelect.appendChild(defaultOption);

        // Aggiungi le opzioni dei generi
        genres.forEach(genre => {
            let option = document.createElement("option");
            option.value = genre.id;
            option.textContent = genre.genre;
            genreSelect.appendChild(option);
        });
    } catch (error) {
        console.error("Errore nel caricamento dei generi:", error);
    }
});


async function searchMovies() {
    try {
        let title = document.getElementById("searchTitle").value;
        let genre = document.getElementById("searchGenre").value;
        let duration = document.getElementById("searchDuration").value;
        let rating = document.getElementById("searchRating").value;
        let year = document.getElementById("searchYear").value;

        let queryParams = [];
        if (title) queryParams.push(`title=${encodeURIComponent(title)}`);
        if (genre && genre !== "Genere") queryParams.push(`genre=${encodeURIComponent(genre)}`);
        if (duration) queryParams.push(`duration=${encodeURIComponent(duration)}`);
        if (rating) queryParams.push(`rating=${encodeURIComponent(rating)}`);
        if (year) queryParams.push(`year=${encodeURIComponent(year)}`);

        let queryString = queryParams.length > 0 ? `?${queryParams.join("&")}` : "";

        window.location.href = `/FilmSearched${queryString}`;

    } catch (error) {
        console.error("Errore nella ricerca dei film:", error);
    }
}