
let currentPage = 0;
const moviesPerPage = 9;
let allMovies = [];





// Mostra/nasconde la barra dei filtri
function toggleFilters() {
    let filters = document.getElementById("filters");
    filters.style.display = (filters.style.display === "none" || filters.style.display === "") ? "block" : "none";
}

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
        let response = await axios.get(`http://localhost:8080/movies/search${queryString}`);
        allMovies = response.data;

    } catch (error) {
        console.error("Errore nella ricerca dei film:", error);
    }
}
function displayMovies() {
    let resultsContainer = document.getElementById("resultsContainer");
    resultsContainer.innerHTML = ""; // Clear previous results

    let start = currentPage * moviesPerPage;
    let end = start + moviesPerPage;
    let moviesToLoad = allMovies.slice(start, end);

    moviesToLoad.forEach(film => {
        let card = document.createElement("div");
        card.classList.add("col-md-4", "mb-3");
        card.innerHTML = `
            <div class="card">
                <img src="${film.posters.link}" class="card-img-top" alt="${film.name}">
                <div class="card-body">
                    <h5 class="card-title">${film.name}</h5>
                    <p class="card-text"><strong>Genere:</strong> ${film.genre.map(g => g.genre).join(", ")}</p>
                    <p class="card-text"><strong>Anno:</strong> ${film.date}</p>
                    <p class="card-text"><strong>Durata:</strong> ${film.minute} min</p>
                    <a href="movie-details.html?id=${film.id}" class="btn btn-primary">Dettagli</a>
                </div>
            </div>
        `;
        resultsContainer.appendChild(card);
    });

    updatePaginationControls();
}

function updatePaginationControls() {
    const totalPages = Math.ceil(allMovies.length / moviesPerPage);
    const paginationContainer = document.getElementById("paginationContainer");
    paginationContainer.innerHTML = ""; // Clear current pagination

    if (currentPage > 0) {
        let prevButton = document.createElement("button");
        prevButton.textContent = "Precedente";
        prevButton.classList.add("btn", "btn-secondary");
        prevButton.onclick = () => {
            currentPage--;
            displayMovies();
        };
        paginationContainer.appendChild(prevButton);
    }

    if (currentPage < totalPages - 1) {
        let nextButton = document.createElement("button");
        nextButton.textContent = "Successivo";
        nextButton.classList.add("btn", "btn-secondary");
        nextButton.onclick = () => {
            currentPage++;
            displayMovies();
        };
        paginationContainer.appendChild(nextButton);
    }
}

function loadMoreMovies() {
    let resultsContainer = document.getElementById("resultsContainer");
    let start = currentPage * moviesPerPage;
    let end = start + moviesPerPage;
    let moviesToLoad = allMovies.slice(start, end);

    moviesToLoad.forEach(film => {
        let card = document.createElement("div");
        card.classList.add("col-md-4", "mb-3");
        card.innerHTML = `
            <div class="card">
                <img src="${film.posters.link}" class="card-img-top" alt="${film.name}">
                <div class="card-body">
                    <h5 class="card-title">${film.name}</h5>
                    <p class="card-text"><strong>Genere:</strong> ${film.genre.map(g => g.genre).join(", ")}</p>
                    <p class="card-text"><strong>Anno:</strong> ${film.date}</p>
                    <p class="card-text"><strong>Durata:</strong> ${film.minute} min</p>
                    <a href="movie-details.html?id=${film.id}" class="btn btn-primary">Dettagli</a>
                </div>
            </div>
        `;
        resultsContainer.appendChild(card);
    });

    currentPage++;
    if (currentPage * moviesPerPage >= allMovies.length) {
        document.getElementById("loadMoreButton").style.display = "none";
    } else {
        document.getElementById("loadMoreButton").style.display = "block";
    }
}