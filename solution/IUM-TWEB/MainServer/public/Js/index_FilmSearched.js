async function init() {
    console.log("Inizializzazione in corso...");
    const movieContainer = document.getElementById("movies-container");

    // Ottieni i parametri della query string
    const queryString = window.location.search;

    try {
        // Debug: mostra la query string
        console.log("Query string:", queryString);

        // Esegui la richiesta con axios
        let response = await axios.get(`http://localhost:8080/movies/search${queryString}`);

        // Verifica che i dati siano presenti
        let movies = response.data;

        if (!movies || movies.length === 0) {
            movieContainer.innerHTML = "<p class='text-danger'>Nessun film trovato.</p>";
            return;
        }

        movieContainer.innerHTML = ""; // Pulisce il contenitore prima di inserire nuovi film

        movies.forEach(movie => {
            const card = document.createElement("div");
            card.classList.add("col-md-4", "mb-3");
            let posterUrl = (movie.link != null) ? movie.link : "https://a.ltrbxd.com/resized/film-poster/6/4/1/9/6/1/641961-bullet-train-0-230-0-345-crop.jpg?v=9245faa1ba";
            let rating = movie.rating !== null ? movie.rating : 0;
            let stars = generateStars(rating);
            card.innerHTML = `
                    <div class="card shadow-lg p-3 mb-5 bg-white rounded">
                        <img src="${posterUrl}" class="card-img-top" alt="${movie.name}">
                        <div class="card-body">
                            <h5 class="card-title">${movie.name}</h5>
                            <p>${stars} ${rating.toFixed(2)}</p>
                            <a href="/FilmScheda?id=${movie.id}" class="btn btn-primary">Dettagli</a>
                        </div>
                    </div>
                </div>`;

            movieContainer.appendChild(card);
        });

        console.log("Film caricati con successo!");
    } catch (error) {
        // Gestione errori con axios
        console.error("Errore nel caricamento dei film:", error);

        // Mostra errore nel DOM
        if (error.response) {
            // Risposta ricevuta con errore (es. 404, 500)
            console.error("Errore nella risposta del server:", error.response.status);
            movieContainer.innerHTML = `<p class='text-danger'>Errore nel caricamento dei film (status: ${error.response.status}).</p>`;
        } else if (error.request) {
            // La richiesta è stata fatta ma non c'è risposta
            console.error("Errore nella richiesta:", error.request);
            movieContainer.innerHTML = "<p class='text-danger'>Errore nella richiesta al server.</p>";
        } else {
            // Altri errori
            console.error("Errore generale:", error.message);
            movieContainer.innerHTML = "<p class='text-danger'>Errore nel caricamento dei film.</p>";
        }
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

