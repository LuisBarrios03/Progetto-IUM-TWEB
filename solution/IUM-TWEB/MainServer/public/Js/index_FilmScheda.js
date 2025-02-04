
async function fetchFilmData() {
    try {
        const movieId = getMovieIdFromUrl();
        if (!movieId) {
            throw new Error('ID del film non trovato nell\'URL.');
        }

        const response = await axios.get(`http://localhost:8080/movies/id/${movieId}`);
        const responseDataCountries = await axios.get(`http://localhost:8080/countries/id/${movieId}`);
        const responseDataCrews = await axios.get(`http://localhost:8080/crews/id/${movieId}`);
        const responseDataThemes = await axios.get(`http://localhost:8080/themes/id/${movieId}`);
        console.log(responseDataThemes);
        const film = response.data[0];
        const countries = responseDataCountries;
        const DataCrews = responseDataCrews.data;


        document.getElementById("filmRelease").innerText = film.date;
        document.getElementById('filmTitle').innerText = film.name;
        document.getElementById('filmPoster').src = film.posters.link;
        document.getElementById('filmDuration').innerText = film.minute + " minuti";
        document.getElementById('filmRating').innerText = film.rating.toFixed(2);
        let rating = film.rating !== null ? film.rating : 0;
        let stars = generateStars(rating);
        document.getElementById("startRating").innerHTML = stars;
        document.getElementById('filmDescription').innerText = film.description;

        const genres = film.genre.map(genre => `${genre.genre}`).join(', ');
        document.getElementById('FilmGenre').innerText = genres;

        const actors = film.actors.map(actor =>
            `<a href="/Actors?name=${actor.name}" class="text-primary">${actor.name}</a> as ${actor.role}`
        ).join(', ');
        document.getElementById('filmActors').innerHTML = actors;

        const language = film.languages.map(language => `${language.language}`).join(', ');
        document.getElementById('filmLanguage').innerText = language;

        const crews = DataCrews.map(crew => `${crew.name} as ${crew.role}`).join(', ');
        document.getElementById('crewDescription').innerText = crews;

        const studios = film.studio.map(studio => `${studio.studio}`).join(', ');
        document.getElementById('filmStudio').innerText = studios;

        /*const country = countries.country.map(country =>`${country.country}` ).join(', ');*/
        const country  = countries.data.map(country => `${country.country}`).join(', ');
        document.getElementById('filmCountry').innerText = country;


    } catch (error) {
        console.error('Errore nel caricamento dei dati del film:', error);
    }
}
function generateStars(rating) {
    let stars = "";
    const fullStars = Math.floor(rating); // Numero di stelle piene
    const halfStar = rating % 1 !== 0; // Verifica se c'è una mezza stella
    const emptyStars = 5 - fullStars - (halfStar ? 1 : 0); // Numero di stelle vuote

    // Aggiungi stelle piene
    for (let i = 0; i < fullStars; i++) {
        stars += '<i class="fas fa-star text-warning"></i>';
    }

    // Aggiungi mezza stella (se necessario)
    if (halfStar) {
        stars += '<i class="fas fa-star-half-alt text-warning"></i>';
    }

    // Aggiungi stelle vuote
    for (let i = 0; i < emptyStars; i++) {
        stars += '<i class="far fa-star text-warning"></i>';
    }

    return stars;
}

function getMovieIdFromUrl() {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get('id');
}

function init() {
    fetchFilmData();
}
