function toggleFilters() {
    var filters = document.getElementById("filters");
    filters.style.display = (filters.style.display === "none" || filters.style.display === "") ? "block" : "none";
}

async function loadFilmsWithCarousel() {
    try {
        const response = await axios.get('http://localhost:8080/movies/recent');
        const carouselInner = document.getElementById("carousel-inner");
        const carouselIndicators = document.getElementById("carousel-indicators");

        // Svuota i contenitori
        carouselInner.innerHTML = "";
        carouselIndicators.innerHTML = "";

        response.data.forEach((movie, index) => {
            let isActive = index === 0 ? "active" : "";

            // Creazione della slide
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
    const urlParams = new URLSearchParams(window.location.search);
    const movieId = urlParams.get("id");

    try {
        const response = await axios.get(`http://localhost:8080/movies/TopRate`);
        const movie = response.data;

        let stars = generateStars(movie.rating);

        let detailsHTML = `
                    <div class="row">
                        <div class="col-md-4">
                            <img src="${movie.posterUrl}" class="img-fluid rounded shadow" alt="${movie.name}">
                        </div>
                        <div class="col-md-8">
                            <h2>${movie.name}</h2>
                            <p>${stars}</p>
                            <p>${movie.description}</p>
                            <a href="index.html" class="btn btn-secondary">Torna indietro</a>
                        </div>
                    </div>`;

        document.getElementById("movie-details").innerHTML = detailsHTML;
    } catch (error) {
        console.error("Errore nel recupero del film:", error);
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

//document.addEventListener("DOMContentLoaded", loadMovieDetails);

function init() {
    loadFilmsWithCarousel();
    //  loadMovieDetails();
}

