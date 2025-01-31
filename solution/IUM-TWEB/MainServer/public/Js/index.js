function toggleFilters() {
    var filters = document.getElementById("filters");
    filters.style.display = (filters.style.display === "none" || filters.style.display === "") ? "block" : "none";
}

async function loadFilmsWithCarousel() {
    try {
        const response = await axios.get('http://localhost:8080/movies/latest-releases');
        const carouselInner = document.getElementById("carousel-inner");
        const carouselIndicators = document.getElementById("carousel-indicators");

        // Svuota i contenitori
        carouselInner.innerHTML = "";
        carouselIndicators.innerHTML = "";

        response.data.forEach((movie, index) => {
            let isActive = index === 0 ? "active" : "";
            if(movie.posterUrl == null){
                movie.posterUrl = "https://a.ltrbxd.com/resized/film-poster/6/4/1/9/6/1/641961-bullet-train-0-230-0-345-crop.jpg?v=9245faa1ba";
            }            // Creazione della slide
            let item = `
                <div class="carousel-item ${isActive}">
                    <img src="${movie.posterUrl}" class="d-block w-100" style="height: 450px; object-fit: cover;" alt="${movie.name}">
                    <div class="carousel-caption">
                        <h5>${movie.name}</h5>
                        <p>${movie.description}</p>
                    </div>
                </div>`;
            carouselInner.innerHTML += item;

            // Creazione degli indicatori
            let indicator = `<button type="button" data-bs-target="#carouselExampleCaptions" 
                                data-bs-slide-to="${index}" class="${isActive}" 
                                aria-label="Slide ${index + 1}"></button>`;
            carouselIndicators.innerHTML += indicator;
        });

    } catch (error) {
        console.error("Errore nel recupero dei film:", error);
    }
}

async function loadMovieDetails() {
    try {
        const response = await axios.get("http://localhost:8080/movies/TopRate");
        const movies = response.data;

        let cardsHTML = "";
        movies.forEach(movie => {
            let posterUrl = (movie.posters.link != null) ? movie.posters.link : "https://a.ltrbxd.com/resized/film-poster/6/4/1/9/6/1/641961-bullet-train-0-230-0-345-crop.jpg?v=9245faa1ba";
            let rating = movie.rating !== null ? movie.rating : 0;
            let stars = generateStars(rating);
            cardsHTML += `
                <div class="col-md-4">
                    <div class="card shadow-lg p-3 mb-5 bg-white rounded">
                        <img src="${posterUrl}" class="card-img-top" alt="${movie.name}">
                        <div class="card-body">
                            <h5 class="card-title">${movie.name}</h5>
                            <p>${stars}</p>
                            <a href="movie-details.html?id=${movie.id}" class="btn btn-primary">Dettagli</a>
                        </div>
                    </div>
                </div>`;
        });

        document.getElementById("movies-container").innerHTML = `<div class="row">${cardsHTML}</div>`;

    } catch (error) {
        console.error("Errore nel recupero dei film:", error);
        // Mostra un messaggio di errore all'utente
        document.getElementById("movies-container").innerHTML = `<div class="alert alert-danger" role="alert">Errore nel caricamento dei film. Riprova più tardi.</div>`;
    }
}

function generateStars(rating) {
    let stars = "";
    for (let i = 1; i <= 5; i++) {
        if (i <= rating) {
            stars += '<i class="fas fa-star text-warning"></i>'; // Stella piena
        } else {
            stars += '<i class="far fa-star text-warning"></i>'; // Stella vuota
        }
    }
    return stars;
}
document.addEventListener("DOMContentLoaded", loadMovieDetails);
function init() {
    loadFilmsWithCarousel();
    loadMovieDetails();
}

